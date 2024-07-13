package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.internal.reader.GitlabPipelineReader;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class GitlabPipelineFileReader implements GitlabCiReader
{
    /**
     * Read a pipeline from a file.
     * @param file file to load from
     * @return a pipeline.
     * @throws IOException
     */
    public GitlabPipeline read(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        Yaml yaml = new Yaml();
        Map contentMap = yaml.load(input);
        return GitlabPipelineReader.from(contentMap);
    }

    /**
     * Loads the pipeline from the standard location.
     * @return a pipeline
     * @throws IOException
     */
    public static GitlabPipeline pipelineInProject() throws IOException {
        var reader = new GitlabPipelineFileReader();
        return reader.read(new File("gitlab-ci.yml"));
    }
}
