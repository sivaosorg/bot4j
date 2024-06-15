package org.bot4j.viber.model.enums;

public enum ViberTextMode {
    TEXT("text"),
    PICTURE("picture"),
    VIDEO("video"),
    FILE("file"),
    LOCATION("location"),
    CONTACT("contact"),
    STICKER("sticker"),
    CAROUSEL("carousel"),
    CONTENT("content"),
    URL("url");

    ViberTextMode(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
