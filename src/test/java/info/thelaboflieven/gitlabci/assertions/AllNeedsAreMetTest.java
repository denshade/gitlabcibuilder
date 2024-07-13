package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllNeedsAreMetTest {
    @Test
    void checkNeedAreCorrect() {
        var pipeline = GitlabPipelineTestLoader.load("needsCorrect.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isTrue();
    }

    @Test
    void needsIncorrectWrongPhase() {
        var pipeline = GitlabPipelineTestLoader.load("needsIncorrectWrongPhase.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isFalse();
    }

    @Test
    void needsIncorrectUnknownForVariable() {
        var pipeline = GitlabPipelineTestLoader.load("needsIncorrectUnknownForVariable.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isFalse();
    }

    @Test
    void needsIncorrectUnknown() {
        var pipeline = GitlabPipelineTestLoader.load("needsIncorrectUnknown.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isFalse();
    }
}
