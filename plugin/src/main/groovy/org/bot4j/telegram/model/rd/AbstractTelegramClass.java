package org.bot4j.telegram.model.rd;

import org.bot4j.telegram.message.HtmlBuilder;
import org.bot4j.telegram.message.MarkdownBuilder;
import org.bot4j.telegram.message.MessageBuilder;
import org.bot4j.telegram.model.builder.TelegramConnectionBuilder;
import org.bot4j.telegram.model.builder.TelegramOptionBuilder;
import org.bot4j.telegram.model.enums.TelegramTextMode;
import org.bot4j.telegram.model.request.TelegramConnections;
import org.bot4j.telegram.model.request.TelegramOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unify4j.common.Class4j;
import org.unify4j.common.Json4j;
import org.unify4j.common.Object4j;
import org.unify4j.model.response.WrapResponse;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractTelegramClass {
    protected final String baseURL = "https://api.telegram.org";
    protected String botToken;
    protected long chatId;
    protected String text;
    protected String parseMode;
    protected Logger logger;
    protected TelegramConnections connections;
    protected TelegramOptions options;

    protected AbstractTelegramClass(Builder<?> builder) {
        this.botToken = builder.botToken;
        this.chatId = builder.chatId;
        this.text = builder.text;
        this.parseMode = builder.parseMode;
        this.logger = builder.logger;
        this.connections = builder.connections != null ? builder.connections : new TelegramConnections();
        this.options = builder.options != null ? builder.options : new TelegramOptions();
    }

    public abstract WrapResponse<?> sendMessage();

    public abstract CompletableFuture<WrapResponse<?>> sendMessageAsync();

    public abstract void sendMessageSilent();

    public abstract void sendMessageWait();

    public abstract WrapResponse<?> verify();

    public abstract Map<String, Object> messageBody();

    public abstract Map<String, String> headers();

    public abstract AbstractTelegramClass requestId(String value);

    public static abstract class Builder<T> {
        private String botToken;
        private long chatId;
        private String text;
        private String parseMode;
        private Logger logger = LoggerFactory.getLogger(getClass());
        private TelegramConnections connections;
        private TelegramOptions options;

        public abstract AbstractTelegramClass build();

        protected abstract T self();

        public T botToken(String value) {
            this.botToken = value;
            return this.self();
        }

        public T chatId(long value) {
            this.chatId = value;
            return this.self();
        }

        public T text(String value) {
            this.text = value;
            return this.self();
        }

        public T text(StringBuilder values) {
            return this.text(values.toString());
        }

        public T text(Object value) {
            if (Object4j.allNotNull(value)) {
                this.text = Class4j.isPrimitive(value.getClass()) ? String.valueOf(value) : Json4j.toJson(value);
            }
            return this.self();
        }

        public T text(MarkdownBuilder builder) {
            if (builder == null) {
                return this.self();
            }
            return this.text(builder.toString());
        }

        public T text(HtmlBuilder builder) {
            if (builder == null) {
                return this.self();
            }
            this.parseMode = TelegramTextMode.HTML.name().toLowerCase();
            return this.text(builder.toString());
        }

        public T text(MessageBuilder<?> builder) {
            if (builder == null) {
                return this.self();
            }
            return this.text(builder.toString());
        }

        public T parseMode(String mode) {
            this.parseMode = mode;
            return this.self();
        }

        public T parseMode(TelegramTextMode mode) {
            return this.parseMode(mode.name().toLowerCase());
        }

        public T markdownSettings() {
            return this.parseMode(TelegramTextMode.Markdown);
        }

        public T markdownV2Settings() {
            return this.parseMode(TelegramTextMode.MarkdownV2);
        }

        public T htmlSettings() {
            return this.parseMode(TelegramTextMode.HTML);
        }

        public T logger(Logger logger) {
            this.logger = logger == null ? LoggerFactory.getLogger(getClass()) : logger;
            return this.self();
        }

        public T logger(Class<?> logger) {
            return this.logger(LoggerFactory.getLogger(logger));
        }

        public T connection(TelegramConnections connections) {
            this.connections = connections;
            return this.self();
        }

        public T connection(TelegramConnectionBuilder builder) {
            return this.connection(builder.build());
        }

        public T options(TelegramOptions options) {
            this.options = options;
            return this.self();
        }

        public T options(TelegramOptionBuilder builder) {
            return this.options(builder.build());
        }
    }
}
