package com.watchplant.app.dtos.notification;

import java.util.UUID;

public record GetAllNotificationsRequestDTO(
        UUID userId
) {
}
