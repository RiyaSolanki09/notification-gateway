package com.riya.notification.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.riya.notification.model.NotificationRequest;

// Load the application context and specify a dummy API key for testing
@SpringBootTest
@TestPropertySource(properties = { "notification.api-key=test-key-007" })
public class NotificationServiceTest {

	@Autowired
	private NotificationService notificationService;

	// Test case 1: Successful EMAIL notification processing
	@Test
	void testProcessNotification_EmailSuccess() {
		NotificationRequest request = new NotificationRequest();
		request.setRecipient("test@example.com");
		request.setBody("Email test body");
		request.setType("EMAIL");

		boolean result = notificationService.processNotification(request);

		// Assert that the service returned true for success
		assertTrue(result, "Should return true for a valid EMAIL request.");
	}

	// Test case 2: Successful SMS notification processing
	@Test
	void testProcessNotification_SmsSuccess() {
		NotificationRequest request = new NotificationRequest();
		request.setRecipient("+1234567890");
		request.setBody("SMS test message");
		request.setType("SMS");

		boolean result = notificationService.processNotification(request);

		// Assert that the service returned true for success
		assertTrue(result, "Should return true for a valid SMS request.");
	}

	// Test case 3: Handling an unsupported notification type
	@Test
	void testProcessNotification_UnsupportedType() {
		NotificationRequest request = new NotificationRequest();
		request.setRecipient("unknown@example.com");
		request.setBody("Bad request");
		request.setType("FAX"); // Invalid type

		boolean result = notificationService.processNotification(request);

		// Assert that the service correctly returns false for an unsupported type
		assertFalse(result, "Should return false for an unsupported notification type (e.g., FAX).");
	}
}