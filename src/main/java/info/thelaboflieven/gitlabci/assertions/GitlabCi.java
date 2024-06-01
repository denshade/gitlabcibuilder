package info.thelaboflieven.gitlabci.assertions;

import info.thelaboflieven.gitlabci.model.GitlabPipeline;

import java.util.Set;
import java.util.stream.Collectors;

public class GitlabCi {
    public static Set<String> DEFAULT_STATES = Set.of("build", "test", "deploy");
    public static boolean stagesKnown(GitlabPipeline gitlabPipeline) {
        var stages = gitlabPipeline.gitlabJobList.stream().map(j -> j.stage).collect(Collectors.toSet());
        return stages.containsAll(DEFAULT_STATES);
    }
}
