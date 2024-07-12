package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.model.*;

import java.util.List;
import java.util.Map;

public class GitlabJobReader {
    public static GitlabJob from(Map.Entry mapEntry) {
        var gitlabJob = new GitlabJob();
        var b = (Map.Entry)mapEntry;
        if (b.getValue() instanceof Map) {
            var jobDetails = (Map)b.getValue();
            gitlabJob.name = b.getKey().toString();
            if (jobDetails.containsKey("stage")) {
                gitlabJob.stage = jobDetails.get("stage").toString();
            }
            if (jobDetails.containsKey("needs")) {
                gitlabJob.neededJobs = (List)jobDetails.get("needs");
            }
            gitlabJob.environment = jobDetails.get("environment") == null?null:jobDetails.get("environment").toString();
            if (jobDetails.containsKey("rules")) {
                gitlabJob.rules.addAll(GitlabRulesReader.getRules(jobDetails));
            }
            if (jobDetails.containsKey("script")) {
                gitlabJob.script = Script.from(jobDetails);
            }
        }
        return gitlabJob;
    }
}
