package com.watchplant.app.enums;

public enum WateringScoreThresholdEnum {
    MONTHLY(
            Math.pow(NeedOfWaterEnum.LOW.getLevel(), 2) * 3,
            30 * 24
    ),
    TWICE_A_MONTH(
            Math.pow(NeedOfWaterEnum.LOW.getLevel() * 3, 2),
            15 * 24
    ),
    WEEKLY(
            Math.pow(NeedOfWaterEnum.MEDIUM.getLevel(), 2) * 3,
            7 * 24
    ),
    TWICE_A_WEEK(
            Math.pow(NeedOfWaterEnum.MEDIUM.getLevel() * 3, 2),
            (long) (3.5 * 24)
    ),
    DAILY(
            Math.pow(NeedOfWaterEnum.HIGH.getLevel(), 2) * 3,
            24
    ),
    TWICE_A_DAY(
            Math.pow(NeedOfWaterEnum.HIGH.getLevel() * 3, 2),
            12
    );

    private final double scoreThreshold;
    private final double wateringInterval;

    WateringScoreThresholdEnum(double scoreThreshold, double wateringInterval) {
        this.scoreThreshold = scoreThreshold;
        this.wateringInterval = wateringInterval;
    }

    public double getScoreThreshold() {
        return scoreThreshold;
    }

    public double getWateringInterval() {
        return wateringInterval;
    }
}
