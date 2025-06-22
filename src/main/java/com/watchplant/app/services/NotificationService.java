/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchplant.app.services;

import com.watchplant.app.dtos.notification.*;
import com.watchplant.app.entities.Notification;
import com.watchplant.app.entities.Plantation;
import com.watchplant.app.entities.PlantedPlant;
import com.watchplant.app.enums.NotificationTypeEnum;
import com.watchplant.app.repositories.NotificationRepository;

import java.time.LocalDateTime;
import java.util.*;

import com.watchplant.app.repositories.PlantationRepository;
import com.watchplant.app.repositories.PlantedPlantRepository;
import com.watchplant.app.services.exceptions.ApplicationException;
import com.watchplant.app.utils.HarvestNeedValidator;
import com.watchplant.app.utils.UserContext;
import com.watchplant.app.utils.WateringNeedValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Notification entities.
 */
@Service
public class NotificationService {

  private final NotificationRepository notificationRepository;
  private final PlantationRepository plantationRepository;
  private final PlantedPlantRepository plantedPlantRepository;

    public NotificationService(NotificationRepository notificationRepository, PlantationRepository plantationRepository, PlantedPlantRepository plantedPlantRepository) {
        this.notificationRepository = notificationRepository;
        this.plantationRepository = plantationRepository;
        this.plantedPlantRepository = plantedPlantRepository;
    }


  /**
   * Fetches a notification by ID.
   * @param request;
   * @return {@link GetNotificationResponseDto} containing the notification details.
   * @throws IllegalArgumentException if the notification is not found.
   */
  public GetNotificationResponseDto getNotification(
    GetNotificationRequestDto request
  ) {
    UUID id = request.getId();
    Notification notification = notificationRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Notification not found")
      );
    return new GetNotificationResponseDto(notification);
  }

  public GetAllNotificationsResponseDTO getAllNotifications() {
    List<Notification> notifications = notificationRepository.findAllByUserId(UserContext.getUserId());

    List<GetNotificationResponseDto> responseDtos = new ArrayList<>();
    for (Notification notification : notifications) {
      responseDtos.add(new GetNotificationResponseDto(notification));
    }

    return new GetAllNotificationsResponseDTO(responseDtos);
  }

  public void updateNotifications() {
    List<Plantation> userPlantationList = plantationRepository.findAllByOwnerId(UserContext.getUserId());

    HashMap<Plantation, List<PlantedPlant>> plantationPlantsMap = new HashMap<>();
    for (Plantation plantation : userPlantationList) {
      List<PlantedPlant> plantationPlants = plantedPlantRepository.findAllByPlantationId(plantation.getId());

      if (!plantationPlants.isEmpty())
        plantationPlantsMap.put(plantation, plantationPlants);
    }

    for (Map.Entry<Plantation, List<PlantedPlant>> entry : plantationPlantsMap.entrySet()) {
      Plantation plantation = entry.getKey();
      List<PlantedPlant> plants = entry.getValue();

      for (PlantedPlant plantedPlant : plants) {
        LocalDateTime now = LocalDateTime.now();

        if (HarvestNeedValidator.isHarvestNeeded(plantedPlant)) {
          Notification newHarvestingNotification = new Notification(
                  UserContext.getUserId(),
                  plantation.getId(),
                  plantedPlant.getId(),
                  now,
                  String.format("Atenção! A planta \"%s\" da sua plantação \"%s\" está em época de colheita!", plantedPlant.getCommonName(), plantation.getName()),
                  false,
                  NotificationTypeEnum.HARVESTING
          );
          notificationRepository.save(newHarvestingNotification);
        }

        if (WateringNeedValidator.isWateringNeeded(plantedPlant)) {
          Notification newWateringNotification = new Notification(
                  UserContext.getUserId(),
                  plantation.getId(),
                  plantedPlant.getId(),
                  now,
                  String.format("Atenção! A planta \"%s\" da sua plantação \"%s\" pode estar precisando ser regada!", plantedPlant.getCommonName(), plantation.getName()),
                  false,
                  NotificationTypeEnum.WATERING
          );
          notificationRepository.save(newWateringNotification);
        }
      }
    }

  }

  private void saveNotification(Notification notification) {
    try {
      notificationRepository.save(notification);
    } catch (Exception e) {
      throw new ApplicationException("Erro ao criar notificação", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
