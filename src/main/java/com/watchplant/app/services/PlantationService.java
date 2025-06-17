package com.watchplant.app.services;

import com.watchplant.app.dtos.plantation.*;
import com.watchplant.app.entities.Plantation;
import com.watchplant.app.repositories.PlantationRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.UserContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    UUID userId = UserContext.getUserId();

    boolean isPlantationExists = this.existsPlantationByOwnerIdAndName(userId, requestBody.getName());

    if (isPlantationExists) throw new ApplicationException("Você já possui uma plantação com esse nome!", HttpStatus.CONFLICT);

    Plantation plantation = new Plantation(
      userId,
      requestBody.getName(),
      requestBody.getSizeArea(),
      requestBody.getSoilType(),
      requestBody.getSunlightIncidence()
    );
    plantationRepository.save(plantation);
    return new CreatePlantationResponseDto(plantation);
  }

  private boolean existsPlantationByOwnerIdAndName(UUID ownerId, String plantationName) {
    return plantationRepository.existsByOwnerIdAndName(ownerId, plantationName);
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

  /**
   * Deletes a plantation by ID.
   *
   * @param id The ID of the plantation to delete.
   * @throws IllegalArgumentException if the plantation is not found.
   */
  public void deletePlantation(UUID id) {
    if (!plantationRepository.existsById(id)) {
      throw new IllegalArgumentException("Plantation not found");
    }
    plantationRepository.deleteById(id);
  }

  /**
   * Lists all plantations for the current user.
   *
   * @return A list of {@link GetPlantationResponseDto} containing the plantations of the current user.
   */
  public List<GetPlantationResponseDto> listPlantationsByCurrentUser() {
    UUID userId = UserContext.getUserId();
    return plantationRepository.findAll().stream()
      .filter(plantation -> userId.equals(plantation.getOwnerId()))
      .map(GetPlantationResponseDto::new)
      .collect(Collectors.toList());
  }
}
