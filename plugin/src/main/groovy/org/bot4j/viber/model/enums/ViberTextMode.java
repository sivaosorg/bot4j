package org.bot4j.viber.model.enums;

import java.util.Arrays;
import java.util.Optional;

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

    /**
     * Attempts to find a ViberTextMode enum constant that matches the provided name.
     *
     * @param name the value to match against the enum constants' values.
     * @return an Optional containing the matching ViberTextMode constant if found, otherwise an empty Optional.
     * <p>
     * This method uses a stream to iterate over the available ViberTextMode constants and returns the first match found
     * where the enum's value equals the provided name. If no match is found, an empty Optional is returned.
     */
    public static Optional<ViberTextMode> tryValueOf(String name) {
        return Arrays.stream(ViberTextMode.values()).filter(e -> e.getValue().equals(name)).findFirst();
    }
}
