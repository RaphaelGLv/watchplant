package com.watchplant.app.utils;

import com.watchplant.app.entities.PlantedPlant;

import java.time.Month;
import java.util.Calendar;
import java.util.List;

public class HarvestNeedValidator {
    public static boolean isHarvestNeeded(PlantedPlant plantedPlant) {
        Month actualMonth = Month.of(Calendar.getInstance().get(Calendar.MONTH)+1);
        List<Month> puningMonthList = plantedPlant.getPruningMonth();

        for (Month month : puningMonthList) {
            if (actualMonth.equals(month)) {
                return true;
            }
        }

        return false;
    }
}
