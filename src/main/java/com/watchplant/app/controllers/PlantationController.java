package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plant.GetPlantResponseDto;
import com.watchplant.app.dtos.plantation.*;
import com.watchplant.app.services.PlantService;
import com.watchplant.app.services.PlantationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plantation")
class PlantationController {
    private final PlantationService plantationService;
    private final PlantService plantService;

    PlantationController(PlantationService plantationService, PlantService plantService) {
        this.plantationService = plantationService;
        this.plantService = plantService;
    }

    @PostMapping("/")
    public CreatePlantationResponseDto createPlantation(@Valid @RequestBody CreatePlantationRequestDto createPlantationRequestDto) {
        return this.plantationService.createPlantation(createPlantationRequestDto);
    }

    @GetMapping("/{id}")
    public GetPlantationResponseDto getPlantation(@PathVariable UUID id) {
        return plantationService.getPlantation(new GetPlantationRequestDto(id));
    }

    @PutMapping("/{id}")
    public UpdatePlantationResponseDto updatePlantation(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePlantationRequestDto updatePlantationRequestDto
    ) {
        return plantationService.updatePlantation(
            new UpdatePlantationRequestDto(
                id,
                updatePlantationRequestDto.getName().orElse(null),
                updatePlantationRequestDto.getSizeArea().orElse(null),
                updatePlantationRequestDto.getSoilType().orElse(null),
                updatePlantationRequestDto.getSunlightIncidence().orElse(null)
            )
        );
    }

    @DeleteMapping("/{id}")
    public void deletePlantation(@PathVariable UUID id) {
        plantationService.deletePlantation(id);
    }

    @GetMapping("/plants")
    public List<GetPlantResponseDto> listPlantsByPlantation(@RequestParam UUID plantationId) {
        return plantService.listPlantsByPlantationId(plantationId);
    }
}
