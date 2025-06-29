package com.watchplant.app.handlers;

import com.watchplant.app.services.JwtService;
import com.watchplant.app.utils.NonMvcResponseUtil;
import com.watchplant.app.utils.UserContext;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final List<String> excludedPaths = List.of("/auth/login", "/auth/signup");

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return excludedPaths.stream().anyMatch(path::startsWith);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        String authHeader = request.getHeader("Authorization");
        String jwtToken;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwtToken = authHeader.substring("Bearer ".length());

                String userEmail = jwtService.extractUserId(jwtToken);

                UserContext.setUserId(userEmail);
            }

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            NonMvcResponseUtil.createResponse(response, HttpStatus.UNAUTHORIZED, "Token expirado! Faça login novamente.");
        } catch (MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            NonMvcResponseUtil.createResponse(response, HttpStatus.UNAUTHORIZED, "Token inválido.");
        } catch (Exception e) {
            NonMvcResponseUtil.createResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}