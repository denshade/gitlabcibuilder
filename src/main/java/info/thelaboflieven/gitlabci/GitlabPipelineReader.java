package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class GitlabPipelineReader implements GitlabCiReader
{
    public GitlabPipeline read(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        Yaml yaml = new Yaml();
        Map contentMap = yaml.load(input);
        return GitlabPipeline.from(contentMap);
    }
}
