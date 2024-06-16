package org.bot4j.viber.model.rd;

import org.bot4j.viber.model.builder.ViberConnectionBuilder;
import org.bot4j.viber.model.builder.ViberOptionBuilder;
import org.bot4j.viber.model.enums.ViberTextMode;
import org.bot4j.viber.model.request.ViberConnections;
import org.bot4j.viber.model.request.ViberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unify4j.common.Collection4j;
import org.unify4j.model.c.Pair;
import org.unify4j.model.response.WrapResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractViberClass {
    protected final String baseURL = "https://chatapi.viber.com";
    protected Logger logger;
    protected ViberOptions options;
    protected ViberConnections connections;
    protected Map<String, Object> message;
    protected String token;

    protected AbstractViberClass(Builder<?> builder) {
        this.logger = builder.logger;
        this.options = builder.options;
        this.connections = builder.connections;
        this.message = builder.message;
        this.token = builder.token;
    }

    public abstract AbstractViberClass requestId(String value);

    public abstract WrapResponse<?> verify();

    public abstract Map<String, String> headers();

    public abstract Map<String, Object> messageBody();

    public abstract WrapResponse<?> sendMessage();

    public abstract CompletableFuture<WrapResponse<?>> sendMessageAsync();

    public abstract void sendMessageSilent();

    public abstract void sendMessageWait();

    public static abstract class Builder<T> {
        private Logger logger = LoggerFactory.getLogger(getClass());
        private ViberOptions options;
        private ViberConnections connections;
        private Map<String, Object> message = new HashMap<>();
        private String token;

        public abstract AbstractViberClass build();

        protected abstract T self();

        public T logger(Logger logger) {
            this.logger = logger == null ? LoggerFactory.getLogger(getClass()) : logger;
            return this.self();
        }

        public T logger(Class<?> logger) {
            return this.logger(LoggerFactory.getLogger(logger));
        }

        public T options(ViberOptions options) {
            this.options = options;
            return this.self();
        }

        public T options(ViberOptionBuilder builder) {
            return this.options(builder.build());
        }

        public T connection(ViberConnections connections) {
            this.connections = connections;
            return this.self();
        }

        public T connection(ViberConnectionBuilder builder) {
            return this.connection(builder.build());
        }

        public T message(Map<String, Object> message) {
            this.message = message;
            return this.self();
        }

        @SafeVarargs
        public final T message(Pair<String, Object>... pairs) {
            return this.message(Collection4j.mapOf(pairs));
        }

        public T append(String key, Object value) {
            if (Collection4j.isEmptyMap(this.message)) {
                this.message = new HashMap<>();
            }
            this.message.put(key, value);
            return this.self();
        }

        @SafeVarargs
        public final T append(Pair<String, Object>... pairs) {
            return this.message(pairs);
        }

        public T token(String token) {
            this.token = token;
            return this.self();
        }

        public T type(String type) {
            return this.append("type", type);
        }

        public T type(ViberTextMode type) {
            return this.type(type.getValue());
        }

        public T receiver(String receiver) {
            return this.append("receiver", receiver);
        }

        public T minApiVersion(int apiVersion) {
            return this.append("min_api_version", apiVersion);
        }

        public T sender(String name) {
            Map<String, Object> sender = new HashMap<>();
            sender.put("name", name);
            return this.append("sender", sender);
        }

        public T sender(String name, String avatar) {
            Map<String, Object> sender = new HashMap<>();
            sender.put("name", name);
            sender.put("avatar", avatar);
            return this.append("sender", sender);
        }
    }
}
