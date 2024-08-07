package info.thelaboflieven.gitlabci.internal.reader;

import info.thelaboflieven.gitlabci.internal.reader.model.GitlabIfJobCondition;
import info.thelaboflieven.gitlabci.internal.reader.model.Rule;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabWhenJobCondition;

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
