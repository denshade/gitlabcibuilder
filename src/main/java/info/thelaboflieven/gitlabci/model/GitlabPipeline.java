package info.thelaboflieven.gitlabci.model;

import java.util.ArrayList;
import java.util.List;

public class GitlabPipeline {
    public List<GitlabJob> gitlabJobList = new ArrayList<>();
    public List<String> stages = new ArrayList<>();
}
