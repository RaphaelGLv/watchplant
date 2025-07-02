package com.watchplant.app.dtos.user;

import com.watchplant.app.dtos.address.AddressResponseDTO;
import com.watchplant.app.entities.User;

import java.util.UUID;

public class GetUserResponseDTO {
    private String name;
    private String phone;
    private String email;
    private AddressResponseDTO address;

    public GetUserResponseDTO(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.address = user.getAddress() != null ? new AddressResponseDTO(user.getAddress()) : null;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }
}
