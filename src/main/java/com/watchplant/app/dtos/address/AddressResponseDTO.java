package com.watchplant.app.dtos.address;

import com.watchplant.app.entities.Address;

public class AddressResponseDTO {
    private String zipCode;
    private String street;
    private String number;
    private String neighborhood;

    public AddressResponseDTO(Address address) {
        if (address != null) {
            this.zipCode = address.getZipCode();
            this.street = address.getStreet();
            this.number = address.getNumber();
            this.neighborhood = address.getNeighborhood();
        }
    }

    // Empty constructor
    public AddressResponseDTO() {
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
