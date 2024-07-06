package org.bot4j.telegram.model.enums;

@SuppressWarnings({"all"})
public enum TelegramIconMode {
    ERROR("\uD83D\uDD34"),
    SUCCESS("\uD83D\uDFE2"),
    WARN("\uD83D\uDFE1"),
    TRACE("\uD83D\uDCDC"),
    INFO("\uD83D\uDD35");

    private final String icon;

    TelegramIconMode(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
