package info.thelaboflieven.gitlabci.model;

import java.util.List;
import java.util.Map;

public class Script {
    public static Script from(Map jobDetails) {
        return new Script(String.join("\n", ((List<String>) jobDetails.get("script"))));
    }

    private final String lines;

    public Script(String lines){
        this.lines = lines;
    }

    public String getLines() {
        return lines;
    }
}
