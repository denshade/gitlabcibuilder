package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.model.Script;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class GitlabPipelineReader implements GitlabCiReader
{
    public GitlabPipeline read(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        Yaml yaml = new Yaml();
        GitlabPipeline gitlabPipeline = new GitlabPipeline();
        Map contentMap = yaml.load(input);
        for (var data : contentMap.entrySet()) {
            var b = (Map.Entry)data;
            if (b.getValue() instanceof Map) {
                var jobDetails = (Map)b.getValue();
                GitlabJob gitlabJob = new GitlabJob();
                gitlabJob.name = b.getKey().toString();
                gitlabJob.stage = jobDetails.get("stage").toString();
                gitlabJob.environment = jobDetails.get("stage").toString();

                gitlabJob.script = new Script(String.join("\n", ((List<String>) jobDetails.get("script"))));
                gitlabPipeline.gitlabJobList.add(gitlabJob);
            } else {
                String jobName = b.getKey().toString();
                if (jobName.equals("stages")) {
                    gitlabPipeline.stages = (List)b.getValue();
                }
            }
        }
        return gitlabPipeline;
    }
}
