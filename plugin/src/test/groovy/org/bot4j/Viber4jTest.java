package org.bot4j;

import org.bot4j.viber.common.Viber4j;
import org.bot4j.viber.model.enums.ViberTextMode;
import org.bot4j.viber.model.request.ViberConnections;
import org.bot4j.viber.model.request.ViberOptions;
import org.junit.Before;
import org.junit.Test;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class Viber4jTest {

    private Viber4j viber4j;

    @Before
    public void setUp() {
        ViberOptions options = new ViberOptions();
        ViberConnections connections = new ViberConnections();
        Map<String, Object> message = new HashMap<>();
        message.put("receiver", "123456");
        message.put("type", ViberTextMode.TEXT.getValue());
        message.put("sender", Map.of("name", "Test Sender"));
        message.put("text", "Hello, Viber!");

        viber4j = new Viber4j.Builder().token("test-token").options(options).connection(connections).message(message).build();
    }

    @Test
    public void testVerifySuccess() {
        WrapResponse<?> response = viber4j.verify();
        assertTrue(response.isSuccess());
    }

    @Test
    public void testVerifyNoToken() {
        viber4j = new Viber4j.Builder().options(new ViberOptions()).connection(new ViberConnections()).message(viber4j.messageBody()).build();

        WrapResponse<?> response = viber4j.verify();
        assertFalse(response.isSuccess());
        assertEquals("Token is required", response.getMessage());
    }

    @Test
    public void testVerifyInvalidReceiver() {
        viber4j = new Viber4j.Builder().token("test-token").append("text", 123).options(new ViberOptions()).connection(new ViberConnections()).build();

        WrapResponse<?> response = viber4j.verify();
        assertFalse(response.isSuccess());
        assertEquals("Receiver is required", response.getMessage());
    }

    @Test
    public void testVerifyInvalidMessageType() {
        Map<String, Object> message = new HashMap<>();
        message.put("receiver", "123456");
        message.put("type", "invalid_type");
        message.put("sender", Map.of("name", "Test Sender"));

        viber4j = new Viber4j.Builder().token("test-token").options(new ViberOptions()).connection(new ViberConnections()).message(message).build();

        WrapResponse<?> response = viber4j.verify();
        assertFalse(response.isSuccess());
        assertEquals("Invalid message type", response.getMessage());
    }

    @Test
    public void testHeaders() {
        Map<String, String> headers = viber4j.headers();
        assertEquals(1, headers.size());
        assertEquals("test-token", headers.get("X-Viber-Auth-Token"));
    }

    @Test
    public void testMessageBody() {
        Map<String, Object> messageBody = viber4j.messageBody();
        assertEquals(4, messageBody.size());
        assertEquals("123456", messageBody.get("receiver"));
        assertEquals("text", messageBody.get("type"));
        assertEquals(Map.of("name", "Test Sender"), messageBody.get("sender"));
        assertEquals("Hello, Viber!", messageBody.get("text"));
    }

    @Test
    public void testSendMessage() {
        // Since sendMessage involves external interaction, we can only test the structure and pre-conditions
        WrapResponse<?> response = viber4j.sendMessage();
        // This test will check if the method executes without throwing exceptions.
        assertNotNull(response);
    }

    @Test
    public void testSendMessageAsync() {
        CompletableFuture<WrapResponse<?>> future = viber4j.sendMessageAsync();
        WrapResponse<?> response = future.join();
        // This test will check if the method executes without throwing exceptions.
        assertNotNull(response);
    }

    @Test
    public void testSendMessageSilent() {
        // Test if sendMessageSilent runs without exceptions.
        viber4j.sendMessageSilent();
    }

    @Test
    public void testSendMessageWait() {
        // Test if sendMessageWait runs and completes without exceptions.
        viber4j.sendMessageWait();
    }
}
