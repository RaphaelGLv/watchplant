/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import com.watchplant.app.dtos.address.CreateAddressRequestDto;
import com.watchplant.app.dtos.address.CreateAddressResponseDto;
import com.watchplant.app.dtos.address.GetAddressRequestDto;
import com.watchplant.app.dtos.address.GetAddressResponseDto;
import com.watchplant.app.dtos.address.UpdateAddressRequestDto;
import com.watchplant.app.dtos.address.UpdateAddressResponseDto;
import com.watchplant.app.entities.Address;
import com.watchplant.app.repositories.AddressRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class AddressService {

  private AddressRepository addressRepository;

  public GetAddressResponseDto getAddress(GetAddressRequestDto requestBody) {
    Address address = addressRepository
      .findById(requestBody.getId())
      .orElse(null);
    if (address == null) {
      throw new IllegalArgumentException("Address not found");
    }
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

    addressRepository.save(address);

    return new CreateAddressResponseDto(address);
  }

  public UpdateAddressResponseDto updateAddress(
    UpdateAddressRequestDto requestBody
  ) {
    Address address = addressRepository
      .findById(requestBody.getId())
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
