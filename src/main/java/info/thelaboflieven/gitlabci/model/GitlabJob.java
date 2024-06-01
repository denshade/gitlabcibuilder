package info.thelaboflieven.gitlabci.model;

import java.util.List;

public class GitlabJob {
    public String name;
    public Script script;
    public String stage;
    public String environment;
    public List<GitlabJobCondition> gitlabJobConditions;

    public boolean conditionsMet(Variable[] variables) {
        return false;
    }
}
