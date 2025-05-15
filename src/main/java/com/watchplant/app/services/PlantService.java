package com.watchplant.app.services;

import com.watchplant.app.dtos.plant.*;
import com.watchplant.app.entities.Plant;
import com.watchplant.app.repositories.PlantRepository;
import org.springframework.stereotype.Service;

/**
 * Service class for managing {@link Plant} entities.
 * Provides methods for creating, fetching, and updating plants.
 */
@Service
public class PlantService {

  private final PlantRepository plantRepository;

  /**
   * Constructor for {@link PlantService}.
   *
   * @param plantRepository The repository for {@link Plant} entities.
   */
  public PlantService(PlantRepository plantRepository) {
    this.plantRepository = plantRepository;
  }

  /**
   * Fetches a plant by its ID.
   *
   * @param requestBody The request containing the plant ID.
   * @return {@link GetPlantResponseDto} containing the plant details.
   * @throws IllegalArgumentException if the plant is not found.
   */
  public GetPlantResponseDto getPlant(GetPlantRequestDto requestBody) {
    Plant plant = plantRepository
      .findById(requestBody.getId())
      .orElseThrow(() -> new IllegalArgumentException("Plant not found"));
    return new GetPlantResponseDto(plant);
  }

  /**
   * Creates a new plant.
   *
   * @param requestBody The request containing the plant details.
   * @return {@link CreatePlantResponseDto} containing the created plant details.
   */
  public CreatePlantResponseDto createPlant(CreatePlantRequestDto requestBody) {
    Plant plant = new Plant(
      requestBody.getScientificName(),
      requestBody.getCommonName(),
      requestBody.getMaxFeetHeight(),
      requestBody.getCycle(),
      requestBody.getWateringFrequency(),
      requestBody.getSunlightIncidence(),
      requestBody.getPruningMonth(),
      requestBody.getPruningCountYearly(),
      requestBody.getSoilType(),
      requestBody.getCareLevel()
    );
    plantRepository.save(plant);
    return new CreatePlantResponseDto(plant);
  }

  /**
   * Updates an existing plant.
   *
   * @param requestBody The request containing the updated plant details.
   * @return {@link UpdatePlantResponseDto} containing the updated plant details.
   * @throws IllegalArgumentException if the plant is not found.
   */
  public UpdatePlantResponseDto updatePlant(UpdatePlantRequestDto requestBody) {
    Plant plant = plantRepository
      .findById(requestBody.getId())
      .orElseThrow(() -> new IllegalArgumentException("Plant not found"));

    requestBody.getScientificName().ifPresent(plant::setScientificName);
    requestBody.getCommonName().ifPresent(plant::setCommonName);
    requestBody.getMaxFeetHeight().ifPresent(plant::setMaxFeetHeight);
    requestBody.getCycle().ifPresent(plant::setCycle);
    requestBody.getWateringFrequency().ifPresent(plant::setWateringFrequency);
    requestBody.getSunlightIncidence().ifPresent(plant::setSunlightIncidence);
    requestBody.getPruningMonth().ifPresent(plant::setPruningMonth);
    requestBody.getPruningCountYearly().ifPresent(plant::setPruningCountYearly);
    requestBody.getSoilType().ifPresent(plant::setSoilType);
    requestBody.getCareLevel().ifPresent(plant::setCareLevel);

    plantRepository.save(plant);
    return new UpdatePlantResponseDto(plant);
  }
}
