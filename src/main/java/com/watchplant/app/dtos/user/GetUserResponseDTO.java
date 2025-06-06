package com.watchplant.app.dtos.user;

import com.watchplant.app.entities.User;

import java.util.UUID;

public class GetUserResponseDTO {
    private UUID id;
    private String name;
    private String phone;

    public GetUserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
