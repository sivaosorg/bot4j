package org.bot4j.telegram.common;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.bot4j.telegram.model.rd.AbstractTelegramClass;
import org.unify4j.common.Json4j;
import org.unify4j.common.Object4j;
import org.unify4j.common.String4j;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.builder.HttpWrapBuilder;
import org.unify4j.model.builder.WrapBuilder;
import org.unify4j.model.c.HttpHeaders;
import org.unify4j.model.c.MediaType;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Telegram4j extends AbstractTelegramClass {
    protected Telegram4j(Builder builder) {
        super(builder);
    }

    /**
     * Sends a message to the Telegram API.
     *
     * @return a WrapResponse<?> object containing the response from the Telegram API, class {@link WrapResponse}
     */
    @Override
    public WrapResponse<?> sendMessage() {
        if (this.connections.isSkip()) {
            return new HttpWrapBuilder<>().notImplemented("Oops! Telegram4j unavailable").build();
        }
        WrapResponse<?> verified = this.verify();
        if (!verified.isSuccess()) {
            return verified;
        }
        String url = String.format("%s/bot%s/sendMessage", this.baseURL, this.botToken);
        Map<String, Object> request = this.messageBody();
        Map<String, String> headers = this.headers();
        if (this.connections.isDebugging()) {
            this.logger.info("Telegram4j, request_id: {} sending message on URL: {}", this.options.getRequestId(), url);
            this.logger.info("Telegram4j, request_id: {} sending request body: {}", this.options.getRequestId(), Json4j.toJson(request));
            this.logger.info("Telegram4j, request_id: {} sending request header: {}", this.options.getRequestId(), headers.toString());
        }
        try {
            HttpResponse<JsonNode> caller = Unirest.post(url).headers(headers).body(request).asJson();
            WrapResponse<Object> response = new HttpWrapBuilder<>()
                    .statusCode(caller.getStatus())
                    .requestId(this.options.getRequestId())
                    .body(Json4j.translate(caller))
                    .total(1)
                    .build();
            if (Object4j.allNotNull(caller.getBody()) && !caller.isSuccess()) {
                String message = Json4j.readIf(caller.getBody().toString(), "$.description");
                response.setMessage(message);
            }
            return response;
        } catch (Exception e) {
            return new HttpWrapBuilder<>()
                    .statusCode(HttpStatusBuilder.INTERNAL_SERVER_ERROR)
                    .errors(e)
                    .requestId(this.options.getRequestId())
                    .build();
        }
    }

    /**
     * Sends a message to the Telegram API asynchronously.
     *
     * @return a CompletableFuture<WrapResponse<?>> representing the asynchronous operation, class {@link CompletableFuture}
     * @see #sendMessage()
     */
    @Override
    public CompletableFuture<WrapResponse<?>> sendMessageAsync() {
        return CompletableFuture.supplyAsync(this::sendMessage);
    }

    /**
     * Sends a message to the Telegram API silently (without waiting for the result).
     *
     * @see #sendMessage()
     */
    @Override
    public void sendMessageSilent() {
        CompletableFuture.runAsync(this::sendMessage);
    }

    /**
     * Sends a message to the Telegram API and waits for the result.
     *
     * @see #sendMessageAsync()
     */
    @Override
    public void sendMessageWait() {
        this.sendMessageAsync().join();
    }

    @Override
    public WrapResponse<?> verify() {
        if (String4j.isEmpty(this.botToken)) {
            return new WrapBuilder<>()
                    .setStatusCode(HttpStatusBuilder.BAD_REQUEST)
                    .setMessage("bot_token is required").build();
        }
        if (String4j.isEmpty(this.text)) {
            return new WrapBuilder<>()
                    .setStatusCode(HttpStatusBuilder.BAD_REQUEST)
                    .setMessage("text is required").build();
        }
        if (this.chatId == 0) {
            return new WrapBuilder<>()
                    .setStatusCode(HttpStatusBuilder.BAD_REQUEST)
                    .setMessage(String.format("Invalid chat_id: %d", this.chatId)).build();
        }
        if (String4j.isEmpty(this.parseMode)) {
            return new WrapBuilder<>()
                    .setStatusCode(HttpStatusBuilder.BAD_REQUEST)
                    .setMessage("parse_mode is required").build();
        }
        return new WrapBuilder<>().setStatusCode(HttpStatusBuilder.OK).build();
    }

    @Override
    public Map<String, Object> messageBody() {
        Map<String, Object> request = new HashMap<>();
        request.put("parse_mode", this.parseMode);
        request.put("text", this.text);
        request.put("chat_id", this.chatId);
        return request;
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> header = new HashMap<>();
        header.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.getName());
        return header;
    }

    /**
     * @param value the request_id from client
     */
    @Override
    public Telegram4j requestId(String value) {
        if (this.options == null) {
            return this;
        }
        this.options.setRequestId(value);
        return this;
    }

    public static class Builder extends AbstractTelegramClass.Builder<Builder> {
        @Override
        public Telegram4j build() {
            return new Telegram4j(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
