/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.enums;

/**
 *
 * @author pedro
 */
public enum PlantCycleEnum {
  PERENNIAL("Perennial"),
  ANNUAL("Annual"),
  BIENNIAL("Biennial");

  private final String type;

  PlantCycleEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
