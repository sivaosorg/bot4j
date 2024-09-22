package org.bot4j.telegram.message;

import org.bot4j.telegram.model.enums.TelegramIconMode;
import org.unify4j.model.enums.TimezoneType;

import java.nio.file.Path;
import java.util.Date;
import java.util.TimeZone;

public interface MessageBuilder<T> {

    T icon(TelegramIconMode mode);

    T icon(TelegramIconMode mode, int repeat);

    T timestamp(Date date, TimeZone timezone);

    T timestamp(Date date, TimeZone timezone, String format);

    T timestamp(Date date, TimezoneType timezone);

    T timestamp(Date date, TimezoneType timezone, String format);

    T timestamp(Date date, String format);

    T timestamp(Date date);

    T timestamp();

    T timestampParenthesis();

    T vertical(String text);

    T vertical(Object value);

    T bold(String text);

    T bold(Object value);

    T italic(String text);

    T italic(Object value);

    T strikethrough(String text);

    T strikethrough(Object value);

    T underline(String text);

    T underline(Object value);

    T code(String text);

    T code(Object value);

    T code(Path filename);

    T preformatted(String text);

    T preformatted(Object value);

    T preformatted(String lang, String text);

    @SuppressWarnings({"UnusedReturnValue"})
    T preformatted(String lang, Object value);

    T preformatted(String lang, Path filename);

    T link(String text, String url);

    T tag(String... tags);

    T commercialAt(String... values);

    T text(String text);

    T text(String text, int repeat);

    T text(Object value);

    T line();

    T line(int repeat);

    T space();

    T space(int repeat);

    String toString();
}
