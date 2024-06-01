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
        Map contentMap = (Map)yaml.load(input);
        for (Object data : contentMap.entrySet()) {
            gitlabPipeline.gitlabJobList.add(new GitlabJob());
        }
        return gitlabPipeline;
    }
}
