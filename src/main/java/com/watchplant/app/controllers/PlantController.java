package com.watchplant.app.controllers;

import com.watchplant.app.dtos.plant.CreatePlantRequestDto;
import com.watchplant.app.dtos.plant.CreatePlantResponseDto;
import com.watchplant.app.dtos.plant.GetPlantResponseDto;
import com.watchplant.app.dtos.plant.UpdatePlantRequestDto;
import com.watchplant.app.dtos.plant.UpdatePlantResponseDto;
import com.watchplant.app.dtos.plant.PerenualPlantSearchResponseDto;
import com.watchplant.app.dtos.plant.GetPlantingBestPracticesRequestDto;
import com.watchplant.app.dtos.plant.GetPlantingBestPracticesResponseDto;
import com.watchplant.app.entities.keys.PlantationKey;
import com.watchplant.app.entities.keys.PlantedPlantKey;
import com.watchplant.app.services.PlantService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/plant")
class PlantController {
    private final PlantService plantService;

    PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping()
    CreatePlantResponseDto registerPlant(@Valid @RequestBody CreatePlantRequestDto createPlantRequestDto) {
        return plantService.createPlant(createPlantRequestDto);
    }

    @PostMapping("/suggestion")
    GetPlantingBestPracticesResponseDto getPlantingBestPractices(@Valid @RequestBody GetPlantingBestPracticesRequestDto requestBody) {
        return plantService.getPlantingBestPractices(requestBody);
    }

    @GetMapping()
    public GetPlantResponseDto getPlant(
            @RequestParam int perenualPlantId,
            @RequestParam @DateTimeFormat LocalDateTime plantationDate,
            @RequestParam String email,
            @RequestParam String plantationName
            ) {
        PlantedPlantKey key = new PlantedPlantKey(perenualPlantId, plantationDate, new PlantationKey(email, plantationName));

        return plantService.getPlant(key);
    }

    @PutMapping()
    public UpdatePlantResponseDto updatePlant(
            @RequestParam int perenualPlantId,
            @RequestParam @DateTimeFormat LocalDateTime plantationDate,
            @RequestParam String email,
            @RequestParam String plantationName,
            @Valid @RequestBody UpdatePlantRequestDto requestBody
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
