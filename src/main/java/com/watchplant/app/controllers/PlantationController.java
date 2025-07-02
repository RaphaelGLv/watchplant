package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plantation.*;
import com.watchplant.app.dtos.plantedPlant.GetPlantedPlantResponseDto;
import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.services.PlantedPlantService;
import com.watchplant.app.services.PlantationService;
import com.watchplant.app.utils.UserContext;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantation")
class PlantationController {
    private final PlantationService plantationService;
    private final PlantedPlantService plantedPlantService;

    PlantationController(PlantationService plantationService, PlantedPlantService plantedPlantService) {
        this.plantationService = plantationService;
        this.plantedPlantService = plantedPlantService;
    }

    @PostMapping()
    public CreatePlantationResponseDto createPlantation(@Valid @RequestBody CreatePlantationRequestDto createPlantationRequestDto) {
        return this.plantationService.createPlantation(createPlantationRequestDto);
    }

    @GetMapping("/{name}")
    public GetPlantationResponseDto getPlantation(@PathVariable String name) {
        PlantationKey key = new PlantationKey(UserContext.getUserEmail(), name);

        return plantationService.getPlantation(new GetPlantationRequestDto(key));
    }

    @PutMapping("/{name}")
    public UpdatePlantationResponseDto updatePlantation(
            @PathVariable String name,
            @Valid @RequestBody UpdatePlantationRequestDto requestBody
    ) {
        PlantationKey key = new PlantationKey(UserContext.getUserEmail(), name);
        requestBody.setKey(key);

        return plantationService.updatePlantation(requestBody);
    }

    @DeleteMapping("/{name}")
    public void deletePlantation(@PathVariable String name) {
        PlantationKey key = new PlantationKey(UserContext.getUserEmail(), name);
        plantationService.deletePlantation(key);
    }

    @GetMapping("/plants/{name}")
    public List<GetPlantedPlantResponseDto> listPlantsByPlantation(@PathVariable String name) {
        PlantationKey plantationKey = new PlantationKey(UserContext.getUserEmail(), name);
        return plantedPlantService.listPlantsByPlantationKey(plantationKey);
    }
}
