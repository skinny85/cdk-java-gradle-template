package com.myorg;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import software.amazon.awscdk.core.App;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class CdkJavaGradleStackTest {
    private final static ObjectMapper JSON =
            new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() {
        App app = new App();
        CdkJavaGradleStack stack = new CdkJavaGradleStack(app, "test");

        JsonNode template = JSON.valueToTree(
                app.synth()
                        .getStackArtifact(stack.getArtifactId())
                        .getTemplate());
        assertThat(template.toString(),
                both(containsString("AWS::SQS::Queue"))
                        .and(containsString("AWS::SNS::Topic")));
    }
}
