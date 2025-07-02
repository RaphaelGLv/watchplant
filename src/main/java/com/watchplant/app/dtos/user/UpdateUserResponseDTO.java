package com.watchplant.app.dtos.user;

import com.watchplant.app.dtos.address.AddressResponseDTO;
import com.watchplant.app.entities.User;

public class UpdateUserResponseDTO {
    private String name;
    private String email;
    private String phone;
    private AddressResponseDTO address;

    public UpdateUserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress() != null ? new AddressResponseDTO(user.getAddress()) : null;
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
    
    public AddressResponseDTO getAddress() {
        return address;
    }
}
