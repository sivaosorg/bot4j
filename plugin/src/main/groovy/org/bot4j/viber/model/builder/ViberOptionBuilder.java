package org.bot4j.viber.model.builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bot4j.viber.model.request.ViberOptions;
import org.unify4j.common.UniqueId4j;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViberOptionBuilder implements Serializable {
    public ViberOptionBuilder() {
        super();
        this.requestId = String.valueOf(UniqueId4j.getUniqueId19());
    }

    private String requestId;

    public ViberOptionBuilder requestId(String value) {
        this.requestId = value;
        return this;
    }

    public ViberOptions build() {
        ViberOptions e = new ViberOptions();
        e.setRequestId(this.requestId);
        return e;
    }
}
