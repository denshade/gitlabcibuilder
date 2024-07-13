package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;

import java.io.File;
import java.io.IOException;

public interface GitlabCiReader
{
    GitlabPipeline read(File file) throws IOException;
}
