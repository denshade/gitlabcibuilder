package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;

import java.util.List;
import java.util.Map;

public class GitlabPipelineReader {
    public static GitlabPipeline from(Map contentMap) {
        var gitlabPipeline = new GitlabPipeline();
        for (var data : contentMap.entrySet()) {
            var b = (Map.Entry)data;
            if (b.getValue() instanceof Map) {
                gitlabPipeline.gitlabJobList.add(GitlabJobReader.from(b));
            } else {
                String jobName = b.getKey().toString();
                if (jobName.equals("stages")) {
                    gitlabPipeline.stages.addAll((List)b.getValue());
                }
            }
        }
        return gitlabPipeline;
    }
}
