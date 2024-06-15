package org.bot4j.viber.model.rd;

import org.bot4j.slack.model.rd.AbstractSlackClass;
import org.bot4j.viber.model.builder.ViberConnectionBuilder;
import org.bot4j.viber.model.builder.ViberOptionBuilder;
import org.bot4j.viber.model.request.ViberConnections;
import org.bot4j.viber.model.request.ViberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractViberClass {
    protected final String baseURL = "https://chatapi.viber.com";
    protected Logger logger;
    protected ViberOptions options;
    protected ViberConnections connections;
    protected Map<String, Object> message;

    protected AbstractViberClass(Builder<?> builder) {
        this.logger = builder.logger;
        this.options = builder.options;
        this.connections = builder.connections;
        this.message = builder.message;
    }

    public static abstract class Builder<T> {
        private Logger logger = LoggerFactory.getLogger(getClass());
        private ViberOptions options;
        private ViberConnections connections;
        private Map<String, Object> message = new HashMap<>();

        public abstract AbstractSlackClass build();

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

        public T field(String key, Object value) {
            this.message.put(key, value);
            return this.self();
        }
    }
}
