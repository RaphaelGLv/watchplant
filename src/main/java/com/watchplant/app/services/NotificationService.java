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
import java.time.temporal.ChronoUnit;
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

  public GetAllNotificationsResponseDTO getAllNotifications() {
    List<Notification> notifications = notificationRepository.findAllByUserEmail(UserContext.getUserEmail());

    List<GetNotificationResponseDto> responseDtos = new ArrayList<>();
    List<Notification> notificationsToDelete = new ArrayList<>();
    for (Notification notification : notifications) {
      if (notification.getSeenAt().isPresent() && ChronoUnit.DAYS.between(notification.getSeenAt().get(), LocalDateTime.now()) > 3)
        notificationsToDelete.add(notification);
      else
        responseDtos.add(new GetNotificationResponseDto(notification));
    }

    notificationRepository.deleteAll(notificationsToDelete);
    return new GetAllNotificationsResponseDTO(responseDtos);
  }

  public void createNewNotifications() {
    List<Plantation> userPlantationList = plantationRepository.findAllByKey_userEmail(UserContext.getUserEmail());

    HashMap<Plantation, List<PlantedPlant>> plantationPlantsMap = new HashMap<>();
    for (Plantation plantation : userPlantationList) {
      List<PlantedPlant> plantationPlants = plantedPlantRepository.findAllByKey_PlantationKey(plantation.getKey());

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
                  UserContext.getUserEmail(),
                  plantedPlant.getKey(),
                  now,
                  String.format("Atenção! A planta \"%s\" da sua plantação \"%s\" está em época de colheita!", plantedPlant.getCommonName(), plantation.getKey().getName()),
                  null,
                  NotificationTypeEnum.HARVESTING
          );
          saveNotification(newHarvestingNotification);
        }

        if (WateringNeedValidator.isWateringNeeded(plantedPlant)) {
          Notification newWateringNotification = new Notification(
                  UserContext.getUserEmail(),
                  plantedPlant.getKey(),
                  now,
                  String.format("Atenção! A planta \"%s\" da sua plantação \"%s\" pode estar precisando ser regada!", plantedPlant.getCommonName(), plantation.getKey().getName()),
                  null,
                  NotificationTypeEnum.WATERING
          );
          saveNotification(newWateringNotification);
        }
      }
    }

  }

  private void saveNotification(Notification notification) {
    try {
      if (!notificationRepository.existsById(notification.getKey())) {
        notificationRepository.save(notification);
      }
    } catch (Exception e) {
      throw new ApplicationException("Erro ao criar notificação", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  public GetNotificationResponseDto patchNotificationSeen(PatchNotificationSeenRequestDto requestBody) {
    if (!requestBody.key().getPlantedPlantKey().getPlantationKey().getUserEmail().equals(UserContext.getUserEmail()))
      throw new ApplicationException("Usuário não autorizado", HttpStatus.UNAUTHORIZED);

    Optional<Notification> notification = notificationRepository.findById(requestBody.key());

    if (notification.isEmpty())
      throw new ApplicationException("Notificação não encontrada", HttpStatus.NOT_FOUND);

    notification.get().setSeenAt(requestBody.seenAt());
    notificationRepository.save(notification.get());

    return new GetNotificationResponseDto(notification.get());
  }
}
