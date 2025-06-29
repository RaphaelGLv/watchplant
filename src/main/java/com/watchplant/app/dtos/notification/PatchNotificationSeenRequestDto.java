package com.watchplant.app.dtos.notification;

import com.watchplant.app.entities.keys.NotificationKey;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PatchNotificationSeenRequestDto(
        @NotNull(message = "A chave da notificação é um campo obrigatório.")
        NotificationKey key,
        LocalDateTime seenAt
) {}
