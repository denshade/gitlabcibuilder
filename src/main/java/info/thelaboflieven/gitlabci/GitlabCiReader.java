package info.thelaboflieven.gitlabci;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface GitlabCiReader
{
    GitlabPipeline read(File file) throws IOException;
}
