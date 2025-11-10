📨 Notification Gateway Microservice

Project Overview

This project is a decoupled Spring Boot Microservice designed to centralize and standardize all external communications (Email, SMS) for an organization. It functions as a single, consistent endpoint for all internal applications, shielding them from the complexities and vendor-specific requirements of third-party APIs like Twilio or SendGrid.

Key Skills Demonstrated

Microservices Architecture: Designed for decoupling, separating the complex notification concern from core business services (e.g., Billing, Inventory).

REST API Design: Exposed a robust, standardized REST API (/api/v1/notify) using a clean Data Transfer Object (DTO) contract.

API Documentation: Integration of Swagger UI for automatic, interactive API specification and testing.

Unit Testing: Implements comprehensive service layer testing using JUnit to ensure reliable routing and logic validation.

Configuration Management: Securely reads and manages external vendor API credentials using Spring's @Value.

🛠️ Technology Stack

Backend: Java 8, Spring Boot 2.7

Messaging: Simulates interaction with external Email/SMS APIs (e.g., SendGrid, Twilio).

Documentation: SpringDoc / Swagger UI

Testing: JUnit 5, Spring Boot Test

Build Tool: Maven

🚀 Getting Started

Prerequisites

Java Development Kit (JDK) 8

Apache Maven 3+

Git

Setup and Running Locally

Clone the Repository:

git clone [YOUR GITHUB URL]
cd notification-gateway


Verify Configuration: The microservice is configured to run on a separate port to avoid conflicts. The external API key is defined for simulation purposes.

Port: server.port=8081

Configuration File: src/main/resources/application.properties

Build and Test the Project:

# Runs the unit tests and compiles the code
mvn clean install


Run the Application:

mvn spring-boot:run


The application will start on the custom port: http://localhost:8081

🧪 Testing and API Access

1. Interactive Documentation (Swagger UI)

Use Swagger UI to visually inspect the API contract and send test requests directly from your browser.

URL: http://localhost:8081/swagger-ui.html

2. REST Endpoint (Standardized Request)

Any internal application sends a simple, standardized request to this endpoint.

Method: POST

Endpoint: http://localhost:8081/api/v1/notify

Content-Type: application/json

Sample Request Body (JSON) for EMAIL:

{
  "recipient": "recipient@company.com",
  "subject": "Invoice Ready: #INV-2024",
  "body": "Your invoice is attached and ready for payment.",
  "type": "EMAIL", 
  "serviceIdentifier": "BILLING_SERVICE" 
}


Sample Request Body (JSON) for SMS:

{
  "recipient": "+15551234567",
  "subject": "SMS Alert",
  "body": "Your account has been updated.",
  "type": "SMS", 
  "serviceIdentifier": "ACCOUNT_SERVICE" 
}


3. Running Unit Tests

To confirm the service logic and routing is correct:

Command: mvn clean test

📄 License

This project is open-source and available under the MIT License.
