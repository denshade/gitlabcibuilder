package info.thelaboflieven.gitlabci;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CanReadGitlabCiTest {
    @Test
    void canReadFile() throws IOException {
        var pipeline = GitlabPipelineFileReader.pipelineInProject();
        assertThat(pipeline).isNotNull();
    }

}
