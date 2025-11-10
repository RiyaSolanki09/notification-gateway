# 📨 Notification Gateway Microservice

## Project Overview

This project is a decoupled **Spring Boot Microservice** designed to centralize and standardize all external communications (Email, SMS) for an organization. It functions as a single, consistent endpoint for all internal applications, shielding them from the complexities and vendor-specific requirements of third-party APIs like Twilio or SendGrid.

### Key Skills Demonstrated

* **Microservices Architecture:** Designed for **decoupling**, separating the complex notification concern from core business services (e.g., Billing, Inventory).
* **REST API Design:** Exposed a robust, standardized **REST API** (`/api/v1/notify`) using a clean Data Transfer Object (DTO) contract.
* **API Documentation:** Integration of **Swagger UI** for automatic, interactive API specification and testing.
* **Unit Testing:** Implements comprehensive service layer testing using **JUnit** to ensure reliable routing and logic validation.
* **Configuration Management:** Securely reads and manages external vendor API credentials using Spring's `@Value`.

---

## 🛠️ Technology Stack

* **Backend:** Java 8, Spring Boot 2.7
* **Messaging:** Simulates interaction with external Email/SMS APIs (e.g., SendGrid, Twilio).
* **Documentation:** SpringDoc / Swagger UI
* **Testing:** JUnit 5, Spring Boot Test
* **Build Tool:** Maven

---

## 🚀 Getting Started

### Prerequisites

* Java Development Kit (JDK) 8
* Apache Maven 3+
* Git

### Setup and Running Locally

1.  **Clone the Repository:**
    ```bash
    git clone [YOUR GITHUB URL]
    cd notification-gateway
    ```

2.  **Verify Configuration:** The microservice is configured to run on a separate port to avoid conflicts. The external API key is defined for simulation purposes.
    * **Port:** `server.port=8081`
    * **Configuration File:** `src/main/resources/application.properties`

3.  **Build and Test the Project:**
    ```bash
    # Runs the unit tests and compiles the code
    mvn clean install
    ```

4.  **Run the Application:**
    ```bash
    mvn spring-boot:run
    ```

The application will start on the custom port: `http://localhost:8081`

---

## 🧪 Testing and API Access

### 1. Interactive Documentation (Swagger UI)

Use Swagger UI to visually inspect the API contract and send test requests directly from your browser.

* **URL:** `http://localhost:8081/swagger-ui.html`

### 2. REST Endpoint (Standardized Request)

Any internal application sends a simple, standardized request to this endpoint.

* **Method:** `POST`
* **Endpoint:** `http://localhost:8081/api/v1/notify`
* **Content-Type:** `application/json`

### 3. Running Unit Tests
To confirm the service logic and routing is correct:

* **Command:** `mvn clean test`

## 📄 License
This project is open-source and available under the MIT License.
