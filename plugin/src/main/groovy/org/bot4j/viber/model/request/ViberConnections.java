package org.bot4j.viber.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bot4j.base.request.BaseConnections;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViberConnections extends BaseConnections {
    public ViberConnections() {
        super();
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Viber", super.toString());
    }
}
