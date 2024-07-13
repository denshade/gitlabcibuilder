package info.thelaboflieven.gitlabci.internal.reader.model;

import info.thelaboflieven.gitlabci.internal.reader.ScriptEngineManagerRegistry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public record GitlabIfJobCondition(String conditions) {

    public boolean isMet(Variable... variables) throws ScriptException {
        var filledConditions = conditions;
        if (filledConditions == null) {
            return true;
        }
        for (var variable : variables) {
            filledConditions = filledConditions.replaceAll("\\$" + variable.name(), '"' + variable.value() + '"');
        }
        ScriptEngine engine = ScriptEngineManagerRegistry.getInstance();
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
