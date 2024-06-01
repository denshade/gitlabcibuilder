package info.thelaboflieven.gitlabci;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GitlabPipelineReaderTest {

    @Test
    void readerSimpleExample() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("simpleExample.yml").getFile());

        var reader = new GitlabPipelineReader();
        assertThat(reader.read(file)).isNotNull();
    }

}