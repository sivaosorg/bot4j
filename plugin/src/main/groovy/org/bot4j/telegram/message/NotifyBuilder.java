package org.bot4j.telegram.message;

import org.alpha4j.common.Map4j;

public class NotifyBuilder extends MarkdownBuilder {
    protected final Map4j<String, Object> placeholders;

    public NotifyBuilder() {
        super();
        this.placeholders = new Map4j<>();
    }

    protected static class Index {
        public static final String CAUSE_INDEX = "cause_index";
    }

    public NotifyBuilder cause(Throwable e) {
        if (e == null) {
            return this;
        }
        this.placeholders.put(Index.CAUSE_INDEX, e.getMessage());
        return this;
    }

    @Override
    public String toString() {
        if (this.placeholders.containsKey(Index.CAUSE_INDEX)) {
            this.line().bold("Cause:")
                    .preformatted("bash", (String) this.placeholders.get(Index.CAUSE_INDEX))
                    .line();
        }
        return super.toString();
    }
}
