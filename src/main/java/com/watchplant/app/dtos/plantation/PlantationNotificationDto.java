package com.watchplant.app.dtos.plantation;

import java.util.UUID;

public record PlantationNotificationDto(
        UUID id,
        String name
) {
}
