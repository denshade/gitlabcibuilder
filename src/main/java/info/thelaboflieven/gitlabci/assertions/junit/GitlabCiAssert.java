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
    public static void assertAllStagesKnown(GitlabPipeline gitlabPipeline) {
        var unknownStages = GitlabCiAssertions.findUnknownStages(gitlabPipeline);
        if (!unknownStages.isEmpty()) {
            throw new AssertionError("The gitlab pipeline uses unknown stages " + unknownStages);
        }
    }

    public static void assertJobsRun(GitlabPipeline gitlabPipeline, Set<String> expectedJobs, Variable... variables) {
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
