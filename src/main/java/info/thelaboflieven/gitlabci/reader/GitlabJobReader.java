package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.Script;

import java.util.Map;

public class GitlabJobReader {
    public static GitlabJob from(Map.Entry mapEntry) {
        var gitlabJob = new GitlabJob();
        var b = (Map.Entry)mapEntry;
        if (b.getValue() instanceof Map) {
            var jobDetails = (Map)b.getValue();
            gitlabJob.name = b.getKey().toString();
            gitlabJob.stage = jobDetails.get("stage").toString();
            gitlabJob.environment = jobDetails.get("environment") == null?null:jobDetails.get("environment").toString();
            if (jobDetails.containsKey("script")) {
                gitlabJob.script = Script.from(jobDetails);
            }
        }
        return gitlabJob;
    }
}
