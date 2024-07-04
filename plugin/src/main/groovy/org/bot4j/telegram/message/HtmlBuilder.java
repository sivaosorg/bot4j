package org.bot4j.telegram.message;

import org.unify4j.common.Class4j;
import org.unify4j.common.Json4j;
import org.unify4j.common.String4j;
import org.unify4j.model.c.Ascii;

public class HtmlBuilder {
    protected final StringBuilder message;

    public HtmlBuilder() {
        this.message = new StringBuilder();
    }

    public HtmlBuilder vertical(String text) {
        message.append(String4j.repeat(Ascii.Symbol.VERTICAL_LINE, 2))
                .append(text)
                .append(String4j.repeat(Ascii.Symbol.VERTICAL_LINE, 2));
        return this.space();
    }

    public HtmlBuilder vertical(Object value) {
        if (value == null) {
            return this;
        }
        return this.vertical(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder bold(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_B)
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_B)
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder bold(Object value) {
        if (value == null) {
            return this;
        }
        return this.bold(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder strong(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("strong")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("strong")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder strong(Object value) {
        if (value == null) {
            return this;
        }
        return this.strong(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder italic(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_I)
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_I)
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder italic(Object value) {
        if (value == null) {
            return this;
        }
        return this.italic(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder em(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("em")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("em")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder em(Object value) {
        if (value == null) {
            return this;
        }
        return this.em(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder underline(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_U)
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_U)
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder underline(Object value) {
        if (value == null) {
            return this;
        }
        return this.underline(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder ins(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("ins")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("ins")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder ins(Object value) {
        if (value == null) {
            return this;
        }
        return this.ins(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder strikethrough(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_S)
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_S)
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder strikethrough(Object value) {
        if (value == null) {
            return this;
        }
        return this.strikethrough(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder strike(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("strike")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("strike")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder strike(Object value) {
        if (value == null) {
            return this;
        }
        return this.strike(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder delete(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("del")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("del")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder delete(Object value) {
        if (value == null) {
            return this;
        }
        return this.delete(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder spoiler(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("tg-spoiler")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("tg-spoiler")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder spoiler(Object value) {
        if (value == null) {
            return this;
        }
        return this.spoiler(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder inlineUrl(String text, String url) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_A)
                .append(Ascii.Punctuation.SPACE)
                .append("href=")
                .append(Ascii.Punctuation.REVERSE_SOLIDUS)
                .append(Ascii.Punctuation.QUOTATION_MARK)
                .append(url)
                .append(Ascii.Punctuation.REVERSE_SOLIDUS)
                .append(Ascii.Punctuation.QUOTATION_MARK)
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append(Ascii.Lowercase.LATIN_SMALL_LETTER_A)
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder code(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("code")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("code")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder code(Object value) {
        if (value == null) {
            return this;
        }
        return this.code(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder preformatted(String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("pre")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("pre")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder preformatted(Object value) {
        if (value == null) {
            return this;
        }
        return this.preformatted(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder preformatted(String lang, String text) {
        message.append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("pre")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append("code class=")
                .append(Ascii.Punctuation.REVERSE_SOLIDUS)
                .append(Ascii.Punctuation.QUOTATION_MARK)
                .append("language-")
                .append(lang)
                .append(Ascii.Punctuation.REVERSE_SOLIDUS)
                .append(Ascii.Punctuation.QUOTATION_MARK)
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(text)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("code")
                .append(Ascii.Symbol.GREATER_THAN_SIGN)
                .append(Ascii.Symbol.LESS_THAN_SIGN)
                .append(Ascii.Punctuation.SOLIDUS)
                .append("pre")
                .append(Ascii.Symbol.GREATER_THAN_SIGN);
        return this.space();
    }

    public HtmlBuilder preformatted(String lang, Object value) {
        if (value == null) {
            return this;
        }
        return this.preformatted(lang, Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder text(String text) {
        message.append(text);
        return this.space();
    }

    public HtmlBuilder text(Object value) {
        if (value == null) {
            return this;
        }
        return this.text(Class4j.isPrimitive(value.getClass()) ? value.toString() : Json4j.toJson(value));
    }

    public HtmlBuilder line() {
        return this.text(System.lineSeparator());
    }

    public HtmlBuilder line(int repeat) {
        return this.text(String4j.repeat(System.lineSeparator(), repeat));
    }

    public HtmlBuilder space() {
        message.append(Ascii.Punctuation.SPACE);
        return this;
    }

    public HtmlBuilder space(int repeat) {
        message.append(String4j.repeat(Ascii.Punctuation.SPACE, repeat));
        return this;
    }

    @Override
    public String toString() {
        return this.message.toString();
    }
}
