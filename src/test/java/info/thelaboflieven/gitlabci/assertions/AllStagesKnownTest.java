package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllStagesKnownTest {
    @Test
    void checkStageAssertions() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExample.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
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
