package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.model.Variable;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GitlabCiAssertions {

    public static boolean allStagesKnown(GitlabPipeline gitlabPipeline) {
        var declaredStages = new HashSet<>(gitlabPipeline.stages);
        var mentionedStages = gitlabPipeline.gitlabJobList.stream().map(j -> j.stage).collect(Collectors.toSet());
        return declaredStages.containsAll(mentionedStages);
    }

    public static List<GitlabJob> jobsRunForVariables(GitlabPipeline pipeline, Variable... variables) throws ScriptException {
        List<GitlabJob> jobs = new ArrayList<>();
        for (GitlabJob job : pipeline.gitlabJobList) {
            if (job.conditionsMet(variables)) {
                jobs.add(job);
            }
        }
        return jobs;
    }

    public static boolean allNeedsAreCorrect(GitlabPipeline pipeline, Variable... variables) {
        var knownJobs = new ArrayList<>();
        for (String stage : pipeline.stages) {
            knownJobs.addAll(pipeline.gitlabJobList.stream().filter(j -> j.stage.equals(stage)).map(j -> j.name).collect(Collectors.toSet()));
            var neededJobNames = pipeline.gitlabJobList.stream().filter(j -> j.stage.equals(stage)).flatMap(j -> j.neededJobs.stream()).collect(Collectors.toSet());
            if (!knownJobs.containsAll(neededJobNames)) {
                return false;
            }
        }
        return true;
    }
}
