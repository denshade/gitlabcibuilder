package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabIfJobCondition;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabJob;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.internal.reader.model.Rule;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
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
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleRulesWhenNever.yml");
        assertThat(pipeline.gitlabJobList.get(0).rules).isNotEmpty();
        assertThat(GitlabCiAssertions.jobsRunForVariables(pipeline)).hasSize(3);
    }

}
