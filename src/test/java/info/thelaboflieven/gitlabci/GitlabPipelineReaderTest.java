package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GitlabPipelineReaderTest {

    @Test
    void readerSimpleExample() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExample.yml");
        assertThat(pipeline).isNotNull();
        assertThat(pipeline.gitlabJobList).hasSize(4);
        GitlabJob firstGitlabJob = pipeline.gitlabJobList.get(0);
        assertThat(firstGitlabJob.name).isEqualTo("build-job");
        assertThat(firstGitlabJob.stage).isEqualTo("build");
        assertThat(firstGitlabJob.script.getLines()).isEqualTo("echo \"Hello, $GITLAB_USER_LOGIN!\"");
    }

    @Test
    void readerStagesExample() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleOwnStageDefined.yml");
        assertThat(pipeline).isNotNull();
        assertThat(pipeline.stages).isEqualTo(List.of("build", "test", "deploy", "stage1", "stage2", "stage3"));
    }

    @Test
    void readerDefaultStagesExample() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExample.yml");
        assertThat(pipeline).isNotNull();
        assertThat(pipeline.stages).isEqualTo(List.of("build", "test", "deploy"));
    }


}