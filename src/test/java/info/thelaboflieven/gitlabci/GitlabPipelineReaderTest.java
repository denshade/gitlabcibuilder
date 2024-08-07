package info.thelaboflieven.gitlabci;

import info.thelaboflieven.gitlabci.assertions.GitlabCiAssertions;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabJob;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.internal.reader.model.PredefinedVariables;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void loadAdditionalFromLocalFile(){
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleMerge.yml");
        assertEquals(List.of("build-job-ext", "test-job1-ext", "test-job2-ext", "deploy-prod-ext"), pipeline.gitlabJobList.stream().map(e -> e.name).toList());
        assertEquals(List.of("build", "test", "deploy"), pipeline.stages);
    }


    @Test
    public void loadConditionallyFromLocalFile() throws ScriptException {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleConditionalLoad.yml");
        var jobs = GitlabCiAssertions.jobsRunForVariables(pipeline, PredefinedVariables.CI_PIPELINE_SOURCE("schedule"));
        assertThat(jobs).hasSize(0);
    }

    @Test
    public void loadConditionallyFromLocalFileSkipped() throws ScriptException {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleConditionalLoad.yml");
        var jobs = GitlabCiAssertions.jobsRunForVariables(pipeline, PredefinedVariables.CI_PIPELINE_SOURCE("push"));
        assertThat(jobs).hasSize(4);
    }

}