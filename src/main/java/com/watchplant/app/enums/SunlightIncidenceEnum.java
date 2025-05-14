/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.enums;

/**
 *
 * @author pedro
 */
public enum SunlightIncidenceEnum {
  FULL_SHADE("Full Shade"),
  PART_SHADE("Part Shade"),
  SUN_PART_SHADE("Sun Part Shade"),
  FULL_SUN("Full Sun");

  private final String type;

  SunlightIncidenceEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
