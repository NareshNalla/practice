# Spring Boot & Core Spring Concepts - Complete Interview Guide

## 1. What is Spring Boot and what are its main advantages?

"Spring Boot is an **opinionated** extension of the Spring framework that makes it incredibly easy to create standalone, production-grade applications. 
Essentially, it eliminates most of the boilerplate configuration and setup, so you can just focus on writing business logic."

### Key Advantages:

**1. Auto-Configuration:** This is the core feature. Spring Boot automatically configures your application based on the JAR dependencies on your classpath. For example, if it sees `spring-boot-starter-web`, it auto-configures Tomcat and Spring MVC.

*   **2. Starter Dependencies (Starters):** These are convenient dependency descriptors that bundle all necessary libraries for a specific feature. Instead of manually managing versions for dozens of JARs, you just include one "starter" like `spring-boot-starter-data-jpa`.

*   **3. Embedded Server:** Spring Boot includes an embedded server (like Tomcat) by default, so you can run your application as a standalone JAR file (`java -jar myapp.jar`) without needing to deploy a WAR file.

*   **4. Actuator:** Provides production-ready features like health checks, metrics, and monitoring endpoints right out of the box.

*   **5. Simplified Logging:** Provides a pre-configured, sensible logging setup using Logback by default. It allows for easy configuration of logging levels for different parts of the application in the `application.properties` file without needing a separate logging configuration file.

*   **6. Integrated Security:** If `spring-boot-starter-security` is on the classpath, Spring Boot provides a default security configuration "out of the box," including a login page and protection against common vulnerabilities. This default can be easily customized or replaced.

---
### Q: "You said Spring Boot is 'opinionated'. What does that mean?"

**The Smart, Concise Answer:**

"Right, so 'opinionated' simply means that the Spring Boot team has already made a lot of common-sense decisions for you. Instead of asking the developer to choose from hundreds of configuration options, Spring Boot comes with a pre-packaged set of 'best practice' defaults. For example, it has the *opinion* that Tomcat is a good embedded server and Logback is a good choice for logging. You don't have to configure any of it; it just works out of the box."

---

## 2. Core Spring Concepts

### What are the main modules of the Spring Framework?
- **Core Container:** Provides the fundamental functionality, including the IoC container.
- **Spring MVC:** For building web applications.
- **Spring Data JPA:** Simplifies implementing JPA-based repositories by providing CRUD implementations at runtime from a `Repository` (`Interface`).
- **Spring Security:** A framework for handling authentication and authorization.
- **Spring AOP:** Allows you to manage cross-cutting concerns (like logging and transactions) in a clean way.
- **Spring Test:** Provides support for unit and integration testing of Spring components.

### What is the Spring IoC Container?
- The container is the core of the Spring Framework. Its job is to create, configure, and manage the lifecycle of objects (beans).
- **Implementations & Hierarchy:**
    1.  **`BeanFactory` (`Interface`):** The most basic container.
    2.  **`ApplicationContext` (`Interface`):** A superset of `BeanFactory` with more enterprise features.
    3.  **`ConfigurableApplicationContext` (`Interface`):** The "admin" interface used by the framework to manage the container's lifecycle (e.g., with `refresh()` and `close()`).

---

## 3. Dependency Injection (DI) & Bean Lifecycle

### What is Dependency Injection?
- **Concept:** A design pattern where an object's dependencies are "injected" into it by an external container.
- **Benefit:** This leads to **loose coupling**, making code more modular and easier to test.

### Explain the Spring Bean Lifecycle

1.  **Instantiation:** The container creates an instance of the bean.
2.  **Populate Properties:** The container performs dependency injection.
3.  **Aware Interfaces:** Methods on `Aware` (`Interfaces`) like `setBeanName()` and `setApplicationContext()` are called to provide the bean with information about its environment.
4.  **BeanPostProcessors (Before Initialization):** The `postProcessBeforeInitialization` method of any registered `BeanPostProcessor` (`Interface`) is called.
5.  **Initialization Callbacks:** The container calls the bean's initialization method. You can define this in one of two ways (in order of execution):
    *   A method annotated with **`@PostConstruct`**. This is the modern, preferred approach.
    *   The `afterPropertiesSet()` method if the bean implements the `InitializingBean` (`Interface`).
6.  **BeanPostProcessors (After Initialization):** The `postProcessAfterInitialization` method is called. This is where Spring often wraps the bean in a proxy to apply AOP logic.
7.  **Bean is Ready:** The bean is now fully initialized and ready to be used.
8.  **Destruction Callbacks:** When the container is closed, the bean's destruction method is called. You can define this in one of two ways:
    *   A method annotated with **`@PreDestroy`**. This is the modern, preferred approach.
    *   The `destroy()` method if the bean implements the `DisposableBean` (`Interface`).

---
### How does a spring application get started?

A Spring application gets started by calling the main() method with @SpringBootApplication annotation in the SpringApplication class. This method takes a SpringApplicationBuilder object as a parameter, which is used to configure the application.

Once the SpringApplication object is created, the run() method is called.
Once the application context is initialized, the run() method starts the application's embedded web server.

**Spring Boot Annotations**

@SpringBootApplication
@Configuration, @EnableAutoConfiguration, and @ComponentScan
@RestController
@RequestMapping
@EnableAutoConfiguration(exclude = {//classname})
@Bean annotations to define beans and their dependencies.
@Controller : Marks the class as a request handler in the Spring MVC framework.
@ResponseBody : Tells Spring to convert method return values (objects, data) directly into HTTP responses instead of rendering views.

## 4. Spring MVC & Web Architecture

### What is the MVC Design Pattern?
- **MVC** stands for **Model-View-Controller**. It's an architectural pattern that separates an application into three parts: the data (Model), the UI (View), and the control logic (Controller).

### How does Spring MVC work?
- The `DispatcherServlet` (`Class`) acts as the central "Front Controller". It receives a request, consults a `HandlerMapping` (`Interface`) to find the correct `@Controller`, which then processes the request and returns a view name. A `ViewResolver` (`Interface`) then maps this name to the actual View template to render the final response.

---
How do you pass data from the controller to the view?
For REST APIs, you typically return a Java object from a @RestController method. Spring, using libraries like Jackson, automatically serializes this object into a JSON response. The @ResponseBody annotation is key here.
Servlet Lifecycle & Concepts
Can you instantiate a servlet with a constructor? No. The servlet container (e.g., Tomcat) is responsible for creating servlet instances. It calls the public, no-arg constructor via reflection. Configuration is passed via the init() method.
ServletContext vs. ServletConfig:
ServletContext: An object created by the container for the entire web application. It's shared among all servlets. Used for application-scope parameters.
ServletConfig: An object created by the container for a specific servlet. It's used to pass initialization parameters unique to that servlet.
Session Tracking without Cookies: If cookies are disabled, you can use URL Rewriting. The session ID is appended to every URL. The response.encodeURL("test.jsp") method does this automatically.
JSP (JavaServer Pages)
How to include another JSP? Use the <jsp:include> action tag. This is a dynamic include that happens at request time.
Can you include static content? Yes, using the <%@ include file="..." %> directive. This is a static include that happens at translation time (when the JSP is converted into a servlet).
---
What is SOA (Service-Oriented Architecture)?
SOA is an architectural style for building distributed systems where functionality is grouped into distinct, reusable units of business logic called services.
Key Principles:
Loose Coupling: Services are independent and don't need to know the technical details of other services.
Standardized Contract: Services communicate through a well-defined, formal contract (often using WSDL for SOAP-based services).
Discoverability: Services can be discovered through a central registry.
Note: While often associated with SOAP and XML, the principles of SOA are still relevant. Microservices can be seen as a more modern, fine-grained evolution of the SOA style.
---
What is MVP?
MVP stands for Model-View-Presenter. It's a variation of MVC.
Key Difference: In MVP, the Presenter is more involved than a Controller. It directly manipulates the View through an interface, and the View is typically more "dumb." The Presenter fetches data from the Model and tells the View exactly what to display. This creates a stronger separation and makes testing easier.
MVC vs. MVP: In MVC, the View often pulls data from the Model. In MVP, the Presenter pushes data to the View.
---
## 5. Java EE & Enterprise Integration

### Application Server vs. Servlet Container
- **Servlet Container (e.g., Tomcat):** Implements only the web-related parts of the Java EE specification (e.g., `Servlet` (`Interface`)). Spring Boot embeds Tomcat by default.
- **Application Server (e.g., JBoss):** A full implementation of the entire Java EE specification, including JMS, EJB, etc.

### What is JMS (Java Message Service)?
- **JMS** is a Java API for **asynchronous messaging**.
- **Messaging Models:**
    1.  **Point-to-Point (Queue):** One message is consumed by exactly one consumer.
    2.  **Publish/Subscribe (Topic):** A message is delivered to all consumers subscribed to the topic.

---

## 6. Spring Boot Actuator

### What is Spring Boot Actuator?
- A sub-project of Spring Boot that provides production-ready features for **monitoring and managing** a running application by exposing operational endpoints.

### Common Actuator Endpoints
- **`/actuator/health`:** Shows application health status ("UP" or "DOWN").
- **`/actuator/info`:** Displays custom application information. You can add custom data to this endpoint by creating a bean that implements the **`InfoContributor` (`Functional Interface`)**.
- **`/actuator/metrics`:** Shows a wide range of metrics (JVM memory, HTTP requests, etc.).
- **`/actuator/loggers`:** Allows viewing and modifying application log levels at runtime.

### How do you configure a different port for Actuator endpoints?

**The Smart, Concise Answer:**

"You do this in the `application.properties` file. You set the `management.server.port` property to a different port number. This is a critical security practice to expose the management endpoints on a separate, non-public port that can be firewalled."

**The Deeper, Interview-Level Explanation:**

*   **Why do this?** Exposing sensitive management endpoints like `/actuator/loggers` or `/actuator/heapdump` on the same public port as your application is a major security risk. The best practice is to run the actuator on a separate port that is only accessible from an internal network or by trusted operational staff.
*   **How to configure:**
    In your `application.properties` or `application.yml` file:
    ```properties
    # Main application port
    server.port=8080

    # Separate port for management/actuator endpoints
    management.server.port=9091
    ```
*   **Result:** Your main application will be available at `http://localhost:8080`, while the actuator endpoints will only be available at `http://localhost:9091/actuator`. This allows you to set up firewall rules to block external access to port 9091, securing your management endpoints.
