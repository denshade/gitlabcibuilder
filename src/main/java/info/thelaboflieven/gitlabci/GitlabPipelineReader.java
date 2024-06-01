package info.thelaboflieven.gitlabci;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
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
            var jobDetails = (Map)b.getValue();
            GitlabJob gitlabJob = new GitlabJob();
            gitlabJob.script = new Script(jobDetails.get("script").toString());
            gitlabPipeline.gitlabJobList.add(gitlabJob);
        }
        return gitlabPipeline;
    }
}
