package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plant.CreatePlantRequestDto;
import com.watchplant.app.dtos.plant.CreatePlantResponseDto;
import com.watchplant.app.services.PlantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
