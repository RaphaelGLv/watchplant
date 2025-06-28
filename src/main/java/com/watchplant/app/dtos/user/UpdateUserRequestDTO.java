package com.watchplant.app.dtos.user;

import java.util.Optional;

public class UpdateUserRequestDTO {
    private Optional<String> name;

    public UpdateUserRequestDTO(String name, String email) {
        this.name = Optional.ofNullable(name);
    }

    public Optional<String> getName() {
        return name;
    }
}
