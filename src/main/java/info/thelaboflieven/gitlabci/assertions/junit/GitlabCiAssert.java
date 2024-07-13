package info.thelaboflieven.gitlabci.assertions.junit;

import info.thelaboflieven.gitlabci.assertions.GitlabCiAssertions;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.model.Variable;
import info.thelaboflieven.gitlabci.reader.ReaderCommon;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GitlabCiAssert {
    /**
     * Assert that there are no stages that are unknown in the passed pipeline.
     * @param gitlabPipeline the used pipeline.
     */
    public static void assertAllStagesKnown(GitlabPipeline gitlabPipeline) {
        var unknownStages = GitlabCiAssertions.findUnknownStages(gitlabPipeline);
        if (!unknownStages.isEmpty()) {
            throw new AssertionError("The gitlab pipeline uses unknown stages " + unknownStages);
        }
    }

    /**
     * Assert that the pipeline when run with specific variables, matches the exact set of expectedJobs.
     * @param gitlabPipeline the used pipeline.
     * @param expectedJobs the exact expected set of job that run for a specific set of variables.
     * @param variables the set of variables to run the pipeline against.
     */
    public static void assertJobsRunsExactly(GitlabPipeline gitlabPipeline, Set<String> expectedJobs, Variable... variables) {
        try {
            var jobs = GitlabCiAssertions.jobsRunForVariables(gitlabPipeline, variables).stream().filter(Objects::nonNull).collect(Collectors.toSet());
            var actualJobs = jobs.stream().map(j -> j.name).filter(Objects::nonNull).collect(Collectors.toSet());
            if (!actualJobs.equals(expectedJobs)) {
                throw new AssertionError("The gitlab pipeline doesn't match the expected jobs. Expected " + expectedJobs + " vs. " + actualJobs);
            }
        } catch (ScriptException scriptException) {
            throw new AssertionError("A problem has occurred parsing conditions", scriptException);
        }
    }

    /**
     * Assert that the pipeline when run with specific variables, contains at least a set of expectedJobs.
     * @param gitlabPipeline the used pipeline.
     * @param expectedJobs the set of job that run for a specific set of variables.
     * @param variables the set of variables to run the pipeline against.
     */
    public static void assertContainsJobs(GitlabPipeline gitlabPipeline, Set<String> expectedJobs, Variable... variables) {
        try {
            var jobs = GitlabCiAssertions.jobsRunForVariables(gitlabPipeline, variables).stream().filter(Objects::nonNull).collect(Collectors.toSet());
            var actualJobs = jobs.stream().map(j -> j.name).filter(Objects::nonNull).collect(Collectors.toSet());
            if (!actualJobs.containsAll(expectedJobs)) {
                throw new AssertionError("The gitlab pipeline doesn't match the expected jobs. Expected " + expectedJobs + " vs. " + actualJobs);
            }
        } catch (ScriptException scriptException) {
            throw new AssertionError("A problem has occurred parsing conditions", scriptException);
        }
    }
    /**
     * Assert that the pipeline when run with specific variables, does not contain at least a set of expectedJobs.
     * @param gitlabPipeline the used pipeline.
     * @param expectedJobs the set of job that should _not_ be run for a specific set of variables.
     * @param variables the set of variables to run the pipeline against.
     */
    public static void assertJobsNotRun(GitlabPipeline gitlabPipeline, Set<String> expectedJobs, Variable... variables) {
        try {
            var jobs = GitlabCiAssertions.jobsRunForVariables(gitlabPipeline, variables).stream().filter(Objects::nonNull).collect(Collectors.toSet());
            var actualJobs = jobs.stream().map(j -> j.name).filter(Objects::nonNull).collect(Collectors.toSet());
            for (var job: expectedJobs) {
                if (actualJobs.contains(job)) {
                    throw new AssertionError("The gitlab pipeline would run an unexpected job: " + job);
                }
            }
        } catch (ScriptException scriptException) {
            throw new AssertionError("A problem has occurred parsing conditions", scriptException);
        }
    }

    /**
     * Assert that all the needs are met for a specific pipeline.
     * @param pipeline the used pipeline.
     */
    public static void assertNeeds(GitlabPipeline pipeline) {
        var knownJobs = new ArrayList<>();
        for (String stage : pipeline.stages) {
            knownJobs.addAll(pipeline.gitlabJobList.stream().filter(j -> j.stage.equals(stage)).map(j -> j.name).collect(Collectors.toSet()));
            var neededJobNames = ReaderCommon.flattenList(pipeline.gitlabJobList.stream().filter(j -> j.stage.equals(stage)).flatMap(j -> j.neededJobs.stream()).collect(Collectors.toList()));
            if (!knownJobs.containsAll(neededJobNames)) {
                throw new AssertionError("The gitlab pipeline has unknown needed jobs. Known: "+ knownJobs + " vs. " + neededJobNames);
            }
        }
    }


}
