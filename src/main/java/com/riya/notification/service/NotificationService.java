// src/main/java/com/riya/notification/service/NotificationService.java
package com.riya.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.riya.notification.model.NotificationRequest;

@Service
public class NotificationService {

	private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

	@Value("${notification.api-key}")
	private String apiKey; // Demonstrates using config properties

	public boolean processNotification(NotificationRequest request) {

		// In a real microservice, this is where you would:
		// 1. Authenticate the request using the apiKey (or better, OAuth)
		// 2. Log the request to a persistent store (DB)
		// 3. Place the request onto a reliable internal queue (e.g., Kafka)

		log.info("Processing notification of type {} for recipient: {}", request.getType(), request.getRecipient());

		try {
			switch (request.getType().toUpperCase()) {
			case "EMAIL":
				// Simulate calling an external Email API
				sendEmail(request);
				break;
			case "SMS":
				// Simulate calling an external SMS API
				sendSms(request);
				break;
			default:
				log.error("Unsupported notification type: {}", request.getType());
				return false;
			}
			return true;
		} catch (Exception e) {
			log.error("Error during notification processing: {}", e.getMessage());
			return false;
		}
	}

	private void sendEmail(NotificationRequest request) {
		log.info("--- External Email API called successfully ---");
		log.info("Subject: {} | Body length: {}", request.getSubject(), request.getBody().length());
	}

	private void sendSms(NotificationRequest request) {
		log.info("--- External SMS API called successfully ---");
		log.info("Recipient: {} | Message: {}", request.getRecipient(), request.getBody());
	}
}