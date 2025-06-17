package com.watchplant.app.services;

import com.watchplant.app.dtos.plant.*;
import com.watchplant.app.entities.Plantation;
import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import com.watchplant.app.enums.WateringFrequencyEnum;
import com.watchplant.app.repositories.PlantedPlantRepository;
import com.watchplant.app.repositories.PlantationRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.Dimensions;
import com.watchplant.app.utils.PlantingPracticeEvaluation;
import com.watchplant.app.utils.PruningCount;
import com.watchplant.app.utils.UserContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Service class for managing {@link PlantedPlant} entities.
 * Provides methods for creating, fetching, and updating plants.
 */
@Service
public class PlantService {

  private final PlantedPlantRepository plantedPlantRepository;
  private final PlantationRepository plantationRepository;
  private final PerenualService perenualService;

  /**
   * Constructor for {@link PlantService}.
   *
   * @param plantedPlantRepository The repository for {@link PlantedPlant} entities.
   */
  public PlantService(PlantedPlantRepository plantedPlantRepository, PlantationRepository plantationRepository, PerenualService perenualService) {
    this.plantedPlantRepository = plantedPlantRepository;
      this.plantationRepository = plantationRepository;
      this.perenualService = perenualService;
  }

  /**
   * Fetches a plant by its ID.
   *
   * @param requestBody The request containing the plant ID.
   * @return {@link GetPlantResponseDto} containing the plant details.
   * @throws IllegalArgumentException if the plant is not found.
   */
  public GetPlantResponseDto getPlant(GetPlantRequestDto requestBody) {
    PlantedPlant plantedPlant = plantedPlantRepository
      .findById(requestBody.getId())
      .orElseThrow(() -> new IllegalArgumentException("Plant not found"));
    return new GetPlantResponseDto(plantedPlant);
  }

  /**
   * Creates a new plant.
   *
   * @param requestBody The request containing the plant details.
   * @return {@link CreatePlantResponseDto} containing the created plant details.
   */
  public CreatePlantResponseDto createPlant(CreatePlantRequestDto requestBody) {
    PerenualPlantDetailsDto plantDetails = perenualService.getPlantDetails(requestBody.getPlantId());
    List<Dimensions> plantDimensions = plantDetails.getDimensions();

    UUID userId = UserContext.getUserId();
    Optional<Plantation> plantation = plantationRepository.findByIdAndOwnerId(requestBody.getPlantationId(), userId);

    if (plantation.isEmpty())
      throw new ApplicationException("Plantação não encontrada", HttpStatus.NOT_FOUND);

    PlantedPlant newPlantedPlant = new PlantedPlant(
            plantDetails.getScientificNames().stream().findFirst().orElse(null),
            plantDetails.getCommonName(),
            Objects.requireNonNull(plantDimensions.stream().findFirst().orElse(null)).maxValue(),
            plantDetails.getCycle(),
            plantDetails.getPruningMonth(),
            Objects.requireNonNull(plantDetails.getPruningCount().stream().findFirst().orElse(new PruningCount(null, null))),
            plantDetails.getCareLevel(),
            requestBody.getWateringFrequency(),
            requestBody.getSunlightIncidence(),
            requestBody.getSoilType(),
            plantation.get().getId(),
            requestBody.getQuantity(),
            LocalDateTime.now()
    );

    plantedPlantRepository.save(newPlantedPlant);
    return new CreatePlantResponseDto(newPlantedPlant, requestBody.getQuantity(), plantation.get().getName());
  }

  public GetPlantingBestPracticesResponseDto getPlantingBestPractices(GetPlantingBestPracticesRequestDto requestBody) {
    PerenualPlantDetailsDto plantDetails = perenualService.getPlantDetails(requestBody.plantId());

    WateringFrequencyEnum idealWateringFrequency = plantDetails.getIdealWateringFrequency();
    PlantingPracticeEvaluation<WateringFrequencyEnum> wateringEvaluation = new PlantingPracticeEvaluation<>(
            idealWateringFrequency == requestBody.wateringFrequency(),
            List.of(idealWateringFrequency)
    );

    List<SunlightIncidenceEnum> idealSunlightIncidenceList = plantDetails.getIdealSunlightIncidences();
    PlantingPracticeEvaluation<SunlightIncidenceEnum> sunlightIncidenceEvaluation = new PlantingPracticeEvaluation<>(
            idealSunlightIncidenceList.contains(requestBody.sunlightIncidence()) || idealSunlightIncidenceList.isEmpty(),
            idealSunlightIncidenceList
    );

    List<SoilTypeEnum> idealSoilTypeList = plantDetails.getIdealSoilTypes();
    PlantingPracticeEvaluation<SoilTypeEnum> soilTypeEvaluation = new PlantingPracticeEvaluation<>(
            idealSoilTypeList.contains(requestBody.soilType()) || idealSoilTypeList.isEmpty(),
            idealSoilTypeList
    );

    return new GetPlantingBestPracticesResponseDto(
            requestBody.plantId(),
            wateringEvaluation,
            sunlightIncidenceEvaluation,
            soilTypeEvaluation
    );
  }

  /**
   * Updates an existing plant.
   *
   * @param requestBody The request containing the updated plant details.
   * @return {@link UpdatePlantResponseDto} containing the updated plant details.
   * @throws IllegalArgumentException if the plant is not found.
   */
  public UpdatePlantResponseDto updatePlant(UpdatePlantRequestDto requestBody) {
    PlantedPlant plant = plantRepository
      .findById(requestBody.getId())
      .orElseThrow(() -> new IllegalArgumentException("Plant not found"));

    requestBody.getScientificName().ifPresent(plant::setScientificName);
    requestBody.getCommonName().ifPresent(plant::setCommonName);
    requestBody.getMaxFeetHeight().ifPresent(plant::setMaxFeetHeight);
    requestBody.getCycle().ifPresent(plant::setCycle);
    requestBody.getWateringFrequency().ifPresent(plant::setWateringFrequency);
    requestBody.getSunlightIncidence().ifPresent(plant::setSunlightIncidence);
    requestBody.getSoilType().ifPresent(plant::setSoilType);
    requestBody.getCareLevel().ifPresent(plant::setCareLevel);

    plantRepository.save(plant);
    return new UpdatePlantResponseDto(plant);
  }

  /**
   * Deletes a plant by ID.
   *
   * @param id The ID of the plant to delete.
   * @throws IllegalArgumentException if the plant is not found.
   */
  public void deletePlant(UUID id) {
    if (!plantRepository.existsById(id)) {
      throw new IllegalArgumentException("Plant not found");
    }
    plantRepository.deleteById(id);
  }
}
