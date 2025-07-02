package com.watchplant.app.dtos.plantedPlant;

import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import com.watchplant.app.enums.WateringFrequencyEnum;
import com.watchplant.app.utils.PlantingPracticeEvaluation;

import java.util.List;

public record GetPlantingBestPracticesResponseDto(
        Integer plantId,
        PlantingPracticeEvaluation<WateringFrequencyEnum> idealWateringFrequency,
        PlantingPracticeEvaluation<SunlightIncidenceEnum> idealSunlightIncidenceList,
        PlantingPracticeEvaluation<SoilTypeEnum> idealSoilTypeList
) {
}
