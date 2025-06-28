package com.watchplant.app.entities.keys;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class PlantedPlantKey implements Serializable {

    private int perenualPlantId;
    private LocalDateTime plantationDate;

    @Embedded
    private PlantationKey plantationKey;

    public PlantedPlantKey() {
    }

    public PlantedPlantKey(int perenualPlantId, LocalDateTime plantationDate, PlantationKey plantationKey) {
        this.perenualPlantId = perenualPlantId;
        this.plantationDate = plantationDate;
        this.plantationKey = plantationKey;
    }

    public int getPerenualPlantId() {
        return perenualPlantId;
    }

    public LocalDateTime getPlantationDate() {
        return plantationDate;
    }

    public PlantationKey getPlantationKey() {
        return plantationKey;
    }

    public void setPerenualPlantId(int perenualPlantId) {
        this.perenualPlantId = perenualPlantId;
    }

    public void setPlantationDate(LocalDateTime plantationDate) {
        this.plantationDate = plantationDate;
    }

    public void setPlantationKey(PlantationKey plantationKey) {
        this.plantationKey = plantationKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlantedPlantKey that)) return false;
        return perenualPlantId == that.perenualPlantId &&
                Objects.equals(plantationDate, that.plantationDate) &&
                Objects.equals(plantationKey, that.plantationKey);
    }
}
