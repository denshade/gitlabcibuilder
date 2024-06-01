package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import info.thelaboflieven.gitlabci.model.Variable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GitlabCiAssertions {
    public static Set<String> DEFAULT_STATES = Set.of("build", "test", "deploy");
    public static boolean allStagesKnown(GitlabPipeline gitlabPipeline) {
        var declaredStages = new HashSet<>(gitlabPipeline.stages);
        var mentionedStages = gitlabPipeline.gitlabJobList.stream().map(j -> j.stage).collect(Collectors.toSet());
        var allKnownStates = new HashSet<>(DEFAULT_STATES);
        allKnownStates.addAll(declaredStages);
        return allKnownStates.containsAll(mentionedStages);
    }

    public static List<GitlabJob> jobsRunForConditions(GitlabPipeline pipeline, Variable... variables) {
        List<GitlabJob> jobs = new ArrayList<>();
        for (GitlabJob job : pipeline.gitlabJobList) {
            if (job.conditionsMet(variables)) {
                jobs.add(job);
            }
        }
        return jobs;
    }
}
