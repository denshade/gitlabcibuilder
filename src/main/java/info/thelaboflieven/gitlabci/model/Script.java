package info.thelaboflieven.gitlabci.model;

public class Script {
    private final String lines;

    public Script(String lines){
        this.lines = lines;
    }

    public String getLines() {
        return lines;
    }
}
