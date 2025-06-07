package com.watchplant.app.dtos.auth;

public class JwtTokenResponseDTO {
    private String jwtToken;

    public JwtTokenResponseDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
