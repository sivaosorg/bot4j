package org.bot4j.viber.common;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.bot4j.viber.model.enums.ViberTextMode;
import org.bot4j.viber.model.rd.AbstractViberClass;
import org.unify4j.common.Collection4j;
import org.unify4j.common.Json4j;
import org.unify4j.common.Object4j;
import org.unify4j.common.String4j;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.builder.HttpWrapBuilder;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class Viber4j extends AbstractViberClass {
    protected Viber4j(Builder builder) {
        super(builder);
    }

    @Override
    public AbstractViberClass requestId(String value) {
        if (this.options == null) {
            return this;
        }
        this.options.setRequestId(value);
        return this;
    }

    @SuppressWarnings({"SimplifyOptionalCallChains"})
    @Override
    public WrapResponse<?> verify() {
        if (String4j.isEmpty(this.token)) {
            return new HttpWrapBuilder<>().badRequest("Token is required")
                    .debug("X-Viber-Auth-Token", "Each API request must include an HTTP Header called X-Viber-Auth-Token containing the account’s authentication token.")
                    .debug("X-Viber-Auth-Token", "The authentication token is generated upon bot creation and can be viewed by the account’s admins in the “edit info” screen of their bot or on the Viber Admin Panel.")
                    .build();
        }
        Map<String, Object> request = this.messageBody();
        if (Collection4j.isEmptyMap(request)) {
            return new HttpWrapBuilder<>().badRequest("Request body is required").build();
        }
        if (!request.containsKey("receiver") || !Object4j.allNotNull(request.get("receiver"))) {
            return new HttpWrapBuilder<>().badRequest("Receiver is required")
                    .debug("receiver", "Unique Viber user id")
                    .build();
        }
        if (!request.containsKey("type") || !Object4j.allNotNull(request.get("type"))) {
            return new HttpWrapBuilder<>().badRequest("Message type is required").build();
        }
        Optional<ViberTextMode> type = ViberTextMode.tryValueOf(String.valueOf(request.get("type")));
        if (!type.isPresent()) {
            return new HttpWrapBuilder<>().badRequest("Invalid message type")
                    .debug("type", "Available message types: text, picture, video, file, location, contact, sticker, carousel, content and url")
                    .build();
        }
        if (!request.containsKey("sender")) {
            return new HttpWrapBuilder<>().badRequest("Sender is required").build();
        }
        String senderName = Json4j.readIf(Json4j.toJson(request), "$.sender.name");
        int _len = 28;
        if (String4j.isEmpty(senderName)) {
            return new HttpWrapBuilder<>().badRequest("Sender name is required")
                    .debug("sender.name", "The sender’s name to display")
                    .build();
        }
        if (senderName.length() > _len) {
            return new HttpWrapBuilder<>().badRequest("Invalid sender name")
                    .debug("sender.name", String.format("Minimum length of sender name is %d characters.", _len))
                    .build();
        }
        if (request.containsKey("text")) {
            String text = String.valueOf(request.get("text"));
            if (String4j.isEmpty(text)) {
                return new HttpWrapBuilder<>().badRequest("Text of message is required").build();
            }
            if (String4j.isBlank(text)) {
                return new HttpWrapBuilder<>().badRequest(String.format("Invalid text of message: '%s'", text)).build();
            }
            int len = 7000;
            if (text.length() > len) {
                return new HttpWrapBuilder<>().badRequest("Invalid text of message")
                        .debug("text", String.format("Minimum length of text is %d characters.", len))
                        .build();
            }
        }
        if (request.containsKey("tracking_data")) {
            String tracking = String.valueOf(request.get("tracking_data"));
            if (String4j.isEmpty(tracking)) {
                return new HttpWrapBuilder<>().badRequest("Tracking data is required")
                        .debug("tracking_data", "Allow the account to track messages and user’s replies. Sent tracking_data value will be passed back with user’s reply")
                        .build();
            }
            int len = 4096;
            if (tracking.length() > len) {
                return new HttpWrapBuilder<>().badRequest("Invalid tracking data")
                        .debug("tracking_data", String.format("Minimum length of tracking_data is %d characters.", len))
                        .build();
            }
        }
        return new HttpWrapBuilder<>().ok(null).build();
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Viber-Auth-Token", this.token);
        return headers;
    }

    @Override
    public Map<String, Object> messageBody() {
        return this.message;
    }

    @Override
    public WrapResponse<?> sendMessage() {
        if (this.connections.isSkip()) {
            return new HttpWrapBuilder<>().notImplemented("Oops! Viber4j unavailable").build();
        }
        WrapResponse<?> verified = this.verify();
        if (!verified.isSuccess()) {
            return verified;
        }
        String url = String.format("%s/pa/send_message", this.baseURL);
        Map<String, Object> request = this.messageBody();
        Map<String, String> headers = this.headers();
        if (this.connections.isDebugging()) {
            this.logger.info("Viber4j, request_id: {} sending message on URL: {}", this.options.getRequestId(), url);
            this.logger.info("Viber4j, request_id: {} sending request body: {}", this.options.getRequestId(), Json4j.toJson(request));
            this.logger.info("Viber4j, request_id: {} sending request header: {}", this.options.getRequestId(), headers.toString());
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
                String message = Json4j.readIf(caller.getBody().toString(), "$.status_message");
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

    public static class Builder extends AbstractViberClass.Builder<Builder> {
        @Override
        public Viber4j build() {
            return new Viber4j(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
