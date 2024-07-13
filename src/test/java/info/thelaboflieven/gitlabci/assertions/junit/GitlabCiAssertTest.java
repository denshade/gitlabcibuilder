package info.thelaboflieven.gitlabci.assertions.junit;

import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import info.thelaboflieven.gitlabci.internal.reader.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.internal.reader.model.PredefinedVariables;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

class GitlabCiAssertTest {

    @Test
    void checkJunitAssertAllStagesKnown() throws IOException {
        GitlabCiAssert.assertAllStagesKnown(GitlabPipelineFileReader.pipelineInProject());
    }

    @Test
    void checkJunitAssertJobsRun() throws IOException {
        GitlabCiAssert.assertJobsRunsExactly(GitlabPipelineFileReader.pipelineInProject(), Set.of("build-job", "test-job2", "deploy-prod",
                "test-job1"));
    }

    @Test
    void checkJunitAssertJobsRunVariables() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleRulesWhenNever.yml");
        GitlabCiAssert.assertJobsRunsExactly(pipeline, Set.of("test-job2", "deploy-prod", "test-job1"), PredefinedVariables.CI_PIPELINE_SOURCE("MY_PIPELINE"));
    }

    @Test
    void checkJunitAssertJobsRunContainsVariables() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleRulesWhenNever.yml");
        GitlabCiAssert.assertContainsJobs(pipeline, Set.of("deploy-prod", "test-job1"), PredefinedVariables.CI_PIPELINE_SOURCE("MY_PIPELINE"));
    }

    @Test
    void checkJunitAssertJobsRunDoesNotContainVariables() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleConditionalLoad.yml");
        GitlabCiAssert.assertJobsNotRun(pipeline, Set.of("build-job-ext"), PredefinedVariables.CI_PIPELINE_SOURCE("schedule"));
    }


    @Test
    void checkJunitAssertNeedsVariables() {
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("needsCorrect.yml");
        GitlabCiAssert.assertNeeds(pipeline);
    }


}