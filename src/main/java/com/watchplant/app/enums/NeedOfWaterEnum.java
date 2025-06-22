package com.watchplant.app.enums;

public enum NeedOfWaterEnum {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int level;

    NeedOfWaterEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
