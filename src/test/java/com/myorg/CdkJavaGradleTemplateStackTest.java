package com.myorg;
import software.amazon.awscdk.core.App;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.hamcrest.CoreMatchers;

import java.io.IOException;
import static org.junit.Assert.assertThat;

public class CdkJavaGradleTemplateStackTest {
    private final static ObjectMapper JSON =
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() throws IOException {
        App app = new App();
        CdkJavaGradleTemplateStack stack = new CdkJavaGradleTemplateStack(app, "test");

        JsonNode actual = JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());
        assertThat(actual.toString(), CoreMatchers.both(CoreMatchers.containsString("AWS::SQS::Queue")).and(CoreMatchers.containsString("AWS::SNS::Topic")));
    }
}
