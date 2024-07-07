package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.GitlabCiReader;
import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GitlabJobReaderTest {
    @Test
    public void loadAdditionalFromLocalFile(){
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleMerge.yml");
        assertEquals(List.of("build-job-ext", "test-job1-ext", "test-job2-ext", "deploy-prod-ext"), pipeline.gitlabJobList.stream().map(e -> e.name).toList());
    }
}