// src/main/java/com/riya/notification/controller/NotificationController.java
package com.riya.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riya.notification.model.NotificationRequest;
import com.riya.notification.service.NotificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/notify")
@Tag(name = "Notification Gateway", description = "Standardized API for sending emails and SMS messages.")
public class NotificationController {

	private final NotificationService notificationService;

	@Autowired
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Operation(summary = "Submits a notification request for processing (Email/SMS).")
	@PostMapping
	public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {

		// Basic validation
		if (request.getRecipient() == null || request.getBody() == null || request.getType() == null) {
			return new ResponseEntity<>("Missing required fields (recipient, body, type).", HttpStatus.BAD_REQUEST);
		}

		boolean success = notificationService.processNotification(request);

		if (success) {
			return new ResponseEntity<>("Notification request accepted and queued.", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Notification processing failed.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}