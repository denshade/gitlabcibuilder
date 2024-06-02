package info.thelaboflieven.gitlabci.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public record GitlabIfJobCondition(String conditions) {

    public boolean isMet(Variable... variables) throws ScriptException {
        var filledConditions = conditions;
        for (var variable : variables) {
            filledConditions = filledConditions.replaceAll("\\$" + variable.name(), '"' + variable.value() + '"');
        }
        var manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        var outcome = engine.eval(filledConditions);
        if (outcome instanceof Boolean) {
            return (Boolean) outcome;
        }
        return false;
    }

    public boolean isFullyResolved(Variable... variables) {
        var filledConditions = conditions;
        for (var variable : variables) {
            filledConditions = filledConditions.replaceAll("\\$" + variable.name(), '"' + variable.value() + '"');
        }
        return !filledConditions.contains("$");
    }
}
