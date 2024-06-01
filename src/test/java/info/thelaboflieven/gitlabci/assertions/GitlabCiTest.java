package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineReader;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GitlabCiTest {

    @Test
    void checkStageAssertions() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("simpleExample.yml").getFile());

        var reader = new GitlabPipelineReader();
        GitlabPipeline pipeline = reader.read(file);

        assertThat(GitlabCi.stagesKnown(pipeline)).isTrue();
    }

    @Test
    void checkUnknownStageAssertions() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("simpleExampleUnknownStage.yml").getFile());

        var reader = new GitlabPipelineReader();
        GitlabPipeline pipeline = reader.read(file);

        assertThat(GitlabCi.stagesKnown(pipeline)).isFalse();
    }

    @Test
    void checkStageDefinedAssertions() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("simpleExampleOwnStageDefined.yml").getFile());

        var reader = new GitlabPipelineReader();
        GitlabPipeline pipeline = reader.read(file);

        assertThat(GitlabCi.stagesKnown(pipeline)).isTrue();
    }

}