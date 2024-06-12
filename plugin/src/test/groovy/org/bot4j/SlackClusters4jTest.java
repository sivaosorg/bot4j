package org.bot4j;

import org.bot4j.slack.common.Slack4j;
import org.bot4j.slack.common.SlackClusters4j;
import org.junit.Before;
import org.junit.Test;
import org.unify4j.model.response.WrapResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class SlackClusters4jTest {
    protected SlackClusters4j slackClusters4j;

    @Before
    public void setUp() {
        Slack4j instance1 = new Slack4j.Builder().build();
        Slack4j instance2 = new Slack4j.Builder().build();
        slackClusters4j = new SlackClusters4j.Builder()
                .append(instance1)
                .append(instance2)
                .build();
    }

    @Test
    public void testSendMessage() {
        List<WrapResponse<?>> responses = slackClusters4j.sendMessage();
        assertNotNull(responses);
        assertEquals(2, responses.size());
    }

    @Test
    public void testSendMessageAsync() throws Exception {
        CompletableFuture<List<WrapResponse<?>>> future = slackClusters4j.sendMessageAsync();
        List<WrapResponse<?>> responses = future.get();
        assertNotNull(responses);
        assertEquals(2, responses.size());
    }

    @Test
    public void testSendMessageSilent() {
        slackClusters4j.sendMessageSilent();
        // Since this is silent, we don't expect any return. Just ensuring no exceptions.
    }

    @Test
    public void testSendMessageWait() {
        slackClusters4j.sendMessageWait();
        // Since this waits for async, we don't expect any return. Just ensuring no exceptions.
    }

    @Test
    public void testVerify() {
        WrapResponse<?> response = slackClusters4j.verify();
        assertNotNull(response);
        assertFalse(response.isSuccess());
    }
}
