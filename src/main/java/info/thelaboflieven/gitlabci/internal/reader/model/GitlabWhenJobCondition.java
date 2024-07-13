package info.thelaboflieven.gitlabci.internal.reader.model;

public enum GitlabWhenJobCondition {
    NEVER, ON_SUCCESS, ALWAYS, ON_FAILURE, MANUAL, DELAYED;
    public static GitlabWhenJobCondition DEFAULT = ON_SUCCESS;
}
