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
public enum CareLevelEnum {
  LOW("Low"),
  MEDIUM("Medium"),
  HIGH("High");

  private final String type;

  CareLevelEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  @JsonCreator
  public static CareLevelEnum fromString(String text) {
    try {
      return CareLevelEnum.valueOf(text.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid value for CareLevelEnum: " + text);
    }
  }
}
