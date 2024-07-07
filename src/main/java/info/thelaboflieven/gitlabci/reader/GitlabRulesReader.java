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
            list.add(new Rule(new GitlabIfJobCondition(rule.get("if").toString()), GitlabWhenJobCondition.valueOf(rule.get("when").toString().toUpperCase(Locale.ROOT))));
        }
        return list;
    }
}
