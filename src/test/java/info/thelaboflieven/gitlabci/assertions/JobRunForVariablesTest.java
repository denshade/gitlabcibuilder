package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.model.GitlabIfJobCondition;
import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.model.Rule;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JobRunForVariablesTest {

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
