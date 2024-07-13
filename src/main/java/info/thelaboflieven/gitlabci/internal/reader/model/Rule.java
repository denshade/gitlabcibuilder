package info.thelaboflieven.gitlabci.internal.reader.model;

public record Rule(GitlabIfJobCondition gitlabIfJobCondition, GitlabWhenJobCondition gitlabWhenJobCondition) {

}
