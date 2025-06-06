/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.enums;

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

  public static SoilTypeEnum fromString(String type) {
    for (SoilTypeEnum soilType : SoilTypeEnum.values()) {
      if (soilType.getType().equalsIgnoreCase(type)) {
        return soilType;
      }
    }
    throw new IllegalArgumentException("Tipo de solo inválido: " + type);
  }

}
