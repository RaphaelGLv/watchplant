package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plant.CreatePlantRequestDto;
import com.watchplant.app.dtos.plant.CreatePlantResponseDto;
import com.watchplant.app.dtos.plant.GetPlantRequestDto;
import com.watchplant.app.dtos.plant.GetPlantResponseDto;
import com.watchplant.app.dtos.plant.UpdatePlantRequestDto;
import com.watchplant.app.dtos.plant.UpdatePlantResponseDto;
import com.watchplant.app.dtos.plant.GetPlantingBestPracticesRequestDto;
import com.watchplant.app.dtos.plant.GetPlantingBestPracticesResponseDto;
import com.watchplant.app.services.PlantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/plant")
class PlantController {
    private final PlantService plantService;

    PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping("/")
    CreatePlantResponseDto registerPlant(@Valid @RequestBody CreatePlantRequestDto createPlantRequestDto) {
        return plantService.createPlant(createPlantRequestDto);
    }

    @PostMapping("/suggestion")
    GetPlantingBestPracticesResponseDto getPlantingBestPractices(@Valid @RequestBody GetPlantingBestPracticesRequestDto requestBody) {
        return plantService.getPlantingBestPractices(requestBody);
    }

    @GetMapping("/{id}")
    public GetPlantResponseDto getPlant(@PathVariable UUID id) {
        return plantService.getPlant(new GetPlantRequestDto(id));
    }

    @PutMapping("/{id}")
    public UpdatePlantResponseDto updatePlant(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePlantRequestDto updatePlantRequestDto
    ) {
        return plantService.updatePlant(
            new UpdatePlantRequestDto(
                id,
                updatePlantRequestDto.getScientificName().orElse(null),
                updatePlantRequestDto.getCommonName().orElse(null),
                updatePlantRequestDto.getMaxFeetHeight().orElse(null),
                updatePlantRequestDto.getCycle().orElse(null),
                updatePlantRequestDto.getWateringFrequency().orElse(null),
                updatePlantRequestDto.getSunlightIncidence().orElse(null),
                updatePlantRequestDto.getPruningMonth().orElse(null),
                updatePlantRequestDto.getPruningCountYearly().orElse(null),
                updatePlantRequestDto.getSoilType().orElse(null),
                updatePlantRequestDto.getCareLevel().orElse(null)
            )
        );
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable UUID id) {
        plantService.deletePlant(id);
    }
}
