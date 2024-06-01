package info.thelaboflieven.gitlabci.model;

public class Variable {
    private String name;
    private String value;

    public Variable(String name, String value) {
        this.name = name;
        this.value = value;
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
