package com.watchplant.app.dtos.user;

import com.watchplant.app.entities.User;

public class UpdateUserResponseDTO {
    private String name;
    private String email;

    public UpdateUserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
