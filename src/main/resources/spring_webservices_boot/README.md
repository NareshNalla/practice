# Spring & Web Services: Interview Preparation Guide

This directory contains a consolidated set of interview notes covering Spring, Spring Boot, Web Services, and Reactive Programming. The notes are organized by topic into the following key files for focused study.

---

## 1. Core Spring & Spring Boot

**File:** `spring_boot_summary.md`

This is your primary guide for fundamental Spring Framework and Spring Boot concepts.

### Key Topics Covered:
- **Spring Boot Fundamentals:** Advantages, auto-configuration, starter dependencies, and the "opinionated" philosophy.
- **Core Spring Concepts:** IoC Container, Dependency Injection (DI), and the main framework modules.
- **Bean Lifecycle:** A detailed, step-by-step breakdown of how a Spring bean is created, initialized, and destroyed.
- **Spring MVC:** The MVC design pattern and the request lifecycle with the `DispatcherServlet`.
- **Enterprise Integration:** Concepts like JMS, Application Servers vs. Servlet Containers.
- **Spring Boot Actuator:** Production-ready monitoring with endpoints like `/health`, `/metrics`, and `/loggers`.

---

## 2. Web Services & Microservices

**File:** `webservices_notes.md`

This file covers everything related to how services communicate over the web.

### Key Topics Covered:
- **SOAP vs. REST:** A detailed comparison of the two web service styles.
- **RESTful Concepts:** Principles of REST, statelessness, and HATEOAS.
- **HTTP Methods:** A comprehensive breakdown of `GET`, `POST`, `PUT`, `PATCH`, and `DELETE`, including idempotency.
- **Web & Network Concepts:** Fundamentals of HTTP vs. HTTPS, Proxy Servers, and Client-Server Architecture.
- **XML Parsing:** A summary of the SAX parser.

---

## 3. Reactive Programming & Spring WebFlux

**File:** `spring_web_flux_interview_deep_dive.md`

This is your deep-dive guide for modern, reactive Java development.

### Key Topics Covered:
- **Core Reactive Concepts:** The "why" behind reactive programming (non-blocking, event-driven).
- **`Mono` & `Flux`:** The core reactive types in Project Reactor.
- **WebFlux vs. MVC:** A clear comparison of the two Spring web frameworks and when to use each.
- **Backpressure:** What it is and why it's critical for resilient reactive systems.
- **Key Operators:** A summary of the most important methods for transformation (`flatMap`), error handling (`onErrorResume`), and combining streams (`zip`).
- **The Reactive Ecosystem:** `WebClient` for HTTP calls, R2DBC for database access, and `WebTestClient` for testing.

---
*This README serves as the table of contents for the notes in this directory.*
