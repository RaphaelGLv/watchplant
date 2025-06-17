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
import com.watchplant.app.dtos.plant.PerenualPlantSearchResponseDto;
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

  public PerenualPlantSearchResponseDto searchPlants(
    String q,
    Integer page,
    String order,
    Boolean edible,
    Boolean poisonous,
    String cycle,
    String watering,
    String sunlight,
    Boolean indoor,
    String hardiness
  ) {
    try {
      URL url = new URL(
        BASE_URL + "v2/species-list?key=" + apiKey
      );

      if (q != null) url = new URL(url.toString() + "&q=" + q);
      if (page != null) url = new URL(url.toString() + "&page=" + page);
      if (order != null) url = new URL(url.toString() + "&order=" + order);
      if (edible != null) url = new URL(url.toString() + "&edible=" + (edible ? 1 : 0));
      if (poisonous != null) url = new URL(url.toString() + "&poisonous=" + (poisonous ? 1 : 0));
      if (cycle != null) url = new URL(url.toString() + "&cycle=" + cycle);
      if (watering != null) url = new URL(url.toString() + "&watering=" + watering);
      if (sunlight != null) url = new URL(url.toString() + "&sunlight=" + sunlight);
      if (indoor != null) url = new URL(url.toString() + "&indoor=" + (indoor ? 1 : 0));
      if (hardiness != null) url = new URL(url.toString() + "&hardiness=" + hardiness);

      RestTemplate restTemplate = new RestTemplate();
      JsonNode responseJson = restTemplate.getForObject(url.toString(), JsonNode.class);

      ObjectMapper mapper = new ObjectMapper();
      PerenualPlantSearchResponseDto result = new PerenualPlantSearchResponseDto();
      if (responseJson.has("data")) {
        for (JsonNode plantNode : responseJson.get("data")) {
          PerenualPlantDetailsDto plant = mapper.readValue(plantNode.toString(), PerenualPlantDetailsDto.class);
          result.addPlant(plant);
        }
      }
      if (responseJson.has("to")) result.setTo(responseJson.get("to").asInt());
      if (responseJson.has("per_page")) result.setPerPage(responseJson.get("per_page").asInt());
      if (responseJson.has("current_page")) result.setCurrentPage(responseJson.get("current_page").asInt());
      if (responseJson.has("from")) result.setFrom(responseJson.get("from").asInt());
      if (responseJson.has("last_page")) result.setLastPage(responseJson.get("last_page").asInt());
      if (responseJson.has("total")) result.setTotal(responseJson.get("total").asInt());

      return result;
    } catch (Exception e) {
      throw new ApplicationException(e.getMessage());
    }
  }
}
