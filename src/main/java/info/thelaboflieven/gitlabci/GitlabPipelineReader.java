package info.thelaboflieven.gitlabci;

import java.io.File;

public class GitlabPipelineReader implements GitlabCiReader
{
    public GitlabPipeline read(File file) {
        return new GitlabPipeline();
    }
}
