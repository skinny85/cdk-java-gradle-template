package com.myorg;

import software.amazon.awscdk.core.App;

public final class CdkJavaGradleTemplateApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkJavaGradleTemplateStack(app, "CdkJavaGradleTemplateStack");

        app.synth();
    }
}
