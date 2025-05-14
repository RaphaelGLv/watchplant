/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import org.springframework.stereotype.Service;

import com.watchplant.app.dtos.address.CreateAddressRequestDto;
import com.watchplant.app.dtos.address.CreateAddressResponseDto;
import com.watchplant.app.dtos.address.GetAddressRequestDto;
import com.watchplant.app.dtos.address.GetAddressResponseDto;
import com.watchplant.app.dtos.address.UpdateAddressRequestDto;
import com.watchplant.app.dtos.address.UpdateAddressResponseDto;
import com.watchplant.app.entities.Address;

/**
 *
 * @author pedro
 */
@Service
public class AddressService {

  public GetAddressResponseDto getAddress(GetAddressRequestDto requestBody) {
    // TODO Find the address by id (not implemented in this example)
    String zipCode = "12345-678";
    String street = "Main St";
    String number = "123";
    String neighborhood = "Downtown";

    Address address = new Address(zipCode, street, number, neighborhood);
    return new GetAddressResponseDto(address);
  }

  public CreateAddressResponseDto createAddress(
    CreateAddressRequestDto requestBody
  ) {
    Address address = new Address(
      requestBody.getZipCode(),
      requestBody.getStreet(),
      requestBody.getNumber(),
      requestBody.getNeighborhood()
    );
    // TODO Save the address to the database (not implemented in this example)

    return new CreateAddressResponseDto(address);
  }

  public UpdateAddressResponseDto updateAddress(
    UpdateAddressRequestDto requestBody
  ) {
    // TODO Find the address by id and update it (not implemented in this example)
    String zipCode = requestBody.getZipCode().orElse(null);
    String street = requestBody.getStreet().orElse(null);
    String number = requestBody.getNumber().orElse(null);
    String neighborhood = requestBody.getNeighborhood().orElse(null);
    if (zipCode != null) {
      // Update the zip code
    }
    if (street != null) {
      // Update the street
    }
    if (number != null) {
      // Update the number
    }
    if (neighborhood != null) {
      // Update the neighborhood
    }
    // TODO Save the updated address to the database (not implemented in this example)
    Address address = new Address(zipCode, street, number, neighborhood);
    return new UpdateAddressResponseDto(address);
  }
}
