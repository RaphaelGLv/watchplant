package com.watchplant.app.dtos.plantation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PlantationPreviewDto(
        @NotNull(message = "O id da plantação é um campo obrigatório")
        UUID id,

        @NotBlank(message = "O nome da plantação é um campo obrigatório")
        String name
) {

}
