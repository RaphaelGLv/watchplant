package com.watchplant.app.dtos.notification;

import java.util.List;

public record GetAllNotificationsResponseDTO(
        List<GetNotificationResponseDto> notifications
) {}
