package info.thelaboflieven.gitlabci.assertions.junit;

import info.thelaboflieven.gitlabci.assertions.GitlabCiAssertions;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;

public class GitlabCiAssert {
    public static void assertAllStagesKnown(GitlabPipeline gitlabPipeline) {
        var unknownStages = GitlabCiAssertions.findUnknownStages(gitlabPipeline);
        if (!unknownStages.isEmpty()) {
            throw new AssertionError("The gitlab pipeline uses unknown stages " + unknownStages);
        }
    }
}
