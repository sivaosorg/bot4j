package org.bot4j.slack.model.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bot4j.slack.model.request.SlackConnections;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackConnectionBuilder implements Serializable {
    public SlackConnectionBuilder() {
        super();
    }

    private boolean debugging = false; // enable to trace log as debug mode
    private boolean skip = false; // skipping the action for sending message
    private boolean retry = false; // enable retry REST HTTP Telegram API when sending message got failure
    private int maxRetries = 2; // retry no. times when sending message, default is 2 times

    public SlackConnectionBuilder debugging(boolean value) {
        this.debugging = value;
        return this;
    }

    public SlackConnectionBuilder skip(boolean value) {
        this.skip = value;
        return this;
    }

    public SlackConnectionBuilder retry(boolean value) {
        this.retry = value;
        return this;
    }

    public SlackConnectionBuilder maxRetries(int value) {
        this.maxRetries = value;
        return this;
    }

    public SlackConnections build() {
        SlackConnections e = new SlackConnections();
        e.setDebugging(debugging);
        e.setSkip(skip);
        e.setRetry(retry);
        e.setMaxRetries(maxRetries);
        return e;
    }
}
