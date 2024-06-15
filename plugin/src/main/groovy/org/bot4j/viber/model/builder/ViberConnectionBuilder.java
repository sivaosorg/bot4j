package org.bot4j.viber.model.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bot4j.viber.model.request.ViberConnections;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViberConnectionBuilder implements Serializable {
    public ViberConnectionBuilder() {
        super();
    }

    private boolean debugging = false; // enable to trace log as debug mode
    private boolean skip = false; // skipping the action for sending message
    private boolean retry = false; // enable retry REST HTTP API when sending message got failure
    private int maxRetries = 2; // retry no. times when sending message, default is 2 times

    public ViberConnectionBuilder debugging(boolean value) {
        this.debugging = value;
        return this;
    }

    public ViberConnectionBuilder skip(boolean value) {
        this.skip = value;
        return this;
    }

    public ViberConnectionBuilder retry(boolean value) {
        this.retry = value;
        return this;
    }

    public ViberConnectionBuilder maxRetries(int value) {
        this.maxRetries = value;
        return this;
    }

    public ViberConnections build() {
        ViberConnections e = new ViberConnections();
        e.setDebugging(debugging);
        e.setSkip(skip);
        e.setRetry(retry);
        e.setMaxRetries(maxRetries);
        return e;
    }
}
