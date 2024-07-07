package org.bot4j.telegram.message;

public abstract class MessageFactory {

    /**
     * Create a MarkdownBuilder instance.
     *
     * @return MarkdownBuilder instance, class {@link MarkdownBuilder}
     */
    public static MarkdownBuilder markdown() {
        return new MarkdownBuilder();
    }

    /**
     * Create a HtmlBuilder instance.
     *
     * @return HtmlBuilder instance, class {@link HtmlBuilder}
     */
    public static HtmlBuilder html() {
        return new HtmlBuilder();
    }

    /**
     * Create a HttpBuilder instance.
     *
     * @return HttpBuilder instance, class {@link HttpBuilder}
     */
    public static HttpBuilder http() {
        return new HttpBuilder();
    }

    /**
     * Create a HttpBuilder instance.
     *
     * @return HttpBuilder instance, class {@link NotifyBuilder}
     */
    public static NotifyBuilder reveal() {
        return new NotifyBuilder();
    }
}
