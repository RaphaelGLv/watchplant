package com.watchplant.app.entities.keys;

import com.watchplant.app.enums.NotificationTypeEnum;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class NotificationId implements Serializable {

    private UUID plantationId;
    private UUID plantedPlantId;

    @Enumerated(EnumType.STRING)
    private NotificationTypeEnum type;

    public NotificationId() {}

    public NotificationId(UUID plantationId, UUID plantedPlantId, NotificationTypeEnum type) {
        this.plantationId = plantationId;
        this.plantedPlantId = plantedPlantId;
        this.type = type;
    }

    // Getters, setters, equals, and hashCode obrigatórios

    public UUID getPlantationId() {
        return plantationId;
    }

    public UUID getPlantedPlantId() {
        return plantedPlantId;
    }

    public NotificationTypeEnum getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationId)) return false;
        NotificationId that = (NotificationId) o;
        return Objects.equals(plantationId, that.plantationId) &&
                Objects.equals(plantedPlantId, that.plantedPlantId) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantationId, plantedPlantId, type);
    }
}
