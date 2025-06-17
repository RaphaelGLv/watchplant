package com.watchplant.app.services;

import com.watchplant.app.dtos.plant.*;
import com.watchplant.app.entities.Plantation;
import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.repositories.PlantRepository;
import com.watchplant.app.repositories.PlantationRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.Dimensions;
import com.watchplant.app.utils.PruningCount;
import com.watchplant.app.utils.UserContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

  private final PlantRepository plantRepository;
  private final PlantationRepository plantationRepository;
  private final PerenualService perenualService;

  /**
   * Constructor for {@link PlantService}.
   *
   * @param plantRepository The repository for {@link PlantedPlant} entities.
   */
  public PlantService(PlantRepository plantRepository, PlantationRepository plantationRepository, PerenualService perenualService) {
    this.plantRepository = plantRepository;
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
    PlantedPlant plantedPlant = plantRepository
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
    Optional<Plantation> plantation = plantationRepository.findByIdAndOwnerId(requestBody.getPlantation().id(), userId);

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
            requestBody.getPlantation().id(),
            requestBody.getQuantity()
    );

    plantRepository.save(newPlantedPlant);
    return new CreatePlantResponseDto(newPlantedPlant, requestBody.getQuantity(), requestBody.getPlantation().name());
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

  public List<GetPlantResponseDto> listPlantsByPlantationId(UUID plantationId) {
    UUID userId = UserContext.getUserId();
    boolean owns = plantationRepository.findByIdAndOwnerId(plantationId, userId).isPresent();
    if (!owns) {
      throw new ApplicationException("Plantação não encontrada", HttpStatus.NOT_FOUND);
    }
    return plantRepository.findAll().stream()
      .filter(plant -> plantationId.equals(plant.getPlantationId()))
      .map(GetPlantResponseDto::new)
      .collect(Collectors.toList());
  }

  public PerenualPlantSearchResponseDto searchPlantsOnPerenual(
      String q,
      Integer page,
      String order,
      Boolean edible,
      Boolean poisonous,
      String cycle,
      String watering,
      String sunlight,
      Boolean indoor,
      String hardiness
  ) {
    return perenualService.searchPlants(
        q, page, order, edible, poisonous, cycle, watering, sunlight, indoor, hardiness
    );
  }
}
