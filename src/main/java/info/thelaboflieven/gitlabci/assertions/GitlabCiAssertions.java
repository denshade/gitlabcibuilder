package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.model.GitlabPipeline;

import java.util.HashSet;
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
}
