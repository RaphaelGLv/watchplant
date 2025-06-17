package com.watchplant.app.dtos.user;

import java.util.Optional;

public class UpdateUserRequestDTO {
    private Optional<String> name;
    private Optional<String> email;

    public UpdateUserRequestDTO(String name, String email) {
        this.name = Optional.ofNullable(name);
        this.email = Optional.ofNullable(email);
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }
}
