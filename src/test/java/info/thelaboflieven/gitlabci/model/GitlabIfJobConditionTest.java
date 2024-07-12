package info.thelaboflieven.gitlabci.model;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GitlabIfJobConditionTest {

    /*
        Use rules:if clauses to specify when to add a job to a pipeline:

        If an if statement is true, add the job to the pipeline.
        If an if statement is true, but it’s combined with when: never, do not add the job to the pipeline.
        If no if statements are true, do not add the job to the pipeline.
     */
    @Test
    void checkConditionsMet() throws ScriptException {
        var gitlabCondition = new GitlabIfJobCondition("$CI_PIPELINE_SOURCE == \"merge_request_event\"");
        assertThat(gitlabCondition.isMet(Variable.of("CI_PIPELINE_SOURCE", "merge_request_event"))).isTrue();
    }

    @Test
    void checkConditionsEmptyMet() throws ScriptException {
        var gitlabCondition = new GitlabIfJobCondition(null);
        assertThat(gitlabCondition.isMet(Variable.of("CI_PIPELINE_SOURCE", "merge_request_event"))).isTrue();
    }


    @Test
    void checkConditionsNotMet() throws ScriptException {
        var gitlabCondition = new GitlabIfJobCondition("$CI_PIPELINE_SOURCE == \"merge_request_event\"");
        assertThat(gitlabCondition.isMet(Variable.of("CI_PIPELINE_SOURCE", "potato"))).isFalse();
    }


    @Test
    void checkConditionsFullyResolved() throws ScriptException {
        var gitlabCondition = new GitlabIfJobCondition("$CI_PIPELINE_SOURCE == \"merge_request_event\"");
        assertThat(gitlabCondition.isFullyResolved(Variable.of("UNRESOLVED", "potato"))).isFalse();
    }
    @Test
    void checkConditionsNotFullyResolved() throws ScriptException {
        var gitlabCondition = new GitlabIfJobCondition("$CI_PIPELINE_SOURCE == \"merge_request_event\"");
        assertThat(gitlabCondition.isFullyResolved(Variable.of("CI_PIPELINE_SOURCE", "potato"))).isTrue();
    }

}