/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import com.watchplant.app.dtos.address.GetAddressResponseDto;
import com.watchplant.app.dtos.address.UpdateAddressRequestDto;
import com.watchplant.app.dtos.address.UpdateAddressResponseDto;
import com.watchplant.app.entities.Address;
import com.watchplant.app.repositories.AddressRepository;
import com.watchplant.app.utils.UserContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class AddressService {

  private AddressRepository addressRepository;

  public GetAddressResponseDto getAddress() {
    Address address = addressRepository
      .findById(UserContext.getUserEmail())
      .orElse(null);
    if (address == null) {
      throw new IllegalArgumentException("Address not found");
    }
    return new GetAddressResponseDto(address);
  }

  /**
   * Updates an existing address
   * @param requestBody
   * @return {@link UpdateAddressResponseDto} containing the updated address
   * @throws IllegalArgumentException if the address is not found
   */
  public UpdateAddressResponseDto updateAddress(
    UpdateAddressRequestDto requestBody
  ) {
    Address address = addressRepository
      .findById(UserContext.getUserEmail())
      .orElse(null);
    if (address == null) {
      throw new IllegalArgumentException("Address not found");
    }
    String zipCode = requestBody.getZipCode().orElse(null);
    String street = requestBody.getStreet().orElse(null);
    String number = requestBody.getNumber().orElse(null);
    String neighborhood = requestBody.getNeighborhood().orElse(null);
    if (zipCode != null) {
      address.setZipCode(zipCode);
    }
    if (street != null) {
      address.setStreet(street);
    }
    if (number != null) {
      address.setNumber(number);
    }
    if (neighborhood != null) {
      address.setNeighborhood(neighborhood);
    }
    addressRepository.save(address);
    return new UpdateAddressResponseDto(address);
  }
}
