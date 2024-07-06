package org.bot4j.telegram.message;

import org.unify4j.common.*;
import org.unify4j.model.c.Ascii;
import org.unify4j.model.enums.TimezoneType;
import org.unify4j.text.TimeFormatText;

import java.nio.file.Path;
import java.util.Date;
import java.util.TimeZone;


public class MarkdownBuilder {
    protected final StringBuilder message;

    public MarkdownBuilder() {
        this.message = new StringBuilder();
    }

    public MarkdownBuilder timestamp(Date date, TimeZone timezone) {
        return this.code(Time4j.format(date, timezone));
    }

    public MarkdownBuilder timestamp(Date date, TimeZone timezone, String format) {
        return this.code(Time4j.format(date, timezone, format));
    }

    public MarkdownBuilder timestamp(Date date, TimezoneType timezone) {
        return this.code(Time4j.format(date, timezone));
    }

    public MarkdownBuilder timestamp(Date date, TimezoneType timezone, String format) {
        return this.code(Time4j.format(date, timezone, format));
    }

    public MarkdownBuilder timestamp(Date date, String format) {
        return this.code(Time4j.format(date, format));
    }

    public MarkdownBuilder timestamp(Date date) {
        return this.code(Time4j.format(date, TimeFormatText.BIBLIOGRAPHY_COMPLETE_EPOCH_PATTERN));
    }

    public MarkdownBuilder timestamp() {
        return this.timestamp(new Date());
    }

    public MarkdownBuilder vertical(String text) {
        message.append(String4j.repeat(Ascii.Symbol.VERTICAL_LINE, 2))
                .append(text)
                .append(String4j.repeat(Ascii.Symbol.VERTICAL_LINE, 2));
        return this.space();
    }

    public MarkdownBuilder vertical(Object value) {
        if (value == null) {
            return this;
        }
        return this.vertical(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder bold(String text) {
        message.append(Ascii.Punctuation.ASTERISK)
                .append(text)
                .append(Ascii.Punctuation.ASTERISK);
        return this.space();
    }

    public MarkdownBuilder bold(Object value) {
        if (value == null) {
            return this;
        }
        return this.bold(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder italic(String text) {
        message.append(Ascii.Punctuation.LOW_LINE)
                .append(text)
                .append(Ascii.Punctuation.LOW_LINE);
        return this.space();
    }

    public MarkdownBuilder italic(Object value) {
        if (value == null) {
            return this;
        }
        return this.italic(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder strikethrough(String text) {
        message.append(Ascii.Symbol.TILDE)
                .append(text)
                .append(Ascii.Symbol.TILDE);
        return this.space();
    }

    public MarkdownBuilder strikethrough(Object value) {
        if (value == null) {
            return this;
        }
        return this.strikethrough(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder underline(String text) {
        message.append(String4j.repeat(Ascii.Punctuation.LOW_LINE, 2))
                .append(text)
                .append(String4j.repeat(Ascii.Punctuation.LOW_LINE, 2));
        return this.space();
    }

    public MarkdownBuilder underline(Object value) {
        if (value == null) {
            return this;
        }
        return this.underline(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder code(String text) {
        message.append(Ascii.Symbol.GRAVE_ACCENT)
                .append(text)
                .append(Ascii.Symbol.GRAVE_ACCENT);
        return this.space();
    }

    public MarkdownBuilder code(Object value) {
        if (value == null) {
            return this;
        }
        return this.code(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder code(Path filename) {
        try {
            String data = Os4j.readFileKeepFormat(filename);
            return this.code(data);
        } catch (Exception e) {
            return this;
        }
    }

    public MarkdownBuilder preformatted(String text) {
        message.append(String4j.repeat(Ascii.Symbol.GRAVE_ACCENT, 3))
                .append(text)
                .append(String4j.repeat(Ascii.Symbol.GRAVE_ACCENT, 3));
        return this.space();
    }

    public MarkdownBuilder preformatted(Object value) {
        if (value == null) {
            return this;
        }
        return this.preformatted(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder preformatted(String lang, String text) {
        message.append(String4j.repeat(Ascii.Symbol.GRAVE_ACCENT, 3))
                .append(lang)
                .append(Ascii.Punctuation.SPACE)
                .append(text)
                .append(String4j.repeat(Ascii.Symbol.GRAVE_ACCENT, 3));
        return this.space();
    }

    public MarkdownBuilder preformatted(String lang, Object value) {
        if (value == null) {
            return this;
        }
        return this.preformatted(lang, Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder preformatted(String lang, Path filename) {
        try {
            String data = Os4j.readFileKeepFormat(filename);
            return this.preformatted(lang, data);
        } catch (Exception e) {
            return this;
        }
    }

    public MarkdownBuilder link(String text, String url) {
        message.append(Ascii.Punctuation.LEFT_SQUARE_BRACKET)
                .append(text)
                .append(Ascii.Punctuation.RIGHT_SQUARE_BRACKET)
                .append(Ascii.Punctuation.LEFT_PARENTHESIS)
                .append(url)
                .append(Ascii.Punctuation.RIGHT_PARENTHESIS);
        return this.space();
    }

    public MarkdownBuilder text(String text) {
        message.append(text);
        return this.space();
    }

    public MarkdownBuilder text(Object value) {
        if (value == null) {
            return this;
        }
        return this.text(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public MarkdownBuilder line() {
        return this.text(System.lineSeparator());
    }

    public MarkdownBuilder line(int repeat) {
        return this.text(String4j.repeat(System.lineSeparator(), repeat));
    }

    public MarkdownBuilder space() {
        message.append(Ascii.Punctuation.SPACE);
        return this;
    }

    public MarkdownBuilder space(int repeat) {
        message.append(String4j.repeat(Ascii.Punctuation.SPACE, repeat));
        return this;
    }

    @Override
    public String toString() {
        return message.toString();
    }
}
