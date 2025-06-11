/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import java.net.URL;
import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.watchplant.app.dtos.plant.PerenualPlantDetailsDto;
import com.watchplant.app.services.exceptions.ApplicationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author pedro
 */
@Service
public class PerenualService {

  private static final String BASE_URL = "https://perenual.com/api/";
  private final String apiKey;

  public PerenualService(@Value("${perenual.api.key}") String apiKey) {
    this.apiKey = apiKey;
  }

  public PerenualPlantDetailsDto getPlantDetails(Integer plantId) {
    try {
      URL url = new URL(
        BASE_URL + "v2/species/details/" + plantId + "?key=" + apiKey
      );

      RestTemplate restTemplate = new RestTemplate();
      JsonNode plantDetailsJson = Objects.requireNonNull(restTemplate.getForObject(url.toString(), JsonNode.class));

      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(plantDetailsJson.toString(), PerenualPlantDetailsDto.class);
    } catch (Exception e) {
      throw new ApplicationException(e.getMessage());
    }
  }
}
