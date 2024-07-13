package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;

import java.io.File;
import java.io.IOException;

public class GitlabPipelineTestLoader {
    public static GitlabPipeline load(String fixture) {
        ClassLoader classLoader = GitlabPipelineTestLoader.class.getClassLoader();
        File file = new File(classLoader.getResource(fixture).getFile());
        if (!file.exists()) {
            throw new RuntimeException("Couldn't find file " + file);
        }
        var reader = new GitlabPipelineFileReader();
        try {
            return reader.read(file);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load fixture " + fixture);
        }
    }
}
