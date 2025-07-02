package com.watchplant.app.dtos.plantedPlant;

import java.util.UUID;

public record PlantedPlantNotificationDTO(
        UUID id,
        String commonName
) {
}
