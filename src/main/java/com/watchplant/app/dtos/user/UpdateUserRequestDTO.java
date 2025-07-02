package com.watchplant.app.dtos.user;

import com.watchplant.app.dtos.address.AddressRequestDTO;
import jakarta.validation.constraints.Pattern;

import java.util.Optional;

public class UpdateUserRequestDTO {
    private String name;

    @Pattern(regexp = "^([0-9]{6,7})[^0-9]*([0-9]{4})$", message = "O formato do número de telefone é incorreto")
    private String phone;
    
    private AddressRequestDTO address;

    public UpdateUserRequestDTO() {
    }

    public UpdateUserRequestDTO(String name, String phone, AddressRequestDTO address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name).filter(s -> !s.trim().isEmpty());
    }

    public Optional<String> getPhone() {
        return Optional.ofNullable(phone).filter(s -> !s.trim().isEmpty());
    }
    
    public Optional<AddressRequestDTO> getAddress() {
        return Optional.ofNullable(address);
    }
}
