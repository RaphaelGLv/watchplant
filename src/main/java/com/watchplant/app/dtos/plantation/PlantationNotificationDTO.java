package com.watchplant.app.dtos.plantation;

import java.util.UUID;

public record PlantationNotificationDTO(
        UUID id,
        String name
) {
}
