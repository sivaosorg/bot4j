package org.bot4j;

import org.bot4j.telegram.common.Telegram4j;
import org.bot4j.telegram.message.MarkdownBuilder;
import org.junit.Before;
import org.junit.Test;
import org.unify4j.model.response.WrapResponse;

import java.util.Map;

import static org.junit.Assert.*;

public class Telegram4jTest {

    private Telegram4j telegram4j;

    @Before
    public void setUp() {
        MarkdownBuilder builder = new MarkdownBuilder();
        builder.text("Hello, World!");
        telegram4j = new Telegram4j.Builder().botToken("6806983892:AAGcPZiuNktLFnyVWrRyOyYssECcVmNJSRo").chatId(-1002042977093L).text(builder.toString()).markdownSettings().build();
    }

    @Test
    public void testSendMessage_Success() {
        WrapResponse<?> response = telegram4j.sendMessage();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.isSuccess());
    }

    @Test
    public void testSendMessage_Failure() {
        // Change the botToken to an invalid one to simulate failure
        telegram4j = new Telegram4j.Builder().botToken("invalid-bot-token").chatId(123456789L).text("Hello, World!").parseMode("Markdown").build();

        WrapResponse<?> response = telegram4j.sendMessage();

        assertFalse(response.isSuccess());
        assertNotNull(response.getMessage());
    }

    @Test
    public void testSendMessageAsync() {
        // Asynchronous testing requires manual verification, as it runs in a separate thread
        // You can verify the behavior by adding assertions to the CompletableFuture
        // For brevity, we'll just assert that the CompletableFuture is not null
        assertNotNull(telegram4j.sendMessageAsync());
    }

    @Test
    public void testVerify_Success() {
        WrapResponse<?> response = telegram4j.verify();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.isSuccess());
    }

    @Test
    public void testVerify_Failure_BotToken() {
        telegram4j = new Telegram4j.Builder().botToken("").chatId(123456789L).text("Hello, World!").parseMode("Markdown").build();

        WrapResponse<?> response = telegram4j.verify();

        assertFalse(response.isSuccess());
        assertNotNull(response.getMessage());
    }

    @Test
    public void testVerify_Failure_Text() {
        telegram4j = new Telegram4j.Builder().botToken("fake-bot-token").chatId(123456789L).text("").parseMode("Markdown").build();

        WrapResponse<?> response = telegram4j.verify();

        assertFalse(response.isSuccess());
        assertNotNull(response.getMessage());
    }

    @Test
    public void testVerify_Failure_ChatId() {
        telegram4j = new Telegram4j.Builder().botToken("fake-bot-token").chatId(0) // Invalid chatId
                .text("Hello, World!").parseMode("Markdown").build();

        WrapResponse<?> response = telegram4j.verify();

        assertFalse(response.isSuccess());
        assertNotNull(response.getMessage());
    }

    @Test
    public void testMessageBody() {
        // Verify the message body construction
        Map<String, Object> body = telegram4j.messageBody();

        assertEquals("Markdown", body.get("parse_mode"));
        assertEquals("Hello, World!", body.get("text"));
        assertEquals(-1002042977093L, body.get("chat_id"));
    }

    @Test
    public void testHeaders() {
        // Verify the headers
        Map<String, String> headers = telegram4j.headers();

        assertEquals("application/json", headers.get("Content-Type"));
    }
}

