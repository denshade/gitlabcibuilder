package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import info.thelaboflieven.gitlabci.assertions.junit.GitlabCiAssert;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AllStagesKnownTest {
    @Test
    void checkStageAssertions() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExample.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
    }
    @Test
    void checkStageJunitAssertions() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExample.yml");
        GitlabCiAssert.assertAllStagesKnown(pipeline);
    }
    @Test
    void checkStageJunitAssertionsFails() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleUnknownStage.yml");
        assertThatThrownBy(() -> GitlabCiAssert.assertAllStagesKnown(pipeline)).isInstanceOf(AssertionError.class);
    }

    @Test
    void checkUnknownStageAssertions() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleUnknownStage.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isFalse();
    }

    @Test
    void checkStageDefinedAssertions() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleOwnStageDefined.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
    }

}
