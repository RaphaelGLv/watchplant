package com.watchplant.app.dtos.plant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.watchplant.app.deserializers.MonthDeserializer;
import com.watchplant.app.enums.*;
import com.watchplant.app.utils.Dimensions;
import com.watchplant.app.utils.PruningCount;

import java.time.Month;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PerenualPlantDetailsDto {
    private final Integer id;
    private final String commonName;
    private final List<String> scientificNames;
    private final List<String> otherNames;
    private final List<Dimensions> dimensions;
    // TODO: Create enum to describe cycle
    private final PlantCycleEnum cycle;
    private final List<Month> pruningMonth;
    private final List<PruningCount> pruningCount;
    private final CareLevelEnum careLevel;
    private final WateringFrequencyEnum idealWateringFrequency;
    private final List<SunlightIncidenceEnum> idealSunlightIncidences;
    private final List<SoilTypeEnum> idealSoilTypes;

    public PerenualPlantDetailsDto(
            @JsonProperty("id")
            Integer id,
            @JsonProperty("common_name")
            String commonName,
            @JsonProperty("scientific_name")
            List<String> scientificNames,
            @JsonProperty("other_name")
            List<String> otherNames,
            @JsonProperty("dimensions")
            List<Dimensions> dimensions,
            @JsonProperty("cycle")
            PlantCycleEnum cycle,
            @JsonDeserialize(contentUsing = MonthDeserializer.class)
            @JsonProperty("pruning_month")
            List<Month> pruningMonth,
            @JsonProperty("pruning_count")
            List<PruningCount> pruningCount,
            @JsonProperty("care_level")
            CareLevelEnum careLevel,
            @JsonProperty("watering")
            WateringFrequencyEnum idealWateringFrequency,
            @JsonProperty("sunlight")
            List<SunlightIncidenceEnum> idealSunlightIncidences,
            @JsonProperty("soil")
            List<SoilTypeEnum> idealSoilTypes
    ) {
        this.id = id;
        this.commonName = commonName;
        this.scientificNames = scientificNames;
        this.otherNames = otherNames;
        this.dimensions = dimensions;
        this.cycle = cycle;
        this.pruningMonth = pruningMonth;
        this.pruningCount = pruningCount;
        this.careLevel = careLevel;
        this.idealWateringFrequency = idealWateringFrequency;
        this.idealSunlightIncidences = idealSunlightIncidences;
        this.idealSoilTypes = idealSoilTypes;
    }

    public Integer getId() {
        return id;
    }

    public String getCommonName() {
        return commonName;
    }

    public List<String> getScientificNames() {
        return scientificNames;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public List<Dimensions> getDimensions() {
        return dimensions;
    }

    public PlantCycleEnum getCycle() {
        return cycle;
    }

    public WateringFrequencyEnum getIdealWateringFrequency() {
        return idealWateringFrequency;
    }

    public List<SunlightIncidenceEnum> getIdealSunlightIncidences() {
        return idealSunlightIncidences;
    }

    public List<SoilTypeEnum> getIdealSoilTypes() {
        return idealSoilTypes;
    }

    public List<Month> getPruningMonth() {
        return pruningMonth;
    }

    public List<PruningCount> getPruningCount() {
        return pruningCount;
    }

    public CareLevelEnum getCareLevel() {
        return careLevel;
    }
}
