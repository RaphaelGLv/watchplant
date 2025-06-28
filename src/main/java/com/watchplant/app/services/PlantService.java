package com.watchplant.app.services;

import com.watchplant.app.dtos.plant.*;
import com.watchplant.app.entities.Plantation;
import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.entities.keys.PlantedPlantKey;
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
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

  public GetPlantResponseDto getPlant(PlantedPlantKey plantedPlantKey) {
    PlantedPlant plantedPlant = plantedPlantRepository
      .findById(plantedPlantKey)
      .orElseThrow(() -> new ApplicationException("Planta não encontrada.", HttpStatus.NOT_FOUND));
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

    PlantationKey plantationKey = new PlantationKey(UserContext.getUserEmail(), requestBody.getPlantationName());
    Optional<Plantation> plantation = plantationRepository.findById(plantationKey);

    if (plantation.isEmpty())
      throw new ApplicationException("Plantação não encontrada", HttpStatus.NOT_FOUND);

    PlantedPlantKey plantedPlantKey = new PlantedPlantKey(plantDetails.getId(), LocalDateTime.now(), plantation.get().getKey());
    PlantedPlant newPlantedPlant = new PlantedPlant(
            plantedPlantKey,
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
            requestBody.getQuantity(),
            LocalDateTime.now()
    );

    plantedPlantRepository.save(newPlantedPlant);
    return new CreatePlantResponseDto(newPlantedPlant);
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

  public UpdatePlantResponseDto updatePlant(UpdatePlantRequestDto requestBody) {
    PlantedPlant plant = plantedPlantRepository
      .findById(requestBody.getPlantedPlantKey())
      .orElseThrow(() -> new ApplicationException("Planta não encontrada.", HttpStatus.NOT_FOUND));

    requestBody.getWateringFrequency().ifPresent(plant::setWateringFrequency);
    requestBody.getSunlightIncidence().ifPresent(plant::setSunlightIncidence);
    requestBody.getSoilType().ifPresent(plant::setSoilType);
    requestBody.getQuantity().ifPresent(plant::setQuantity);

    plantedPlantRepository.save(plant);
    return new UpdatePlantResponseDto(plant);
  }

  /**
   * Deletes a plant by ID.
   *
   * @param plantedPlantKey The ID of the plant to delete.
   * @throws IllegalArgumentException if the plant is not found.
   */
  public void deletePlant(PlantedPlantKey plantedPlantKey) {
    plantedPlantRepository.deleteById(plantedPlantKey);
  }

  public List<GetPlantResponseDto> listPlantsByPlantationKey(PlantationKey plantationKey) {
    boolean owns = plantationRepository.existsById(plantationKey);
    if (!owns) {
      throw new ApplicationException("Plantação não encontrada", HttpStatus.NOT_FOUND);
    }
    return plantedPlantRepository.findAll().stream()
      .filter(plant -> plantationKey.equals(plant.getKey().getPlantationKey()))
      .map(GetPlantResponseDto::new)
      .collect(Collectors.toList());
  }

  public PerenualPlantSearchResponseDto searchPlantsOnPerenual(String q) {
    return perenualService.searchPlants(q);
  }
}
