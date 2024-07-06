package org.bot4j.telegram.message;

public abstract class MessageFactory {

    public static MarkdownBuilder createMarkdownBuilder() {
        return new MarkdownBuilder();
    }

    public static HtmlBuilder createHtmlBuilder() {
        return new HtmlBuilder();
    }
}
