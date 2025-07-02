package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plantedPlant.CreatePlantedPlantRequestDto;
import com.watchplant.app.dtos.plantedPlant.CreatePlantedPlantResponseDto;
import com.watchplant.app.dtos.plantedPlant.GetPlantedPlantResponseDto;
import com.watchplant.app.dtos.plantedPlant.GetPlantingBestPracticesRequestDto;
import com.watchplant.app.dtos.plantedPlant.GetPlantingBestPracticesResponseDto;
import com.watchplant.app.dtos.plantedPlant.PerenualPlantSearchResponseDto;
import com.watchplant.app.dtos.plantedPlant.UpdatePlantedPlantRequestDto;
import com.watchplant.app.dtos.plantedPlant.UpdatePlantedPlantResponseDto;
import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.entities.keys.PlantedPlantKey;
import com.watchplant.app.services.PlantedPlantService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/plant")
class PlantedPlantController {
    private final PlantedPlantService plantService;

    PlantedPlantController(PlantedPlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping()
    CreatePlantedPlantResponseDto registerPlant(@Valid @RequestBody CreatePlantedPlantRequestDto createPlantRequestDto) {
        return plantService.createPlant(createPlantRequestDto);
    }

    @PostMapping("/suggestion")
    GetPlantingBestPracticesResponseDto getPlantingBestPractices(@Valid @RequestBody GetPlantingBestPracticesRequestDto requestBody) {
        return plantService.getPlantingBestPractices(requestBody);
    }

    @GetMapping()
    public GetPlantedPlantResponseDto getPlant(
            @RequestParam int perenualPlantId,
            @RequestParam @DateTimeFormat LocalDateTime plantationDate,
            @RequestParam String email,
            @RequestParam String plantationName
            ) {
        PlantedPlantKey key = new PlantedPlantKey(perenualPlantId, plantationDate, new PlantationKey(email, plantationName));

        return plantService.getPlant(key);
    }

    @PutMapping()
    public UpdatePlantedPlantResponseDto updatePlant(
            @RequestParam int perenualPlantId,
            @RequestParam @DateTimeFormat LocalDateTime plantationDate,
            @RequestParam String email,
            @RequestParam String plantationName,
            @Valid @RequestBody UpdatePlantedPlantRequestDto requestBody
    ) {
        PlantedPlantKey key = new PlantedPlantKey(perenualPlantId, plantationDate, new PlantationKey(email, plantationName));
        requestBody.setPlantedPlantKey(key);
        return plantService.updatePlant(requestBody);
    }

    @DeleteMapping()
    public void deletePlant(
                            @RequestParam int perenualPlantId,
                            @RequestParam @DateTimeFormat LocalDateTime plantationDate,
                            @RequestParam String email,
                            @RequestParam String plantationName
    ) {
        PlantedPlantKey key = new PlantedPlantKey(perenualPlantId, plantationDate, new PlantationKey(email, plantationName));
        plantService.deletePlant(key);
    }

    @GetMapping("/search")
    public PerenualPlantSearchResponseDto searchPlants(@RequestParam(required = false) String q) {
        return plantService.searchPlantsOnPerenual(q);
    }
}
