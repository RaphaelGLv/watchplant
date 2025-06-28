package com.watchplant.app.dtos.user;

import com.watchplant.app.entities.User;
import java.util.UUID;

public class UpdateUserResponseDTO {
    private String name;
    private String email;
    private String phone;

    public UpdateUserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
