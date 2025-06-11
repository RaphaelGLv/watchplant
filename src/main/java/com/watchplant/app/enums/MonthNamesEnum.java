package com.watchplant.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MonthNamesEnum {
    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");

    private final String name;

    MonthNamesEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonCreator
    public static MonthNamesEnum fromString(String name) {
        try {
            return MonthNamesEnum.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid month name: " + name);
        }
    }
}
