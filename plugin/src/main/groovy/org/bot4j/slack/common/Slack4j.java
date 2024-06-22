package org.bot4j.slack.common;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.bot4j.slack.model.rd.AbstractSlackClass;
import org.unify4j.common.*;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.builder.HttpWrapBuilder;
import org.unify4j.model.c.HttpHeaders;
import org.unify4j.model.c.MediaType;
import org.unify4j.model.enums.AuthType;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Slack4j extends AbstractSlackClass {
    protected Slack4j(Builder builder) {
        super(builder);
    }

    @Override
    public Slack4j requestId(String value) {
        if (this.options == null) {
            return this;
        }
        this.options.setRequestId(value);
        return this;
    }

    @Override
    public WrapResponse<?> verify() {
        if (String4j.isEmpty(this.token)) {
            return new HttpWrapBuilder<>().badRequest("Token is required").build();
        }
        if (String4j.isEmpty(this.channel)) {
            return new HttpWrapBuilder<>().badRequest("Channel is required").build();
        }
        if (Collection4j.isEmptyMap(this.message)) {
            return new HttpWrapBuilder<>().badRequest("Body message is required").build();
        }
        return new HttpWrapBuilder<>().ok(null).build();
    }

    @Override
    public Map<String, String> headers() {
        Auth4j auth4j = new Auth4j.Builder().type(AuthType.BEARER).token(this.token).build();
        Map<String, String> headers = auth4j.getHeaders();
        if (Collection4j.isEmptyMap(headers)) {
            return headers;
        }
        headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.getName());
        return headers;
    }

    @Override
    public Map<String, Object> messageBody() {
        Map<String, Object> request = this.message;
        if (Collection4j.isEmptyMap(request)) {
            request = new HashMap<>();
        }
        request.put("channel", this.channel);
        return request;
    }

    @Override
    public WrapResponse<?> sendMessage() {
        if (this.connections.isSkip()) {
            return new HttpWrapBuilder<>().notImplemented("Oops! Slack4j unavailable").build();
        }
        WrapResponse<?> verified = this.verify();
        if (!verified.isSuccess()) {
            return verified;
        }
        String url = String.format("%s/chat.postMessage", this.baseURL);
        Map<String, Object> request = this.messageBody();
        Map<String, String> headers = this.headers();
        if (this.connections.isDebugging()) {
            this.logger.info("Slack4j, request_id: {} sending message on URL: {}", this.options.getRequestId(), url);
            this.logger.info("Slack4j, request_id: {} sending request body: {}", this.options.getRequestId(), Json4j.toJson(request));
            this.logger.info("Slack4j, request_id: {} sending request header: {}", this.options.getRequestId(), headers.toString());
        }
        try {
            HttpResponse<JsonNode> caller = Unirest.post(url).headers(headers).body(request).asJson();
            WrapResponse<Object> response = new HttpWrapBuilder<>()
                    .statusCode(caller.getStatus())
                    .requestId(this.options.getRequestId())
                    .body(Json4j.translate(caller))
                    .total(1)
                    .build();
            if (Object4j.allNotNull(caller.getBody())) {
                String message = Json4j.readIf(caller.getBody().toString(), "$.error");
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

    @Override
    public CompletableFuture<WrapResponse<?>> sendMessageAsync() {
        return CompletableFuture.supplyAsync(this::sendMessage);
    }

    @Override
    public void sendMessageSilent() {
        CompletableFuture.runAsync(this::sendMessage);
    }

    @Override
    public void sendMessageWait() {
        this.sendMessageAsync().join();
    }

    public static class Builder extends AbstractSlackClass.Builder<Builder> {
        @Override
        public Slack4j build() {
            return new Slack4j(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
