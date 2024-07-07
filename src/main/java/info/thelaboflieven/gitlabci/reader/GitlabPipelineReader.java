package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.GitlabJob;
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
                case "include" -> loadGitlabPipelineDetails(gitlabPipeline, (Map.Entry<String, Object>) data);
                case "stages" -> gitlabPipeline.stages.addAll((List) b.getValue());
                default -> gitlabPipeline.gitlabJobList.add(GitlabJobReader.from(b));
            }
        }
        return gitlabPipeline;
    }

    private static void loadGitlabPipelineDetails(GitlabPipeline gitlabPipeline, Map.Entry<String, Object> data) {
        var jobDetails = (List)data.getValue();
        for (var jobDetail : jobDetails) {
            var jobDetailMap = (Map<String, Object>)jobDetail;
            if (jobDetailMap.containsKey("local")) {
                String file = jobDetailMap.get("local").toString();
                var reader = new GitlabPipelineFileReader();
                try {
                    var localGitlabCi = reader.read(new File(file));
                    List<GitlabJob> gitlabJobList = localGitlabCi.gitlabJobList;
                    if (jobDetailMap.containsKey("rules")) {
                        var rules = GitlabRulesReader.getRules(jobDetailMap);
                        for (var gitlabJob : gitlabJobList){
                            gitlabJob.rules.addAll(rules);
                        }
                    }
                    gitlabPipeline.gitlabJobList.addAll(gitlabJobList);
                    addStagesIfNotExists(gitlabPipeline, localGitlabCi);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void addStagesIfNotExists(GitlabPipeline gitlabPipeline, GitlabPipeline localGitlabCi) {
        for (String localStage: localGitlabCi.stages) {
            if (!gitlabPipeline.stages.contains(localStage)) {
                gitlabPipeline.stages.add(localStage);
            }
        }
    }
}
