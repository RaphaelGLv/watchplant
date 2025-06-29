/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.watchplant.app.interfaces.IWateringNeedParameter;

/**
 *
 * @author pedro
 */
public enum SoilTypeEnum implements IWateringNeedParameter {
  CLAY("Clay", NeedOfWaterEnum.LOW),
  LOAM("Loam", NeedOfWaterEnum.LOW),
  BOG("Bog", NeedOfWaterEnum.LOW),
  PEAT("Peat", NeedOfWaterEnum.MEDIUM),
  HUMUS_ENRICHED("Humus Enriched", NeedOfWaterEnum.MEDIUM),
  SAND("Sand", NeedOfWaterEnum.HIGH),
  SILT("Silt", NeedOfWaterEnum.HIGH),
  CHALK("Chalk", NeedOfWaterEnum.HIGH),;

  private final String type;
  private final NeedOfWaterEnum needOfWater;

  SoilTypeEnum(String type, NeedOfWaterEnum needOfWater) {
    this.type = type;
    this.needOfWater = needOfWater;
  }

  public String getType() {
    return type;
  }

  @JsonCreator
  public static SoilTypeEnum fromString(String type) {
    try {
      return SoilTypeEnum.valueOf(type.toUpperCase().trim().replace(" ", "_"));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid SoilTypeEnum: " + type);
    }
  }

    @Override
    public int getNeedOfWaterLevel() {
        return needOfWater.getLevel();
    }
}
