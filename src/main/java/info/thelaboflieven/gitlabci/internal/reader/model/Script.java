package info.thelaboflieven.gitlabci.internal.reader.model;

import info.thelaboflieven.gitlabci.internal.reader.ReaderCommon;

import java.util.List;
import java.util.Map;

public class Script {
    public static Script from(Map jobDetails) {
        return new Script(String.join("\n", (ReaderCommon.flattenList((List<?>) jobDetails.get("script")))));
    }

    private final String lines;

    public Script(String lines){
        this.lines = lines;
    }

    public String getLines() {
        return lines;
    }
}
