package info.thelaboflieven.gitlabci.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScriptTest {
    @Test
    void flattenScript() {
        var jobDetails = Map.of("script", List.of(List.of("a", "b"), "g"));
        var script = Script.from(jobDetails);
        assertEquals(script.getLines(), String.join("\n",List.of("a", "b","g")));
    }

}