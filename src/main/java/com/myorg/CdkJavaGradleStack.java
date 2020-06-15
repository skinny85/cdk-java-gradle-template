package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.Queue;

public final class CdkJavaGradleStack extends Stack {
    public CdkJavaGradleStack(Construct parent, String id) {
        this(parent, id, null);
    }

    public CdkJavaGradleStack(Construct parent, String id, StackProps props) {
        super(parent, id, props);

        Queue queue = Queue.Builder.create(this, "Queue")
                .visibilityTimeout(Duration.seconds(300))
                .build();

        Topic topic = Topic.Builder.create(this, "Topic")
            .displayName("My first topic, yeah!")
            .build();

        topic.addSubscription(new SqsSubscription(queue));
    }
}
