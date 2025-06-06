package com.watchplant.app.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class NonMvcResponseUtil {

    public static void createResponse(
        HttpServletResponse response,
        HttpStatus statusCode,
        String message
    ) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.setStatus(statusCode.value());
        response.getWriter().write(String.format("{\"message\": \"%s\"}", message));
    }
}
