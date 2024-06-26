package org.bot4j.slack.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bot4j.base.request.BaseConnections;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlackConnections extends BaseConnections {
    public SlackConnections() {
        super();
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Slack", super.toString());
    }
}
