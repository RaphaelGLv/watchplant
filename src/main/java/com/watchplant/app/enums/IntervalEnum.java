package com.watchplant.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum IntervalEnum {
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly");

    private final String value;

    IntervalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static IntervalEnum fromValue(String value) {
        try {
            return value != null ? IntervalEnum.valueOf(value.toUpperCase()) : null;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid value for IntervalEnum: " + value);
        }
    }
}
