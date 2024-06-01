package info.thelaboflieven.gitlabci;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GitlabPipelineReaderTest {

    @Test
    void readerSimpleExample() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("simpleExample.yml").getFile());

        var reader = new GitlabPipelineReader();
        GitlabPipeline pipeline = reader.read(file);
        assertThat(pipeline).isNotNull();
        assertThat(pipeline.gitlabJobList).hasSize(4);
        GitlabJob firstGitlabJob = pipeline.gitlabJobList.get(0);
        assertThat(firstGitlabJob.name).isEqualTo("build-job");
        assertThat(firstGitlabJob.script.getLines()).isEqualTo("echo \"Hello, $GITLAB_USER_LOGIN!\"");

    }


}