package com.watchplant.app.controllers;

import com.watchplant.app.dtos.notification.GetAllNotificationsResponseDTO;
import com.watchplant.app.services.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
class NotificationController {
    private final NotificationService notificationService;

    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/new")
    GetAllNotificationsResponseDTO getNewNotifications() {
        notificationService.updateNotifications();
        return notificationService.getAllNotifications();
    }
}
