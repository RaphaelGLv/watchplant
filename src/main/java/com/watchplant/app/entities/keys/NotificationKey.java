package com.watchplant.app.entities.keys;

import com.watchplant.app.enums.NotificationTypeEnum;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NotificationKey implements Serializable {

    @Embedded
    private PlantedPlantKey plantedPlantKey;

    @Enumerated(EnumType.STRING)
    private NotificationTypeEnum type;

    public NotificationKey() {}

    public NotificationKey(PlantedPlantKey plantedPlantKey, NotificationTypeEnum type) {
        this.plantedPlantKey = plantedPlantKey;
        this.type = type;
    }

    public PlantedPlantKey getPlantedPlantKey() {
        return plantedPlantKey;
    }

    public void setPlantedPlantKey(PlantedPlantKey plantedPlantKey) {
        this.plantedPlantKey = plantedPlantKey;
    }

    public NotificationTypeEnum getType() {
        return type;
    }

    public void setType(NotificationTypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationKey that)) return false;
        return Objects.equals(plantedPlantKey, that.plantedPlantKey) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantedPlantKey, type);
    }
}
