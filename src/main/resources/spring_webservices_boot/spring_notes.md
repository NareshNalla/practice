# Spring Framework & Java EE - Interview Notes

## 1. Core Spring Concepts

### Why use the Spring Framework?
- **Core Purpose:** Spring's main goal is to simplify Java EE development. It provides a comprehensive programming and configuration model that makes applications easier to build, test, and manage.
- **Inversion of Control (IoC) / Dependency Injection (DI):** This is the heart of Spring. Instead of objects creating their own dependencies, the Spring IoC container creates the objects, wires them together, and manages their complete lifecycle. This leads to loosely coupled and more testable code.
- **Ecosystem:** Spring is not just one thing; it's a huge ecosystem. It provides solutions for almost any problem a modern application might face:
    - **Spring Boot:** Radically simplifies building production-ready Spring applications.
    - **Spring MVC:** For building web applications.
    - **Spring Data:** Simplifies database access.
    - **Spring Security:** For authentication and authorization.
    - **Spring AOP:** For handling cross-cutting concerns.

### What are the main modules of the Spring Framework?
The Spring Framework is modular. Some of the most important modules are:
- **Core Container:** Provides the fundamental functionality, including the `BeanFactory` and `ApplicationContext` (the IoC container).
- **Data Access / Integration:** Modules for working with databases (JDBC, ORM, transactions).
- **Web:** Contains the Web, Web-MVC, and WebSocket modules for building web applications.
- **AOP (Aspect-Oriented Programming):** Allows you to define cross-cutting concerns (like logging or security) in a clean way.
- **Test:** Provides support for unit and integration testing of Spring components.

### What is the Spring IoC Container?
- The container is the core of the Spring Framework.
- **Its job:** To create objects (called "beans"), configure them, manage their dependencies, and handle their entire lifecycle from creation to destruction.
- **Implementations:** The two main implementations are:
    1.  **`BeanFactory`:** The most basic container.
    2.  **`ApplicationContext`:** The more advanced container. It's a superset of `BeanFactory` and provides more enterprise-specific features like event propagation and integration with Spring's AOP features. In almost all applications, you will use `ApplicationContext`.

### How do you define a bean?
- A bean is simply an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
- **Configuration:** Beans are defined in a configuration source, which can be:
    - **Annotation-based (Modern):** Using annotations like `@Component`, `@Service`, `@Repository`, or `@Configuration` on a Java class.
    - **XML-based (Legacy):** Using the `<bean>` tag in an XML configuration file.

---

## 2. Dependency Injection (DI)

### What is Dependency Injection?
- **Concept:** A design pattern where an object does not create its own dependencies. Instead, the dependencies (the other objects it needs to work with) are "injected" into it by an external entity (the Spring IoC container).
- **Benefit:** This "inverts" the normal control flow, which is why it's called **Inversion of Control (IoC)**. The primary benefit is **loose coupling**. The component doesn't need to know how to construct its dependencies, making the code much easier to test (you can inject mock objects) and maintain.

### What are the types of Dependency Injection?
Spring primarily supports two recommended types of DI:

1.  **Constructor-Based DI:**
    - **How:** The container invokes a class constructor, passing the dependencies as arguments.
    - **Use Case:** Best for **mandatory dependencies**. It ensures the object is in a valid state as soon as it's created.
    - **XML Configuration:** Use the `<constructor-arg>` element. If there are multiple constructors, you can use the `index` or `type` attribute to resolve ambiguity.

2.  **Setter-Based DI:**
    - **How:** The container calls a no-argument constructor and then calls setter methods to inject the dependencies.
    - **Use Case:** Best for **optional dependencies**.
    - **XML Configuration:** Use the `<property>` element.

- **Field-Based DI** (`@Autowired` on a field) is also possible but generally discouraged as it makes testing harder.

### Spring Annotations for DI
- **`@Autowired`:** Spring's primary annotation for DI. It can be used on constructors, setters, or fields. It injects a bean by matching the data type.
- **`@Required`:** A legacy annotation that indicates a bean property must be populated at configuration time (e.g., through a setter).

---

## 3. Spring MVC & Java EE Web Tier

### What is the MVC Design Pattern?
- **MVC** stands for **Model-View-Controller**. It's an architectural pattern that separates an application into three interconnected components.
- **1. Model:** Represents the data and business logic.
- **2. View:** The user interface (UI) that displays the data (e.g., an HTML page, a JSON response).
- **3. Controller:** Handles user input, interacts with the Model, and selects a View to render.

### How does Spring MVC work?
- In Spring MVC, the `DispatcherServlet` acts as the central "Front Controller".
- **Flow:**
    1.  A user request hits the `DispatcherServlet`.
    2.  The `DispatcherServlet` consults the `HandlerMapping` to find the appropriate `@Controller` method.
    3.  The Controller method executes, calls business services (the **Model**), and returns a logical view name and model data.
    4.  The `DispatcherServlet` uses a `ViewResolver` to find the actual **View** (e.g., a JSP).
    5.  The `DispatcherServlet` renders the View with the model data and returns the response.

### How do you pass data from the controller to the view?
- For REST APIs, you typically return a Java object from a `@RestController` method. Spring, using libraries like Jackson, automatically serializes this object into a **JSON** response. The `@ResponseBody` annotation is key here.

### Servlet Lifecycle & Concepts
- **Can you instantiate a servlet with a constructor?** No. The servlet container (e.g., Tomcat) is responsible for creating servlet instances. It calls the public, no-arg constructor via reflection. Configuration is passed via the `init()` method.
- **`ServletContext` vs. `ServletConfig`:**
    - **`ServletContext`:** An object created by the container for the *entire web application*. It's shared among all servlets. Used for application-scope parameters.
    - **`ServletConfig`:** An object created by the container for *a specific servlet*. It's used to pass initialization parameters unique to that servlet.
- **Session Tracking without Cookies:** If cookies are disabled, you can use **URL Rewriting**. The session ID is appended to every URL. The `response.encodeURL("test.jsp")` method does this automatically.

### JSP (JavaServer Pages)
- **How to include another JSP?** Use the `<jsp:include>` action tag. This is a dynamic include that happens at request time.
- **Can you include static content?** Yes, using the `<%@ include file="..." %>` directive. This is a static include that happens at translation time (when the JSP is converted into a servlet).

---

## 4. Enterprise & Integration Concepts

### Java EE (Jakarta EE) vs. Spring
- **Java EE (now Jakarta EE):** A set of **specifications** (like JPA, JMS, Servlets). It defines the "what" (the APIs), but not the "how".
- **Application Servers (JBoss, WebSphere):** These are the **implementations** of the Java EE specifications.
- **Spring:** A comprehensive **framework** that was created to simplify Java EE development. It often uses Java EE specifications (like Servlets via Tomcat) but provides its own easier-to-use abstractions and implementations on top. With Spring Boot, it has become a de-facto standard for building standalone Java applications.

### Application Server vs. Servlet Container
- **Servlet Container (e.g., Tomcat, Jetty):** Implements only the web-related parts of the Java EE specification, primarily the Servlet and JSP APIs. It's designed to serve web content. Spring Boot applications often embed a servlet container like Tomcat.
- **Application Server (e.g., JBoss/WildFly, WebSphere, GlassFish):** A full implementation of the entire Java EE specification. It includes a servlet container but also provides many other enterprise services like EJB (Enterprise JavaBeans), JMS messaging, transaction management, etc.

### What is JMS (Java Message Service)?
- **JMS** is a Java API for **asynchronous messaging**. It allows different components of a distributed application to communicate without being directly connected.
- **Core Concepts:**
    - **Producer:** The application that sends a message.
    - **Consumer:** The application that receives the message.
    - **Message Broker:** The intermediary software that manages the queues/topics (e.g., ActiveMQ, RabbitMQ).
- **Messaging Models:**
    1.  **Point-to-Point (Queue):** A message is sent to a queue and is consumed by **exactly one** consumer. It's like a to-do list for a single worker.
    2.  **Publish/Subscribe (Topic):** A message is published to a topic and is delivered to **all** consumers that are subscribed to that topic. It's like a broadcast announcement.

### What is SOA (Service-Oriented Architecture)?
- **SOA** is an architectural style for building distributed systems where functionality is grouped into distinct, reusable units of business logic called **services**.
- **Key Principles:**
    - **Loose Coupling:** Services are independent and don't need to know the technical details of other services.
    - **Standardized Contract:** Services communicate through a well-defined, formal contract (often using WSDL for SOAP-based services).
    - **Discoverability:** Services can be discovered through a central registry.
- **Note:** While often associated with SOAP and XML, the principles of SOA are still relevant. Microservices can be seen as a more modern, fine-grained evolution of the SOA style.

---

## 5. Other Design Patterns

### What is MVP?
- **MVP** stands for **Model-View-Presenter**. It's a variation of MVC.
- **Key Difference:** In MVP, the **Presenter** is more involved than a Controller. It directly manipulates the View through an interface, and the View is typically more "dumb." The Presenter fetches data from the Model and tells the View exactly what to display. This creates a stronger separation and makes testing easier.
- **MVC vs. MVP:** In MVC, the View often pulls data from the Model. In MVP, the Presenter pushes data to the View.
