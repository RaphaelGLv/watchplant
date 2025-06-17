package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plantation.CreatePlantationRequestDto;
import com.watchplant.app.dtos.plantation.CreatePlantationResponseDto;
import com.watchplant.app.dtos.plantation.GetPlantationRequestDto;
import com.watchplant.app.dtos.plantation.GetPlantationResponseDto;
import com.watchplant.app.dtos.plantation.UpdatePlantationRequestDto;
import com.watchplant.app.dtos.plantation.UpdatePlantationResponseDto;
import com.watchplant.app.services.PlantationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/plantation")
class PlantationController {
    private final PlantationService plantationService;

    PlantationController(PlantationService plantationService) {
        this.plantationService = plantationService;
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
}
