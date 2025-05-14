package com.watchplant.app.services;

import com.watchplant.app.dtos.plantation.*;
import com.watchplant.app.entities.Plantation;
import com.watchplant.app.repositories.PlantationRepository;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Plantation entities.
 * Provides methods for CRUD operations on plantations.
 */
@Service
public class PlantationService {

  private final PlantationRepository plantationRepository;

  /**
   * Constructor for PlantationService.
   *
   * @param plantationRepository The repository for Plantation entities.
   */
  public PlantationService(PlantationRepository plantationRepository) {
    this.plantationRepository = plantationRepository;
  }

  /**
   * Fetches a plantation by ID.
   *
   * @param requestBody The request containing the plantation ID.
   * @return {@link GetPlantationResponseDto} containing the plantation details.
   * @throws IllegalArgumentException if the plantation is not found.
   */
  public GetPlantationResponseDto getPlantation(GetPlantationRequestDto requestBody) {
    Plantation plantation = plantationRepository
      .findById(requestBody.getId())
      .orElseThrow(() -> new IllegalArgumentException("Plantation not found"));
    return new GetPlantationResponseDto(plantation);
  }

  /**
   * Creates a new plantation.
   *
   * @param requestBody The request containing the plantation details.
   * @return {@link CreatePlantationResponseDto} containing the created plantation details.
   */
  public CreatePlantationResponseDto createPlantation(CreatePlantationRequestDto requestBody) {
    Plantation plantation = new Plantation(
      requestBody.getName(),
      requestBody.getSizeArea(),
      requestBody.getSoilType(),
      requestBody.getSunlightIncidence()
    );
    plantationRepository.save(plantation);
    return new CreatePlantationResponseDto(plantation);
  }

  /**
   * Updates an existing plantation.
   *
   * @param requestBody The request containing the updated plantation details.
   * @return {@link UpdatePlantationResponseDto} containing the updated plantation details.
   * @throws IllegalArgumentException if the plantation is not found.
   */
  public UpdatePlantationResponseDto updatePlantation(UpdatePlantationRequestDto requestBody) {
    Plantation plantation = plantationRepository
      .findById(requestBody.getId())
      .orElseThrow(() -> new IllegalArgumentException("Plantation not found"));

    requestBody.getName().ifPresent(plantation::setName);
    requestBody.getSizeArea().ifPresent(plantation::setSizeArea);
    requestBody.getSoilType().ifPresent(plantation::setSoilType);
    requestBody.getSunlightIncidence().ifPresent(plantation::setSunlightIncidence);

    plantationRepository.save(plantation);
    return new UpdatePlantationResponseDto(plantation);
  }
}
