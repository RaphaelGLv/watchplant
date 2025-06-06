package com.watchplant.app.utils;

import com.watchplant.app.services.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserContext {
    private static final ThreadLocal<UUID> userIdHolder = new ThreadLocal<>();

    public static void setUserId(UUID userId) {
        userIdHolder.set(userId);
    }

    public static UUID getUserId() {
        UUID userId = userIdHolder.get();

        if (userId == null) throw new ApplicationException("Usuário não autenticado", HttpStatus.UNAUTHORIZED);

        return userId;
    }

    public static void clear() {
        userIdHolder.remove();
    }
}
