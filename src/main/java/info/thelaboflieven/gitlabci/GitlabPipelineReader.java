package info.thelaboflieven.gitlabci;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            gitlabJob.script = new Script(((List<String>)jobDetails.get("script")).stream().collect(Collectors.joining("\n")));
            gitlabPipeline.gitlabJobList.add(gitlabJob);
        }
        return gitlabPipeline;
    }
}
