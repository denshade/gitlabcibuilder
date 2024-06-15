package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllStagesKnownTest {
    @Test
    void checkStageAssertions() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleExample.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
    }

    @Test
    void checkUnknownStageAssertions() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleExampleUnknownStage.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isFalse();
    }

    @Test
    void checkStageDefinedAssertions() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleExampleOwnStageDefined.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
    }


    private GitlabPipeline getGitlabPipelineForFixture(String name) throws IOException {
        File file = getFixture(name);
        var reader = new GitlabPipelineFileReader();
        return reader.read(file);
    }

    private File getFixture(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        return file;
    }
}
