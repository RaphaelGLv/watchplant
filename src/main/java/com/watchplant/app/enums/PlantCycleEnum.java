/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *
 * @author pedro
 */
public enum PlantCycleEnum {
  PERENNIAL("Perennial"),
  ANNUAL("Annual"),
  BIENNIAL("Biennial"),
  HERBACEOUS_PERENNIAL("Herbaceous Perennial");

  private final String type;

  PlantCycleEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  @JsonCreator
  public static PlantCycleEnum fromString(String value) {
    try {
      return PlantCycleEnum.valueOf(value.toUpperCase().trim().replace(" ", "_"));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid value for PlantCycleEnum: " + value);
    }
  }
}
