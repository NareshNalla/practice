# Spring Boot: Interview Summary

This document consolidates key Spring Boot concepts for quick interview preparation.

===================================================================================
## 1. Core Spring Boot Concepts
===================================================================================

### Q: "What is Spring Boot and what are its main advantages?"

**The Smart, Concise Answer:**

"Spring Boot is an **opinionated** extension of the Spring framework that makes it incredibly easy to create standalone, production-grade applications. Its main advantages are **auto-configuration**, **starter dependencies**, and an **embedded server**. Essentially, it eliminates most of the boilerplate configuration and setup, so you can just focus on writing business logic."

**The Deeper, Interview-Level Explanation:**

*   **1. Auto-Configuration:** This is the core feature. Spring Boot automatically configures your application based on the JAR dependencies on your classpath. For example, if it sees `spring-boot-starter-web`, it auto-configures Tomcat and Spring MVC.

*   **2. Starter Dependencies (Starters):** These are convenient dependency descriptors that bundle all necessary libraries for a specific feature. Instead of manually managing versions for dozens of JARs, you just include one "starter" like `spring-boot-starter-data-jpa`.

*   **3. Embedded Server:** Spring Boot includes an embedded server (like Tomcat) by default, so you can run your application as a standalone JAR file (`java -jar myapp.jar`) without needing to deploy a WAR file.

*   **4. Actuator:** Provides production-ready features like health checks, metrics, and monitoring endpoints right out of the box.

*   **5. Simplified Logging:** Provides a pre-configured, sensible logging setup using Logback by default. It allows for easy configuration of logging levels for different parts of the application in the `application.properties` file without needing a separate logging configuration file.

*   **6. Integrated Security:** If `spring-boot-starter-security` is on the classpath, Spring Boot provides a default security configuration "out of the box," including a login page and protection against common vulnerabilities. This default can be easily customized or replaced.

---

### Q: "You said Spring Boot is 'opinionated'. What does that mean?"

**The Smart, Concise Answer:**

"Right, so 'opinionated' simply means that the Spring Boot team has already made a lot of common-sense decisions for you. Instead of asking the developer to choose from hundreds of configuration options, Spring Boot comes with a pre-packaged set of 'best practice' defaults. For example, it has the *opinion* that Tomcat is a good embedded server and Logback is a good choice for logging. You don't have to configure any of it; it just works out of the box."

**The Deeper, Interview-Level Explanation:**

*   **The Problem Spring Boot Solves (Convention over Configuration):** The original Spring Framework was very flexible, but this required a lot of manual XML or Java configuration. Spring Boot solves this by following the principle of **"Convention over Configuration."**
*   **How it Works:** It makes assumptions about what a typical application needs. When you add `spring-boot-starter-web`, it doesn't ask you which server or JSON library to use; it provides Tomcat and Jackson by default because that is the common convention.
*   **The Trade-off (Flexibility vs. Simplicity):** The "opinionated" approach trades some initial flexibility for a massive gain in simplicity and development speed. However, Spring Boot is still flexible enough to let you **override** any of its default opinions if your project has specific needs.

---
===================================================================================
## 2. Spring Bean Lifecycle
===================================================================================

### Q: "Explain the Spring Bean Lifecycle."

**The Smart, Concise Answer:**

"The Spring Bean Lifecycle describes how the IoC container creates, configures, and destroys a bean. The main phases are: **Instantiation** (creating the object), **Population** (injecting dependencies), **Initialization** (calling custom init methods), and finally **Destruction** (calling custom destroy methods when the container shuts down)."

**The Deeper, Interview-Level Explanation:**

An interviewer wants to see that you know the key "callback" points where you can hook into this process.

1.  **Instantiation:** The container creates an instance of the bean.
2.  **Populate Properties:** The container performs dependency injection.
3.  **Aware Interfaces:** Methods like `setBeanName()` and `setApplicationContext()` are called.
4.  **BeanPostProcessors (Before Initialization):** The `postProcessBeforeInitialization` method is called.
5.  **Initialization Callbacks:**
    *   A method annotated with **`@PostConstruct`** is called (preferred).
    *   The `afterPropertiesSet()` method is called if the bean implements `InitializingBean`.
6.  **BeanPostProcessors (After Initialization):** The `postProcessAfterInitialization` method is called. This is where proxies for AOP are often applied.
7.  **Bean is Ready:** The bean is now fully initialized and ready for use.
8.  **Destruction Callbacks:** When the container is closed:
    *   A method annotated with **`@PreDestroy`** is called (preferred).
    *   The `destroy()` method is called if the bean implements `DisposableBean`.

---
===================================================================================
## 3. Spring Boot Actuator
===================================================================================

### What is Spring Boot Actuator?
- A sub-project of Spring Boot that provides production-ready features for **monitoring and managing** a running application.
- It exposes a set of operational endpoints over HTTP or JMX.

### Common Actuator Endpoints
- **`/actuator/health`:** Shows application health status (e.g., "UP" or "DOWN"). Can be configured to include details about database connections, disk space, etc.
- **`/actuator/info`:** Displays arbitrary application information defined by the developer.
- **`/actuator/metrics`:** Shows a wide range of application metrics (e.g., JVM memory usage, HTTP request counts, system CPU usage).
- **`/actuator/loggers`:** Allows viewing and modifying application log levels at runtime, which is extremely useful for debugging production issues without restarting the application.
