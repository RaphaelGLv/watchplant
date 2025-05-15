/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

  public String fetchGetPlantDetails(String plantId) {
    try {
      URL url = new URL(
        BASE_URL + "v2/species/details/" + plantId + "?key=" + apiKey
      );
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream())
      );
      String inputLine;
      StringBuffer content = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      connection.disconnect();
      return content.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
