package org.bot4j;

import org.bot4j.slack.common.Slack4j;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class Slack4jTest {

    private Slack4j slack4j;
    private final String token = "xoxb-XXX-XXX-XXX";
    private final String channel = "XXXX";
    private final Map<String, Object> message = new HashMap<>();

    @Before
    public void setUp() {
        Logger logger = LoggerFactory.getLogger(Slack4jTest.class);
        message.put("text", "Hi");
        slack4j = new Slack4j.Builder().token(token).channel(channel).message(message).logger(logger).build();
    }

    @Test
    public void testVerify() {
        WrapResponse<?> response = slack4j.verify();
        System.out.println(response);
        assertTrue(response.isSuccess());
    }

    @Test
    public void testHeaders() {
        Map<String, String> headers = slack4j.headers();
        assertNotNull(headers);
        assertEquals("application/json", headers.get("Content-Type"));
    }

    @Test
    public void testMessageBody() {
        Map<String, Object> requestBody = slack4j.messageBody();
        assertNotNull(requestBody);
        assertEquals(channel, requestBody.get("channel"));
    }

    @Test
    public void testSendMessage() {
        // This test requires actual Slack credentials and network access.
        // It should ideally be a separate integration test rather than a unit test.
        WrapResponse<?> response = slack4j.sendMessage();
        System.out.println(response);
        assertNotNull(response);
        assertTrue(response.isSuccess());
    }

    @Test
    public void testSendMessageAsync() throws Exception {
        CompletableFuture<WrapResponse<?>> future = slack4j.sendMessageAsync();
        WrapResponse<?> response = future.get();
        System.out.println(response);
        assertNotNull(response);
        assertTrue(response.isSuccess());
    }

    @Test
    public void testSendMessageSilent() {
        slack4j.sendMessageSilent();
        // Not much to assert here since it's async and silent.
    }

    @Test
    public void testSendMessageWait() {
        slack4j.sendMessageWait();
        // Not much to assert here since it's async but waits for completion.
    }
}
