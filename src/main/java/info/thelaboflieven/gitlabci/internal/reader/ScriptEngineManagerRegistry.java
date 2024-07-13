package info.thelaboflieven.gitlabci.internal.reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineManagerRegistry {

    private static ScriptEngine engine;

    public static synchronized ScriptEngine getInstance() {
        if (engine == null) {
            var manager = new ScriptEngineManager();
            engine = manager.getEngineByName("JavaScript");
        }
        return engine;
    }
}
