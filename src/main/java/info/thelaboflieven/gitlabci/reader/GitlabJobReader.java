package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GitlabJobReader {
    public static GitlabJob from(Map.Entry mapEntry) {
        var gitlabJob = new GitlabJob();
        var b = (Map.Entry)mapEntry;
        if (b.getValue() instanceof Map) {
            var jobDetails = (Map)b.getValue();
            if (jobDetails.containsKey("local")) {
                String file = jobDetails.get("local").toString();
                var reader = new  GitlabPipelineFileReader();
                try {
                    var gitlabCi = reader.read(new File(file));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            gitlabJob.name = b.getKey().toString();
            if (jobDetails.containsKey("stage")) {
                gitlabJob.stage = jobDetails.get("stage").toString();
            }
            if (jobDetails.containsKey("needs")) {
                gitlabJob.neededJobs = (List)jobDetails.get("needs");
            }
            gitlabJob.environment = jobDetails.get("environment") == null?null:jobDetails.get("environment").toString();
            if (jobDetails.containsKey("rules")) {
                var rulesList = (List<Map<String, Object>>) jobDetails.get("rules");
                for (Map<String, Object> rule: rulesList) {
                    gitlabJob.rules.add(new Rule(new GitlabIfJobCondition(rule.get("if").toString()), GitlabWhenJobCondition.valueOf(rule.get("when").toString().toUpperCase(Locale.ROOT))));
                }
            }
            if (jobDetails.containsKey("script")) {
                gitlabJob.script = Script.from(jobDetails);
            }
        }
        return gitlabJob;
    }
}
