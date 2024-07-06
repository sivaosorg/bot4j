package org.bot4j.telegram.message;

import org.alpha4j.common.Map4j;
import org.bot4j.telegram.model.enums.TelegramIconMode;
import org.unify4j.common.*;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.c.Method;
import org.unify4j.model.enums.TimezoneType;
import org.unify4j.model.response.HttpResponse;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class HttpBuilder extends MarkdownBuilder {
    protected final Map4j<String, Object> placeholders;
    protected Date start;
    protected Date end;
    protected String timezone;

    public HttpBuilder() {
        super();
        this.placeholders = new Map4j<>();
    }

    protected static class Index {
        public static final String METHOD_INDEX = "method_index";
        public static final String BASE_URL_INDEX = "base_url_index";
        public static final String PATH_INDEX = "path_index";
        public static final String QUERY_INDEX = "query_index";
        public static final String REQUEST_INDEX = "request_index";
        public static final String RESPONSE_INDEX = "response_index";
        public static final String HEADER_INDEX = "header_index";
        public static final String STATUS_INDEX = "code_index";
        public static final String API_DESC_INDEX = "api_desc_index";
    }

    public HttpBuilder apiDesc(String desc) {
        this.placeholders.put(Index.API_DESC_INDEX, desc);
        return this;
    }

    public HttpBuilder method(String method) {
        this.placeholders.put(Index.METHOD_INDEX, method);
        return this;
    }

    public HttpBuilder method(Method method) {
        if (method == null) {
            return this;
        }
        return this.method(method.getName());
    }

    public HttpBuilder baseUrl(String url) {
        this.placeholders.put(Index.BASE_URL_INDEX, url);
        return this;
    }

    public HttpBuilder path(String url) {
        this.placeholders.put(Index.PATH_INDEX, url);
        return this;
    }

    public HttpBuilder query(Map<String, ?> queries) {
        if (Collection4j.isEmptyMap(queries)) {
            return this;
        }
        this.placeholders.put(Index.QUERY_INDEX, queries);
        return this;
    }

    public HttpBuilder request(Map<String, ?> request) {
        if (Collection4j.isEmptyMap(request)) {
            return this;
        }
        this.placeholders.put(Index.REQUEST_INDEX, request);
        return this;
    }

    public HttpBuilder response(Map<String, ?> response) {
        if (Collection4j.isEmptyMap(response)) {
            return this;
        }
        this.placeholders.put(Index.RESPONSE_INDEX, response);
        return this;
    }

    public HttpBuilder header(Map<String, ?> headers) {
        if (Collection4j.isEmptyMap(headers)) {
            return this;
        }
        this.placeholders.put(Index.HEADER_INDEX, headers);
        return this;
    }

    public HttpBuilder status(int httpStatus) {
        this.placeholders.put(Index.STATUS_INDEX, httpStatus);
        return this;
    }

    public HttpBuilder status(HttpResponse response) {
        if (response == null) {
            return this;
        }
        return this.status(response.getCode());
    }

    public HttpBuilder startTime() {
        this.start = new Date();
        return this;
    }

    public HttpBuilder startTime(Date date) {
        this.start = date;
        return this;
    }

    public HttpBuilder endTime() {
        this.end = new Date();
        return this;
    }

    public HttpBuilder endTime(Date date) {
        this.end = date;
        return this;
    }

    public HttpBuilder timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public HttpBuilder timezone(TimezoneType timezone) {
        return this.timezone(timezone.getTimeZoneId());
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public String toString() {
        if (this.placeholders.containsKey(Index.STATUS_INDEX)) {
            int status = (int) this.placeholders.get(Index.STATUS_INDEX);
            if (HttpStatusBuilder.isSuccess(status)) {
                this.icon(TelegramIconMode.SUCCESS)
                        .bold(status)
                        .timestampParenthesis()
                        .line();
            } else {
                this.icon(TelegramIconMode.ERROR).bold(status)
                        .timestampParenthesis()
                        .line();
            }
        } else {
            this.icon(TelegramIconMode.TS_3).timestamp().line();
        }
        if (this.placeholders.containsKey(Index.API_DESC_INDEX)) {
            this.bold("API").italic((String) this.placeholders.get(Index.API_DESC_INDEX)).line();
        }
        if (this.placeholders.containsKey(Index.METHOD_INDEX)) {
            this.bold((String) this.placeholders.get(Index.METHOD_INDEX));
        }
        if (this.placeholders.containsKey(Index.BASE_URL_INDEX)) {
            String url;
            if (this.placeholders.containsKey(Index.PATH_INDEX)) {
                url = String.format("%s%s",
                        this.placeholders.get(Index.BASE_URL_INDEX),
                        this.placeholders.get(Index.PATH_INDEX));
            } else {
                url = (String) this.placeholders.get(Index.BASE_URL_INDEX);
            }
            if (this.placeholders.containsKey(Index.QUERY_INDEX)) {
                Map<String, Object> queries = (Map<String, Object>) Json4j.toMapFrom(this.placeholders.get(Index.QUERY_INDEX));
                try {
                    url = Request4j.appendQueryParams(url, queries);
                } catch (UnsupportedEncodingException ignored) {

                }
            }
            this.code(String4j.trimWhitespace(url));
        }
        this.line(2);
        if (Object4j.allNotNull(this.start)) {
            if (String4j.isEmpty(this.timezone)) {
                this.bold("RFT:").timestamp(this.start).line();
            } else {
                this.bold("RFT:").timestamp(this.start, TimeZone.getTimeZone(this.timezone)).line();
            }
        }
        if (Object4j.allNotNull(this.end)) {
            if (String4j.isEmpty(this.timezone)) {
                this.bold("RT:").timestamp(this.end).line();
            } else {
                this.bold("RT:").timestamp(this.end, TimeZone.getTimeZone(this.timezone)).line();
            }
        }
        if (Object4j.allNotNull(this.start, this.end)) {
            this.icon(TelegramIconMode.RIGHT_ARROW_1)
                    .bold("Time:")
                    .code(Time4j.sinceSmallRecently(this.end, this.start))
                    .line();
        }
        if (this.placeholders.containsKey(Index.HEADER_INDEX)) {
            this.bold("H:").line();
            Map<String, Object> headers = (Map<String, Object>) Json4j.toMapFrom(this.placeholders.get(Index.HEADER_INDEX));
            if (Collection4j.isNotEmptyMap(headers)) {
                headers.forEach((key, value) -> {
                    this.code(key).text(":").code(value.toString()).line();
                });
            }
        }
        if (this.placeholders.containsKey(Index.REQUEST_INDEX)) {
            Map<String, Object> request = (Map<String, Object>) Json4j.toMapFrom(this.placeholders.get(Index.REQUEST_INDEX));
            this.bold("Req:").preformatted("json", request);
        }
        if (this.placeholders.containsKey(Index.RESPONSE_INDEX)) {
            Map<String, Object> request = (Map<String, Object>) Json4j.toMapFrom(this.placeholders.get(Index.RESPONSE_INDEX));
            this.bold("Resp:").preformatted("json", request);
        }
        return super.toString();
    }
}
