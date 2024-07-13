package info.thelaboflieven.gitlabci.model;

public record Rule(GitlabIfJobCondition gitlabIfJobCondition, GitlabWhenJobCondition gitlabWhenJobCondition) {

}
