package org.bot4j.telegram.model.enums;

@SuppressWarnings({"all"})
// @formatter:off
public enum TelegramIconMode {
    ERROR("\uD83D\uDD34"),
    SUCCESS("\uD83D\uDFE2"),
    WARN("\uD83D\uDFE1"),
    TRACE("\uD83D\uDCDC"),
    INFO("\uD83D\uDD35"),
    SOS("\uD83C\uDD98"),
    MESSAGE("\uD83D\uDCAC"),
    TS_1("\uD83C\uDFAF"),
    TS_2("\uD83D\uDDD3"),
    TS_3("\uD83D\uDCCD"),
    NOTIFY("\uD83D\uDCE3"),
    TADA("\uD83C\uDF89"),
    SETTING("\uD83D\uDD27"),
    ROCKET("\uD83D\uDE80"),
    KEY("\uD83D\uDD11"),
    BOT("\uD83E\uDD16"),
    USER("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB"),
    BUG_1("\uD83D\uDC1E"),
    BUG_2("\uD83D\uDC7E"),
    BUG_3("\uD83E\uDEB2"),
    BUG_4("\uD83D\uDC1B"),
    RIGHT_ARROW_1("\uD83D\uDC49"),
    LEFT_ARROW_1("\uD83D\uDC48");

    private final String icon;

    TelegramIconMode(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
// @formatter:on
