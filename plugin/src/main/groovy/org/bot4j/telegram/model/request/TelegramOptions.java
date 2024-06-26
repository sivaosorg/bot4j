package org.bot4j.telegram.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bot4j.base.request.BaseOptions;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelegramOptions extends BaseOptions {
    public TelegramOptions() {
        super();
    }
}
