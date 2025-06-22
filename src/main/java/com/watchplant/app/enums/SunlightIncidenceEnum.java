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
public enum SunlightIncidenceEnum implements IWateringNeedParameter {
  FULL_SHADE("Full Shade", NeedOfWaterEnum.LOW),
  PART_SHADE("Part Shade", NeedOfWaterEnum.MEDIUM),
  SUN_PART_SHADE("Sun Part Shade", NeedOfWaterEnum.MEDIUM),
  FULL_SUN("Full Sun", NeedOfWaterEnum.HIGH);

  private final String type;
  private final NeedOfWaterEnum needOfWater;

  SunlightIncidenceEnum(String type, NeedOfWaterEnum needOfWater) {
    this.type = type;
      this.needOfWater = needOfWater;
  }

  public String getType() {
    return type;
  }

  @Override
  public int getNeedOfWaterLevel() {
    return needOfWater.getLevel();
  }

  @JsonCreator
  public static SunlightIncidenceEnum fromString(String type) {
    try {
      return SunlightIncidenceEnum.valueOf(type.toUpperCase().replace(" ", "_"));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid SunlightIncidenceEnum type: " + type);
    }
  }
}
