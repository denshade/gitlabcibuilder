package info.thelaboflieven.gitlabci.reader;

import info.thelaboflieven.gitlabci.GitlabCiReader;
import info.thelaboflieven.gitlabci.GitlabPipelineFileReader;
import info.thelaboflieven.gitlabci.GitlabPipelineTestLoader;
import info.thelaboflieven.gitlabci.model.GitlabJob;
import info.thelaboflieven.gitlabci.model.GitlabPipeline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitlabJobReaderTest {
    @Test
    public void loadAdditionalFromLocalFile(){
        GitlabPipeline pipeline = GitlabPipelineTestLoader.load("simpleExampleMerge.yml");
        assertEquals(4, pipeline.gitlabJobList.size());
    }
}