package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.model.GitlabIfJobCondition;
import info.thelaboflieven.gitlabci.model.GitlabWhenJobCondition;
import info.thelaboflieven.gitlabci.model.Rule;

import java.util.*;

public class GitlabRulesReader
{
    public static List<Rule> getRules(Map jobDetails){
        var list = new ArrayList<Rule>();
        var rulesList = (List<Map<String, Object>>) jobDetails.get("rules");
        for (Map<String, Object> rule: rulesList) {
            String ifStatement = Objects.toString(rule.get("if"), null);
            String whenStatement = Objects.toString(rule.get("when"), null);
            if (whenStatement == null) {
                whenStatement = GitlabWhenJobCondition.DEFAULT.name();
            }
            list.add(new Rule(new GitlabIfJobCondition(ifStatement), GitlabWhenJobCondition.valueOf(whenStatement.toUpperCase(Locale.ROOT))));
        }
        return list;
    }
}
