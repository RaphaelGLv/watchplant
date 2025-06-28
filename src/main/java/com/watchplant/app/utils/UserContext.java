package com.watchplant.app.utils;

import com.watchplant.app.services.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

import java.lang.String;

public class UserContext {
    private static final ThreadLocal<String> userEmailHolder = new ThreadLocal<>();

    public static void setUserId(String userEmail) {
        userEmailHolder.set(userEmail);
    }

    public static String getUserEmail() {
        String userEmail = userEmailHolder.get();

        if (userEmail == null) throw new ApplicationException("Usuário não autenticado", HttpStatus.UNAUTHORIZED);

        return userEmail;
    }

    public static void clear() {
        userEmailHolder.remove();
    }
}
