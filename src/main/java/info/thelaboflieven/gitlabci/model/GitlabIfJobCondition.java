package info.thelaboflieven.gitlabci.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GitlabIfJobCondition {

    private final String conditions;

    public GitlabIfJobCondition(String conditions) {
        this.conditions = conditions;
    }
    public boolean isMet(Variable... variables) throws ScriptException {
        var filledConditions = conditions;
        for (var variable : variables) {
            filledConditions = filledConditions.replaceAll("\\$"+variable.getName(), '"'+variable.getValue()+'"');
        }
        var manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        var outcome = engine.eval(filledConditions);
        if (outcome instanceof Boolean)
            return (Boolean)outcome;
        return false;
    }

    public boolean isFullyResolved(Variable... variables) throws ScriptException {
        var filledConditions = conditions;
        for (var variable : variables) {
            filledConditions = filledConditions.replaceAll("\\$"+variable.getName(), '"'+variable.getValue()+'"');
        }
        return !filledConditions.contains("$");
    }
}
