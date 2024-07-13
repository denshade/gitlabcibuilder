package info.thelaboflieven.gitlabci.model;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GitlabJobTest {

    @Test
    void noRulesMeansShouldRunTheJob() throws ScriptException {
        var gitlabJob = new GitlabJob();
        assertThat(gitlabJob.rules).isEmpty();
        assertThat(gitlabJob.conditionsMet(new Variable[0])).isTrue();
    }
    @Test
    void oneRuleSucceedingShouldRunTheJob() throws ScriptException {
        var gitlabJob = new GitlabJob();
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1 == 1"), GitlabWhenJobCondition.ALWAYS));
        assertThat(gitlabJob.conditionsMet(new Variable[0])).isTrue();
    }
    @Test
    void oneRuleFailingShouldNotRunTheJob() throws ScriptException {
        var gitlabJob = new GitlabJob();
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1 == 0"), GitlabWhenJobCondition.ALWAYS));
        assertThat(gitlabJob.conditionsMet(new Variable[0])).isFalse();
    }
    @Test
    void oneRuleFailingShouldNotRunTheJobIfWhenClauseIsNever() throws ScriptException {
        var gitlabJob = new GitlabJob();
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1 == 1"), GitlabWhenJobCondition.NEVER));
        assertThat(gitlabJob.conditionsMet(new Variable[0])).isFalse();
    }

    @Test
    void twoRulesSecondSucceedsShouldRunTheJob() throws ScriptException {
        var gitlabJob = new GitlabJob();
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1 == 0"), GitlabWhenJobCondition.ALWAYS));
        gitlabJob.rules.add(new Rule(new GitlabIfJobCondition("1 == 1"), GitlabWhenJobCondition.ALWAYS));
        assertThat(gitlabJob.conditionsMet(new Variable[0])).isTrue();
    }
}