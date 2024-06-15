package org.bot4j.slack.model.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bot4j.slack.model.request.SlackOptions;
import org.unify4j.common.UniqueId4j;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackOptionBuilder implements Serializable {
    public SlackOptionBuilder() {
        super();
        this.requestId = String.valueOf(UniqueId4j.getUniqueId19());
    }

    private String requestId;

    public SlackOptionBuilder requestId(String value) {
        this.requestId = value;
        return this;
    }

    public SlackOptions build() {
        SlackOptions e = new SlackOptions();
        e.setRequestId(this.requestId);
        return e;
    }
}
