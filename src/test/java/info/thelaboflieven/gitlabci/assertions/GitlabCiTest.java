package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.*;
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
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1==1"), null));
        pipeline.gitlabJobList.add(gitlabJob);
        assertThat(GitlabCiAssertions.jobsRunForVariables(pipeline)).hasSize(1);
    }
    @Test
    void singleConditionAssertionFails() throws ScriptException {
        var pipeline = new GitlabPipeline();
        var gitlabJob = new GitlabJob();
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1==0"), null));
        pipeline.gitlabJobList.add(gitlabJob);
        assertThat(GitlabCiAssertions.jobsRunForVariables(pipeline)).hasSize(0);
    }
    @Test
    void singleConditionAssertionWhenNever() throws ScriptException, IOException {
        GitlabPipeline pipeline = getGitlabPipelineForFixture("simpleRulesWhenNever.yml");
        assertThat(pipeline.gitlabJobList.get(0).rules).isNotEmpty();
        assertThat(GitlabCiAssertions.jobsRunForVariables(pipeline)).hasSize(3);
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