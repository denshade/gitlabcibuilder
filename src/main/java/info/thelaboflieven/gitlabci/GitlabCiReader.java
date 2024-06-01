package info.thelaboflieven.gitlabci;

import java.io.File;

public interface GitlabCiReader
{
    GitlabPipeline read(File file);
}
