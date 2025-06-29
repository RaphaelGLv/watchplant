package com.watchplant.app.controllers;

import com.watchplant.app.dtos.notification.GetAllNotificationsResponseDTO;
import com.watchplant.app.dtos.notification.GetNotificationResponseDto;
import com.watchplant.app.dtos.notification.PatchNotificationSeenRequestDto;
import com.watchplant.app.services.NotificationService;
import com.watchplant.app.utils.UserContext;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/seen")
    GetNotificationResponseDto patchNotificationSeen(@RequestBody PatchNotificationSeenRequestDto requestBody) {
        return notificationService.patchNotificationSeen(requestBody);
    }
}
