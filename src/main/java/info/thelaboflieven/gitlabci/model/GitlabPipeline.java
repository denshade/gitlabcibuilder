package info.thelaboflieven.gitlabci.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GitlabPipeline {
    public static GitlabPipeline from(Map contentMap) {
        var gitlabPipeline = new GitlabPipeline();
        for (var data : contentMap.entrySet()) {
            var b = (Map.Entry)data;
            if (b.getValue() instanceof Map) {
                gitlabPipeline.gitlabJobList.add(GitlabJob.from(b));
            } else {
                String jobName = b.getKey().toString();
                if (jobName.equals("stages")) {
                    gitlabPipeline.stages = (List)b.getValue();
                }
            }
        }
        return gitlabPipeline;
    }

    public List<GitlabJob> gitlabJobList = new ArrayList<>();
    public List<String> stages = new ArrayList<>();
}
