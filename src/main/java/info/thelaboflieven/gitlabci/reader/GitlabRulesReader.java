package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.model.GitlabIfJobCondition;
import info.thelaboflieven.gitlabci.model.GitlabWhenJobCondition;
import info.thelaboflieven.gitlabci.model.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GitlabRulesReader
{
    public static List<Rule> getRules(Map jobDetails){
        var list = new ArrayList<Rule>();
        var rulesList = (List<Map<String, Object>>) jobDetails.get("rules");
        for (Map<String, Object> rule: rulesList) {
            String ifStatement = rule.get("if") == null? null: rule.get("if").toString();
            String whenStatement = rule.get("when") == null? null: rule.get("when").toString().toUpperCase(Locale.ROOT);
            if (whenStatement == null) {
                whenStatement = "ALWAYS";
            }
            list.add(new Rule(new GitlabIfJobCondition(ifStatement), GitlabWhenJobCondition.valueOf(whenStatement)));
        }
        return list;
    }
}
