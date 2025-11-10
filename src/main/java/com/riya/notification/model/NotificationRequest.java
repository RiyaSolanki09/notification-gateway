// src/main/java/com/riya/notification/model/NotificationRequest.java
package com.riya.notification.model;

import lombok.Data;

@Data // Provided by Lombok: generates getters, setters, toString, etc.
public class NotificationRequest {

	// Required fields for sending a notification
	private String recipient;
	private String subject;
	private String body;
	private String type; // e.g., "EMAIL", "SMS"

	// Optional: Identifier from the calling service (e.g., "FEEDBACK_ALERT")
	private String serviceIdentifier;
}