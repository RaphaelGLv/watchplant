package com.watchplant.app.dtos.plantation;

import com.watchplant.app.entities.Plantation;
import com.watchplant.app.enums.SoilTypeEnum;
import com.watchplant.app.enums.SunlightIncidenceEnum;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * DTO for the response of creating a plantation.
 * Contains the details of the created plantation.
 */
public class CreatePlantationResponseDto {

  @NotBlank(message = "O nome da plantação é um campo obrigatório")
  private String name;

  @NotBlank(message = "A área da plantação é um campo obrigatório")
  private Double sizeArea;

  @NotBlank(message = "O tipo de solo é um campo obrigatório")
  private SoilTypeEnum soilType;

  @NotBlank(message = "A frequência de incidência solar é um campo obrigatório")
  private SunlightIncidenceEnum sunlightIncidence;

  /**
   * Constructor for CreatePlantationResponseDto.
   *
   * @param plantation The created plantation.
   */
  public CreatePlantationResponseDto(Plantation plantation) {
    this.name = plantation.getKey().getName();
    this.sizeArea = plantation.getSizeArea();
    this.soilType = plantation.getSoilType();
    this.sunlightIncidence = plantation.getSunlightIncidence();
  }

  /**
   * Gets the name of the plantation.
   *
   * @return The name of the plantation.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the size area of the plantation.
   *
   * @return The size area of the plantation.
   */
  public Double getSizeArea() {
    return sizeArea;
  }

  public SoilTypeEnum getSoilType() {
    return soilType;
  }

  public void setName(@NotBlank(message = "O nome da plantação é um campo obrigatório") String name) {
    this.name = name;
  }

  public void setSizeArea(@NotBlank(message = "A área da plantação é um campo obrigatório") Double sizeArea) {
    this.sizeArea = sizeArea;
  }

  public void setSoilType(SoilTypeEnum soilType) {
    this.soilType = soilType;
  }

  public @NotBlank(message = "A frequência de incidência solar é um campo obrigatório") SunlightIncidenceEnum getSunlightIncidence() {
    return sunlightIncidence;
  }

  public void setSunlightIncidence(@NotBlank(message = "A frequência de incidência solar é um campo obrigatório") SunlightIncidenceEnum sunlightIncidence) {
    this.sunlightIncidence = sunlightIncidence;
  }
}
