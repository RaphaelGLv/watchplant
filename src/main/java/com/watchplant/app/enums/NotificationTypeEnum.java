package com.watchplant.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum NotificationTypeEnum {
    WATERING("watering"),
    HARVESTING("harvesting"),;

    private final String value;

    NotificationTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static NotificationTypeEnum fromString(String value) {
        try {
            return NotificationTypeEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid NotificationTypeEnum: " + value);
        }
    }
}
