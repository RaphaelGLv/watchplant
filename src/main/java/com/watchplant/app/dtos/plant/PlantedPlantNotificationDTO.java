package com.watchplant.app.dtos.plant;

import java.util.UUID;

public record PlantedPlantNotificationDTO(
        UUID id,
        String commonName
) {
}
