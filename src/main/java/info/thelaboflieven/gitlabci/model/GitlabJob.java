package info.thelaboflieven.gitlabci.model;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GitlabJob {

    public static GitlabJob from(Map.Entry mapEntry) {
        var gitlabJob = new GitlabJob();
        var b = (Map.Entry)mapEntry;
        if (b.getValue() instanceof Map) {
            var jobDetails = (Map)b.getValue();
            gitlabJob.name = b.getKey().toString();
            gitlabJob.stage = jobDetails.get("stage").toString();
            gitlabJob.environment = jobDetails.get("environment") == null?null:jobDetails.get("environment").toString();
            gitlabJob.script = Script.from(jobDetails);
        }
        return gitlabJob;
    }

    public String name;
    public Script script;
    public String stage;
    public String environment;
    public List<GitlabJobCondition> gitlabJobConditions = new ArrayList<>();

    public boolean conditionsMet(Variable[] variables) throws ScriptException {
        for (var gitlabJobCondition : gitlabJobConditions) {
            if (gitlabJobCondition.gitlabIfJobCondition().isMet(variables)) return true;
        }
        return false;
    }
}
