package com.watchplant.app.utils;

import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.enums.WateringFrequencyEnum;
import com.watchplant.app.enums.WateringScoreThresholdEnum;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WateringNeedValidator {
    public static boolean isWateringNeeded(PlantedPlant plantedPlant) {
        if (plantedPlant.getWateringFrequency() == WateringFrequencyEnum.NONE)
            return false;

        int needOfWateringScore = 0;

        needOfWateringScore += plantedPlant.getWateringFrequency().getNeedOfWaterLevel();
        needOfWateringScore += plantedPlant.getSoilType().getNeedOfWaterLevel();
        needOfWateringScore += plantedPlant.getSunlightIncidence().getNeedOfWaterLevel();

        if (needOfWateringScore > WateringScoreThresholdEnum.TWICE_A_DAY.getScoreThreshold())
            return true;


        for (WateringScoreThresholdEnum wateringScoreThresholdEnum : WateringScoreThresholdEnum.values()) {
            if (needOfWateringScore >= wateringScoreThresholdEnum.getScoreThreshold())
                continue;

            long hoursWithoutWatering = ChronoUnit.HOURS.between(plantedPlant.getLastWateringDate(), LocalDateTime.now());

            if (hoursWithoutWatering >= wateringScoreThresholdEnum.getWateringInterval())
                return true;
        }

        return false;
    }
}
