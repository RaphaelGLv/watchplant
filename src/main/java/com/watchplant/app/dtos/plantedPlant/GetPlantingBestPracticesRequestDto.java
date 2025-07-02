package com.watchplant.app.dtos.plantedPlant;

import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import com.watchplant.app.enums.WateringFrequencyEnum;
import jakarta.validation.constraints.Min;

public record GetPlantingBestPracticesRequestDto(
        @Min(value = 1, message = "O id da planta deve ser maior ou igual a 1")
        Integer plantId,
        WateringFrequencyEnum wateringFrequency,
        SunlightIncidenceEnum sunlightIncidence,
        SoilTypeEnum soilType
) {
}
