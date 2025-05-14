/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.enums;

/**
 *
 * @author pedro
 */
public enum WateringFrequencyEnum {
  FREQUENT("Frequent"),
  AVERAGE("Average"),
  MINIMUM("Minimum"),
  NONE("None");

  private final String type;

  WateringFrequencyEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
