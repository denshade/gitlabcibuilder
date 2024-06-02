package info.thelaboflieven.gitlabci.model;

public record Variable(String name, String value) {

    public static Variable CI_COMMIT_BRANCH(String value) {
        return new Variable("CI_COMMIT_BRANCH", value);
    }

    public static Variable CI_PIPELINE_SOURCE(String value) {
        return new Variable("CI_PIPELINE_SOURCE", value);
    }

    public static Variable CI_COMMIT_TITLE(String value) {
        return new Variable("CI_COMMIT_TITLE", value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static Variable of(String name, String value) {
        return new Variable(name, value);
    }

}
