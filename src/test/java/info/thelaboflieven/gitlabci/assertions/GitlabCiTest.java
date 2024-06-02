package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineReader;
import info.thelaboflieven.gitlabci.model.GitlabIfJobCondition;
import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabJobCondition;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GitlabCiTest {

    @Test
    void checkStageAssertions() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleExample.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
    }

    @Test
    void checkUnknownStageAssertions() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleExampleUnknownStage.yml");
        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isFalse();
    }

    @Test
    void checkStageDefinedAssertions() throws IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleExampleOwnStageDefined.yml");

        assertThat(GitlabCiAssertions.allStagesKnown(pipeline)).isTrue();
    }

    @Test
    void singleConditionAssertion() throws ScriptException {
        var pipeline = new GitlabPipeline();
        var gitlabJob = new GitlabJob();
        gitlabJob.gitlabJobConditions.add(new GitlabJobCondition(new GitlabIfJobCondition("1==1"), null));
        pipeline.gitlabJobList.add(gitlabJob);
        assertThat(GitlabCiAssertions.jobsRunForConditions(pipeline)).hasSize(1);

    }

    private GitlabPipeline getGitlabPipelineForFixture(String name) throws IOException {
        File file = getFixture(name);
        var reader = new GitlabPipelineReader();
        GitlabPipeline pipeline = reader.read(file);
        return pipeline;
    }

    private File getFixture(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        return file;
    }

}