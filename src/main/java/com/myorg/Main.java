package com.myorg;

import software.amazon.awscdk.core.App;

public final class Main {
    public static void main(String[] args) {
        App app = new App();

        new CdkJavaGradleStack(app, "CdkJavaGradleStack");

        app.synth();
    }
}
