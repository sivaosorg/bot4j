package org.bot4j.slack.model.rd;

import org.bot4j.slack.model.builder.SlackConnectionBuilder;
import org.bot4j.slack.model.builder.SlackOptionBuilder;
import org.bot4j.slack.model.request.SlackConnections;
import org.bot4j.slack.model.request.SlackOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractSlackClass {
    protected final String baseURL = "https://slack.com/api";
    protected String token;
    protected String channel;
    protected Map<String, Object> message;
    protected Logger logger;
    protected SlackOptions options;
    protected SlackConnections connections;

    protected AbstractSlackClass(Builder<?> builder) {
        this.token = builder.token;
        this.channel = builder.channel;
        this.message = builder.message;
        this.logger = builder.logger;
        this.options = builder.options != null ? builder.options : new SlackOptions();
        this.connections = builder.connections != null ? builder.connections : new SlackConnections();
    }

    public abstract AbstractSlackClass requestId(String value);

    public abstract WrapResponse<?> verify();

    public abstract Map<String, String> headers();

    public abstract Map<String, Object> messageBody();

    public abstract WrapResponse<?> sendMessage();

    public abstract CompletableFuture<WrapResponse<?>> sendMessageAsync();

    public abstract void sendMessageSilent();

    public abstract void sendMessageWait();

    public static abstract class Builder<T> {
        private String token;
        private String channel;
        private Map<String, Object> message;
        private Logger logger = LoggerFactory.getLogger(getClass());
        private SlackOptions options;
        private SlackConnections connections;

        public abstract AbstractSlackClass build();

        protected abstract T self();

        public T token(String token) {
            this.token = token;
            return this.self();
        }

        public T channel(String channel) {
            this.channel = channel;
            return this.self();
        }

        public T message(Map<String, Object> message) {
            this.message = message;
            return this.self();
        }

        public T appendMessage(String key, Object value) {
            if (this.message == null) {
                this.message = new HashMap<>();
            }
            this.message.put(key, value);
            return this.message(this.message);
        }

        public T logger(Logger logger) {
            this.logger = logger == null ? LoggerFactory.getLogger(getClass()) : logger;
            return this.self();
        }

        public T logger(Class<?> logger) {
            return this.logger(LoggerFactory.getLogger(logger));
        }

        public T options(SlackOptions options) {
            this.options = options;
            return this.self();
        }

        public T options(SlackOptionBuilder builder) {
            return this.options(builder.build());
        }

        public T connection(SlackConnections connections) {
            this.connections = connections;
            return this.self();
        }

        public T connection(SlackConnectionBuilder builder) {
            return this.connection(builder.build());
        }
    }
}
