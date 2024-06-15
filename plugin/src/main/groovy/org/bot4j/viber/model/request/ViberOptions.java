package org.bot4j.viber.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bot4j.base.request.BaseOptions;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViberOptions extends BaseOptions {
    public ViberOptions() {
        super();
    }
}
