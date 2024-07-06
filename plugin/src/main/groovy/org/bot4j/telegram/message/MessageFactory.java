package org.bot4j.telegram.message;

public abstract class MessageFactory {

    /**
     * Create a MarkdownBuilder instance.
     *
     * @return MarkdownBuilder instance
     */
    public static MarkdownBuilder markdown() {
        return new MarkdownBuilder();
    }

    /**
     * Create a HtmlBuilder instance.
     *
     * @return HtmlBuilder instance
     */
    public static HtmlBuilder html() {
        return new HtmlBuilder();
    }
}
