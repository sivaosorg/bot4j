package org.bot4j.telegram.model.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bot4j.telegram.model.options.TelegramOptions;
import org.unify4j.common.UniqueId4j;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramOptionBuilder implements Serializable {
    public TelegramOptionBuilder() {
        super();
        this.requestId = String.valueOf(UniqueId4j.getUniqueId19());
    }

    private String requestId;

    public TelegramOptionBuilder requestId(String value) {
        this.requestId = value;
        return this;
    }

    public TelegramOptions build() {
        TelegramOptions e = new TelegramOptions();
        e.setRequestId(requestId);
        return e;
    }
}
