package info.thelaboflieven.gitlabci.model;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class GitlabJob {
    public String name;
    public Script script;
    public String stage = "test";
    public String environment;
    public List<Rule> rules = new ArrayList<>();

    public boolean conditionsMet(Variable[] variables) throws ScriptException {
        if (rules.isEmpty()) {
            return true;
        }

        for (var rule : rules) {
            if (GitlabWhenJobCondition.NEVER.equals(rule.gitlabWhenJobCondition())) {
                continue;
            }
            if (rule.gitlabIfJobCondition().isMet(variables)) return true;
        }
        return false;
    }
}
