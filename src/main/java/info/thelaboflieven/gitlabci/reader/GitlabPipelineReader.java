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
            String keyName = b.getKey().toString();
            switch (keyName) {
                case "include" -> loadGitlabPipelineDetails(gitlabPipeline, (Map.Entry<String, Map<String, ?>>) data);
                case "stages" -> gitlabPipeline.stages.addAll((List) b.getValue());
                default -> gitlabPipeline.gitlabJobList.add(GitlabJobReader.from(b, gitlabPipeline));
            }
        }
        return gitlabPipeline;
    }

    private static void loadGitlabPipelineDetails(GitlabPipeline gitlabPipeline, Map.Entry<String, Map<String, ?>> data) {
        var jobDetails = data.getValue();
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
}
