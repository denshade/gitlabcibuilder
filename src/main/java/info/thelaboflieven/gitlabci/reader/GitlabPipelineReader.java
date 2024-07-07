package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GitlabPipelineReader {
    public static GitlabPipeline from(Map contentMap) {
        var gitlabPipeline = new GitlabPipeline();
        for (var data : contentMap.entrySet()) {
            var b = (Map.Entry)data;
            if (b.getKey().equals("include")) {
                var jobDetails = ((Map.Entry<String, Map<String, ?>>) data).getValue();
                if (jobDetails.containsKey("local")) {
                    String file = jobDetails.get("local").toString();
                    var reader = new GitlabPipelineFileReader();
                    try {
                        var localGitlabCi = reader.read(new File(file));
                        gitlabPipeline.gitlabJobList.addAll(localGitlabCi.gitlabJobList);
                        gitlabPipeline.stages.addAll(localGitlabCi.stages);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else if (b.getValue() instanceof Map) {
                gitlabPipeline.gitlabJobList.add(GitlabJobReader.from(b, gitlabPipeline));
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
