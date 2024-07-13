package info.thelaboflieven.gitlabci.internal.reader.model;

import java.util.ArrayList;
import java.util.List;

public class GitlabPipeline {
    public GitlabPipeline() {
        stages.add("build");
        stages.add("test");
        stages.add("deploy");
    }
    public List<GitlabJob> gitlabJobList = new ArrayList<>();
    public List<String> stages = new ArrayList<>();
}
