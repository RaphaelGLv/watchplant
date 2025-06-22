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
public enum WateringFrequencyEnum implements IWateringNeedParameter {
  FREQUENT("Frequent", NeedOfWaterEnum.HIGH),
  AVERAGE("Average", NeedOfWaterEnum.MEDIUM),
  MINIMUM("Minimum", NeedOfWaterEnum.LOW),
  NONE("None", NeedOfWaterEnum.NONE);

  private final String type;
  private final NeedOfWaterEnum needOfWater;

  WateringFrequencyEnum(String type, NeedOfWaterEnum needOfWater) {
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
  public static WateringFrequencyEnum fromString(String value) {
    try {
      return WateringFrequencyEnum.valueOf(value.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid value for WateringFrequencyEnum: " + value);
    }
  }
}
