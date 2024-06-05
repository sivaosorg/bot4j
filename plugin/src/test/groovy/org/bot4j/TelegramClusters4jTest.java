package org.bot4j;

import org.bot4j.telegram.common.Telegram4j;
import org.bot4j.telegram.common.TelegramClusters4j;
import org.junit.Before;
import org.junit.Test;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.response.WrapResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class TelegramClusters4jTest {

    private TelegramClusters4j telegramClusters4j;

    @Before
    public void setUp() {
        List<Telegram4j> instances = new ArrayList<>();
        instances.add(new Telegram4j.Builder().botToken("6806983892:AAGcPZiuNktLFnyVWrRyOyYssECcVmNJSRo").chatId(-1002042977093L).text("Message 1").parseMode("Markdown").build());
        instances.add(new Telegram4j.Builder().botToken("6806983892:AAGcPZiuNktLFnyVWrRyOyYssECcVmNJSRo").chatId(-1002042977093L).text("Message 2").parseMode("Markdown").build());

        telegramClusters4j = new TelegramClusters4j.Builder().append(instances.get(0)).append(instances.get(1)).build();
    }

    @Test
    public void testSendMessage() {
        List<WrapResponse<?>> responses = telegramClusters4j.sendMessage();

        assertEquals(2, responses.size());
        assertTrue(responses.stream().allMatch(WrapResponse::isSuccess));
    }

    @Test
    public void testSendMessageAsync() {
        CompletableFuture<List<WrapResponse<?>>> future = telegramClusters4j.sendMessageAsync();

        assertNotNull(future);
        List<WrapResponse<?>> responses = future.join();
        assertEquals(2, responses.size());
        assertTrue(responses.stream().allMatch(WrapResponse::isSuccess));
    }

    @Test
    public void testSendMessageSilent() {
        try {
            telegramClusters4j.sendMessageSilent();
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testSendMessageWait() {
        try {
            telegramClusters4j.sendMessageWait();
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testVerify_Success() {
        WrapResponse<?> response = telegramClusters4j.verify();

        assertEquals(HttpStatusBuilder.OK.getCode(), response.getStatusCode());
        assertTrue(response.isSuccess());
    }
}
