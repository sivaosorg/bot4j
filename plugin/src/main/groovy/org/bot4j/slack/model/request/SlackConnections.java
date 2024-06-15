package org.bot4j.slack.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlackConnections implements Serializable {
    public SlackConnections() {
        super();
    }

    private boolean debugging = false; // enable to trace log as debug mode
    private boolean skip = false; // skipping the action for sending message
    private boolean retry = false; // enable retry REST HTTP Telegram API when sending message got failure
    private int maxRetries = 2; // retry no. times when sending message, default is 2 times

    public boolean isDebugging() {
        return debugging;
    }

    public void setDebugging(boolean debugging) {
        this.debugging = debugging;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public String toString() {
        return String.format("Slack connections { debugging: %s, skip: %s, retry: %s, max_retries: %d }",
                this.debugging, this.skip, this.retry, this.maxRetries);
    }
}
