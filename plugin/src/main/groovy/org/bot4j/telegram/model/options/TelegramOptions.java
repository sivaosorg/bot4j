package org.bot4j.telegram.model.options;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.unify4j.common.UniqueId4j;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelegramOptions implements Serializable {
    public TelegramOptions() {
        super();
        this.setRequestId(String.valueOf(UniqueId4j.getUniqueId19()));
    }

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
