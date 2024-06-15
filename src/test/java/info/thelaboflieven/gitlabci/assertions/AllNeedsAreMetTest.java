package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllNeedsAreMetTest {
    @Test
    void checkNeedAreCorrect() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("needsCorrect.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isTrue();
    }

    @Test
    void needsIncorrectWrongPhase() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("needsIncorrectWrongPhase.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isFalse();
    }

    @Test
    void needsIncorrectUnknown() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("needsIncorrectUnknown.yml");
        assertThat(GitlabCiAssertions.allNeedsAreCorrect(pipeline)).isFalse();
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
