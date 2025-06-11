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
public enum SoilTypeEnum {
  CLAY("Clay"),
  SANDY("Sandy"),
  LOAMY("Loamy"),
  SILTY("Silty"),
  PEATY("Peaty"),
  CHALKY("Chalky");

  private final String type;

  SoilTypeEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  @JsonCreator
  public static SoilTypeEnum fromString(String type) {
    try {
      return SoilTypeEnum.valueOf(type.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid SoilTypeEnum: " + type);
    }
  }

}
