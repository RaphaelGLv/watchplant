package com.watchplant.app.handlers;

import com.watchplant.app.services.JwtService;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.NonMvcResponseUtil;
import com.watchplant.app.utils.UserContext;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String jwtToken = null;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwtToken = authHeader.substring("Bearer ".length());

                UUID userId = jwtService.extractUserId(jwtToken);

                UserContext.setUserId(userId);
            }

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            NonMvcResponseUtil.createResponse(response, HttpStatus.UNAUTHORIZED, "Token expirado! Faça login novamente.");
        } catch (Exception e) {
            NonMvcResponseUtil.createResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, "Token inválido.");
        }
    }

}