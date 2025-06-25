package com.watchplant.app.dtos.user;

import com.watchplant.app.entities.User;
import java.util.UUID;

public class UpdateUserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;

    public UpdateUserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
