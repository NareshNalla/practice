# Web Services - Interview Notes

## 1. SOAP vs. REST

### What is the difference between SOAP and REST?

| Feature | SOAP (Simple Object Access Protocol) | REST (REpresentational State Transfer) |
| :--- | :--- | :--- |
| **Type** | A standardized **protocol**. | An **architectural style**, not a protocol. |
| **Data Format** | Strictly permits **XML** only. | Flexible. Permits various formats like **JSON**, XML, HTML, plain text, etc. JSON is the most popular. |
| **Transport** | Can use any transport protocol (HTTP, SMTP, etc.). | Almost always uses **HTTP/HTTPS**. |
| **Standards** | Very strict standards (e.g., WSDL for service definition, built-in error handling). | No strict standards, relies on HTTP standards. It's more of a set of guiding principles. |
| **Security** | Has its own comprehensive security standard: **WS-Security**. | Inherits security from the underlying transport (HTTPS). |
| **Performance** | Requires more bandwidth due to verbose XML. | More performant and requires less bandwidth, especially with JSON. |
| **API** | The Java API is **JAX-WS**. | The Java API is **JAX-RS**. |
| **Paradigm** | Exposes **operations** or functions (RPC style). | Exposes **resources** that are acted upon by HTTP methods. |

### When to use SOAP vs. REST?
- **Use REST for:** Public APIs, mobile apps, and when performance and scalability are critical.
- **Use SOAP for:** Enterprise applications requiring advanced security (WS-Security), guaranteed reliability, or ACID transactions.

---

## 2. REST Concepts

### What does REST stand for?
- **RE**presentational **S**tate **T**ransfer.
    - **Representational:** How data is formatted (e.g., JSON).
    - **State:** The data of a resource.
    - **Transfer:** How that data is communicated (via HTTP).

### Why are REST APIs stateless?
- **Statelessness** is a core constraint of REST.
- It means that **each request must contain all the information necessary** for the server to process it.
- The server does not store any session state or context about the client between requests.
- **Benefit:** This simplifies server design, improves scalability (any server can handle any request), and enhances reliability.

### What are the standard HTTP Methods used in REST?
REST maps CRUD (Create, Read, Update, Delete) operations to HTTP methods:

- **`GET` (Read):** Retrieves a resource. It is safe and idempotent.
- **`POST` (Create):** Creates a new resource. It is not idempotent.
- **`PUT` (Update/Replace):** Replaces an existing resource entirely. It is idempotent.
- **`PATCH` (Partial Update):** Applies a partial modification to a resource. It is not guaranteed to be idempotent.
- **`DELETE` (Delete):** Removes a resource. It is idempotent.
- **`OPTIONS`:** Used to get the supported operations on a resource.

### HTTP Methods Comparison: PUT, PATCH, and POST

| Feature | `POST` (Create) | `PUT` (Full Update/Replace) | `PATCH` (Partial Update) |
| :--- | :--- | :--- | :--- |
| **Purpose** | Creates a new resource. | Replaces an entire resource with the complete updated state. | Applies a partial modification to a resource (only specified fields). |
| **Data Submission** | Submits data to be processed by the server. | Sends the complete, updated state of the entire resource. | Sends only the specific fields that need to be changed. |
| **Data Location** | Data is sent in the request body. | Data is sent in the request body. | Data is sent in the request body. |
| **Idempotency** | **Not idempotent.** Sending the same POST request multiple times creates multiple resources. | **Idempotent.** Making the same PUT request multiple times results in the same final state. | **Not inherently idempotent.** A PATCH to increment a value produces different results if sent multiple times. |
| **Bandwidth** | Moderate; only new data sent. | High; entire object must be sent. | Low; only changed fields sent (most network-efficient). |
| **Use Case** | Creating new resources (e.g., POST /users to create a new user). | Replacing entire resources where client has full state (e.g., PUT /users/123 with complete user object). | Updating specific fields without sending entire object (e.g., PATCH /users/123 to update only the email field). |
| **Server Response** | Typically returns `201 Created` with the new resource. | Typically returns `200 OK` with updated resource. | Typically returns `200 OK` with updated resource. |
| **Security** | More secure than GET; data not exposed in URL. | More secure; data not exposed in URL. | More secure; data not exposed in URL. |
| **Resource State** | Server determines the final state of the new resource. | Client determines the complete final state of the resource. | Client determines which specific fields to update; server merges with existing data. |

### What is HATEOAS?
- **HATEOAS** stands for **Hypermedia as the Engine of Application State**.
- It's a principle that a REST client should be able to navigate an application by following hyperlinks provided in the API's responses.
- The server's response for a resource should contain links to other related actions or resources (e.g., a response for a user might include a link to "view-orders").
- **Benefit:** This decouples the client from the server, as the client doesn't need to hardcode API URIs.

---

## 3. Inter-Service Communication Strategies

### Overview
In microservices architectures, services need to communicate with each other. There are multiple patterns, each with different trade-offs in terms of performance, resilience, and complexity.

### REST (Synchronous Communication)
- **What:** The standard choice for service-to-service communication. Services communicate via HTTP/HTTPS REST APIs.
- **Pros:**
  - Simple, familiar, and widely understood.
  - Easy to implement with standard tools and libraries.
  - Good for request-response patterns where immediate feedback is needed.
- **Cons:**
  - Can lead to a **"Distributed Monolith"** if not managed carefully — tight coupling and cascading failures.
  - If Service A calls Service B which calls Service C, a failure in C cascades back to A.
  - **Solution:** Use **Circuit Breakers** (Hystrix, Resilience4j) to detect failures and prevent cascading.
- **Best For:** Simple point-to-point communication, when immediate response is critical.

### gRPC (High-Performance Synchronous Communication)
- **What:** A modern RPC framework developed by Google. Uses **HTTP/2** for transport and **Protocol Buffers** for serialization.
- **Pros:**
  - **Much faster than REST/JSON:** Binary protocol (Protobuf) vs text-based JSON.
  - **Low latency:** Multiplexing requests over a single connection.
  - **Strongly typed:** Schema is explicitly defined, reducing errors.
  - **Excellent for internal microservice communication** where performance is critical.
- **Cons:**
  - Not as easy to debug (binary format).
  - Requires additional tooling and learning curve.
  - Less suitable for public APIs (harder for clients to consume).
- **Best For:** Internal service-to-service communication where performance and low latency are critical.

### Event-Driven (Asynchronous Communication)
- **What:** Services communicate by publishing events to a message broker (Kafka, RabbitMQ, AWS SNS/SQS). Other services subscribe and react to those events.
- **Pros:**
  - **Loose coupling:** Services don't need to know about each other; they only know about the event format.
  - **Resilience:** If a subscriber is temporarily down, events are stored and processed later.
  - **Eventual consistency:** Acknowledges that distributed systems can't guarantee immediate consistency.
  - **Highly recommended for senior developers:** Ensures system resilience, scalability, and fault tolerance.
- **Cons:**
  - More complex to implement and reason about.
  - Eventual consistency means data is not immediately consistent across all services.
  - Harder to debug and trace request flows.
- **Message Brokers:**
  - **Kafka:** High throughput, persistent, immutable log. Best for event streaming and real-time analytics.
  - **RabbitMQ:** Message queuing with flexible routing. Good for traditional pub-sub patterns.
  - **AWS SNS/SQS:** Managed services in AWS. SNS for pub-sub, SQS for queues.
  - **Google Cloud Pub/Sub:** Fully managed messaging service in Google Cloud. Scales automatically, supports global message ordering, and integrates well with other GCP services. Good for building decoupled, scalable systems on Google Cloud.
- **Best For:** Decoupling services, handling spiky loads, audit trails, eventual consistency scenarios (order processing, user notifications).

### Comparison Table

| Strategy | Latency | Coupling | Resilience | Consistency | Complexity |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **REST** | Low (direct call) | Tight | Low (cascading failures) | Immediate | Low |
| **gRPC** | Very Low | Tight | Low (needs circuit breaker) | Immediate | Medium |
| **Event-Driven (Kafka)** | Medium (asynchronous) | Loose | High | Eventual | High |
| **Event-Driven (RabbitMQ)** | Medium (asynchronous) | Loose | High | Eventual | Medium |
| **Event-Driven (Google Pub/Sub)** | Medium (asynchronous) | Loose | High | Eventual | Low-Medium |
| **Event-Driven (AWS SNS/SQS)** | Medium (asynchronous) | Loose | High | Eventual | Low-Medium |

### When to Use Which?
- **Use REST:** When you need immediate synchronous responses and the services are tightly related.
- **Use gRPC:** For internal service-to-service communication where performance and low latency are critical (e.g., between microservices in the same data center).
- **Use Event-Driven:** For decoupled services, event notifications, audit trails, and scenarios requiring eventual consistency. **Highly recommended** for robust, scalable systems.

---

## 4. Web & Network Concepts

### What is the difference between HTTP and HTTPS?
- **HTTP (Hypertext Transfer Protocol):** The standard protocol for web data exchange. It is **unencrypted**.
- **HTTPS (HTTP Secure):** This is HTTP with an added security layer. It uses **SSL/TLS** to encrypt the communication, ensuring confidentiality, integrity, and authentication.

### What is a Proxy Server?
- An intermediary server that sits between a client and another server.
- **Common Uses:** Caching content, filtering requests, and hiding the client's IP address for anonymity.

### Explain Client-Server Architecture
- A distributed application structure that partitions tasks between **servers** (providers of a resource) and **clients** (requesters of a resource).
- The client initiates a request, and the server processes it and returns a response. This is the foundational model of the web.

---

## 5. XML Parsing

### What is a SAX parser?
- **SAX** stands for **Simple API for XML**.
- It is an **event-based** parser. It reads an XML document sequentially and triggers "events" (e.g., `startElement`, `endElement`) as it encounters different parts of the document.
- It does **not** load the entire document into memory, making it very memory-efficient and ideal for parsing very large XML files.
