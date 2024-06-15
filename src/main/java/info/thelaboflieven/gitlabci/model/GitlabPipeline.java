package info.thelaboflieven.gitlabci.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GitlabPipeline {
    public GitlabPipeline() {
        stages.add("build");
        stages.add("test");
        stages.add("deploy");
    }
    public List<GitlabJob> gitlabJobList = new ArrayList<>();
    public List<String> stages = new ArrayList<>();
}
