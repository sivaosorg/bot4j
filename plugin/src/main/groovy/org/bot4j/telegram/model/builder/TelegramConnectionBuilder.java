package org.bot4j.telegram.model.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bot4j.telegram.model.request.TelegramConnections;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramConnectionBuilder implements Serializable {
    public TelegramConnectionBuilder() {
        super();
    }

    private boolean debugging = false; // enable to trace log as debug mode
    private boolean skip = false; // skipping the action for sending message
    private boolean retry = false; // enable retry REST HTTP Telegram API when sending message got failure
    private int maxRetries = 2; // retry no. times when sending message, default is 2 times

    public TelegramConnectionBuilder debugging(boolean value) {
        this.debugging = value;
        return this;
    }

    public TelegramConnectionBuilder skip(boolean value) {
        this.skip = value;
        return this;
    }

    public TelegramConnectionBuilder retry(boolean value) {
        this.retry = value;
        return this;
    }

    public TelegramConnectionBuilder maxRetries(int value) {
        this.maxRetries = value;
        return this;
    }

    public TelegramConnections build() {
        TelegramConnections e = new TelegramConnections();
        e.setDebugging(debugging);
        e.setSkip(skip);
        e.setRetry(retry);
        e.setMaxRetries(maxRetries);
        return e;
    }
}
