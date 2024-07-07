package info.thelaboflieven.gitlabci.model;

public enum GitlabWhenJobCondition {
    NEVER, ON_SUCCESS, ALWAYS, ON_FAILURE, MANUAL, DELAYED;
    public static GitlabWhenJobCondition DEFAULT = ON_SUCCESS;
}
