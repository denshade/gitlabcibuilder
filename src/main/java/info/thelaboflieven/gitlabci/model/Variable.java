package info.thelaboflieven.gitlabci.model;

public record Variable(String name, String value) {

    public static Variable of(String name, String value) {
        return new Variable(name, value);
    }

}
