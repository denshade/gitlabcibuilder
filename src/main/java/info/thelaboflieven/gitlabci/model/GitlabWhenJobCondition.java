package info.thelaboflieven.gitlabci.model;

import javax.script.ScriptException;

public enum GitlabWhenJobCondition {
    NEVER, ON_SUCCESS, ALWAYS, ON_FAILURE, MANUAL, DELAYED
}
