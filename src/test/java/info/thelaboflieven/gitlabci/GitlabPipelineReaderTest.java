package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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
        assertThat(firstGitlabJob.stage).isEqualTo("build");
        assertThat(firstGitlabJob.script.getLines()).isEqualTo("echo \"Hello, $GITLAB_USER_LOGIN!\"");

    }


}