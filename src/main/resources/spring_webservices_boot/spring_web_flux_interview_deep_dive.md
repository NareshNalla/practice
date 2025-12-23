## 1. Core Reactive & WebFlux Concepts
===================================================================================
### Q: "What is Spring WebFlux?"

Spring WebFlux is the reactive, non-blocking web framework in the Spring ecosystem. 
It's designed for building highly concurrent and scalable applications that can handle more requests with fewer threads by using an event-driven model instead of the traditional thread-per-request model.

---

### Q: "What is the core idea of Reactive Programming?"

**The Short Answer:**

"Reactive Programming is a paradigm for building non-blocking, event-driven applications that operate on asynchronous data streams. Instead of a thread blocking and waiting for data, the system reacts to data as it becomes available, freeing up the thread to do other work. This leads to better resource utilization and scalability."

**The Deeper, Interview-Level Answer:**

*   **The Problem with the Traditional Model:** In a traditional Spring MVC application, each request is handled by a dedicated thread from a thread pool. If that thread has to wait for a slow database query or a call to another microservice (blocking I/O), it sits idle, consuming memory and doing no work. To handle more concurrent requests, you have to add more threads, which is not scalable.
*   **The Reactive Solution:** Reactive programming uses a small, fixed number of threads (an "event loop") to handle many concurrent requests.
    *   When a request comes in, it's processed. If it needs to make a blocking call, it doesn't wait. Instead, it submits the task and provides a **callback** to be executed when the task is complete.
    *   The event loop thread is then immediately freed up to handle other requests.
    *   When the database query or network call finishes, it emits an event, and the event loop picks it up and executes the callback to finish processing the original request.
*   **Backpressure:** A key concept. It's a mechanism for the consumer to signal to the producer how much data it can handle. This prevents a fast producer from overwhelming a slow consumer.

---

### Q: "What are `Mono` and `Flux`?"

"They are the two core reactive types from Project Reactor, which powers WebFlux. A **`Mono`** represents a stream of **0 or 1** items, used for responses that will return at most a single object. A **`Flux`** represents a stream of **0 to N** items, used for collections or continuous streams of data."

---

### Q: "How does WebFlux handle high concurrency compared to Spring MVC?"

"Spring MVC uses a blocking, thread-per-request model. To handle more requests, you need more threads. WebFlux uses a non-blocking, **event-loop model** with a small, fixed number of threads. When a request involves I/O, the thread doesn't wait; it registers a callback and is immediately freed up to handle other requests. This allows it to manage much higher concurrency with fewer resources."

---

### Q: "What is Backpressure and why is it important?"

"It's a mechanism where the **consumer can signal to the producer how much data it can handle**. This prevents a fast producer from overwhelming a slow consumer, which would otherwise lead to buffer overflows and `OutOfMemoryError`. It's a form of flow control that is automatically handled by WebFlux. This is a **critical concept**."

## 2. WebFlux vs. Spring MVC (A Classic Comparison)
### Q: "When would you choose WebFlux over MVC, and when would you not?"

**The Short Answer:**

"I would choose WebFlux for I/O-bound applications that need to handle very high concurrency, like API gateways, data streaming services, or proxies. I would **not** use WebFlux for simple CRUD applications or systems that rely heavily on blocking libraries like traditional JDBC, because you only get the benefit if the entire call stack is reactive. WebFlux is a different tool for a different problem, not a replacement for MVC."

**The Deeper, Interview-Level Answer:**

| Feature | Spring MVC (Blocking) | Spring WebFlux (Reactive) |
| :--- | :--- | :--- |
| **Concurrency Model** | Thread-per-request | Event-loop model |
| **Programming Style** | Imperative, synchronous | Functional, asynchronous, declarative |
| **Core API** | Based on the blocking Servlet API | Can run on non-blocking servers like Netty |
| **HTTP Client** | `RestTemplate` (blocking, now in maintenance) | `WebClient` (non-blocking) |
| **Database Access** | Blocking JDBC, JPA | R2DBC (Reactive SQL), Reactive MongoDB |
| **Use Case** | Ideal for traditional CRUD applications, synchronous workflows, and applications with many blocking dependencies (like JDBC). | Ideal for I/O-bound applications, streaming APIs, and systems that need to handle very high concurrency with minimal resources. |

## 3. Key Methods & Operators
===================================================================================

### Transformation (Most Important)
- **`map()`**: Transforms an item **synchronously** (`T -> R`). Use for simple, non-blocking conversions.
- **`flatMap()`**: Transforms an item **asynchronously** by returning another `Mono` or `Flux`. This is the most critical method for chaining dependent reactive calls.

### Error Handling (Crucial)
- **`onErrorResume()`**: Provides a fallback publisher if an error occurs. The most common way to handle errors gracefully.
- **`onErrorReturn()`**: Emits a static default value on error.
- **`onErrorMap()`**: Transforms an error into a different exception.
- **Interview Tip:** Never use a traditional `try-catch` block to handle errors within a reactive pipeline; always use these operators.

### Filtering & Fallback
- **`filter()`**: Emits an item only if it satisfies a condition.
- **`switchIfEmpty()`**: Subscribes to a fallback publisher if the original stream completes empty.

### Combining Publishers
- **`zip()` / `zipWith()`**: Combines multiple `Mono`s. Waits for **all** sources to complete before emitting a tuple of their results.
- **`merge()`**: Interleaves items from multiple streams as they arrive. Does not preserve order.
- **`concat()`**: Subscribes to streams sequentially. Preserves order.

### Threading & Schedulers
- **`subscribeOn()`**: Specifies the thread pool for the **entire upstream** pipeline.
- **`publishOn()`**: Switches the thread pool for all **downstream** operators.

## 4. The Reactive Ecosystem
### WebClient (The Reactive HTTP Client)
- **What it is:** The modern, non-blocking HTTP client in Spring, designed for WebFlux. It is the reactive replacement for `RestTemplate`.
- **Key Methods:**
    - `bodyValue()`: To set the request body.
    - `retrieve()`: To declare how to extract the response.
    - `bodyToMono()` / `bodyToFlux()`: To decode the response into a reactive type.
    - `onStatus()`: To handle HTTP error codes (e.g., 4xx/5xx) in a reactive way.

### Reactive Data Access
- **The Challenge:** To get the full benefit of WebFlux, your database calls must also be non-blocking.
- **Solutions:**
    - **R2DBC (Reactive Relational Database Connectivity):** A specification that provides reactive drivers for SQL databases like PostgreSQL, MySQL, etc.
    - **Reactive MongoDB/Redis/Cassandra:** Most popular NoSQL databases have official reactive drivers that integrate perfectly with WebFlux.

### Testing WebFlux Applications
- **Tool:** `WebTestClient`.
- **Why:** It is a non-blocking client specifically designed for testing reactive endpoints. It allows you to subscribe to the response and assert against the emitted values without blocking.

---
## ⭐ Interview Focus: The Must-Knows

If an interviewer asks what WebFlux concepts you use daily, your answer should be practical and confident.

**Your Answer:**

"On a daily basis, my work revolves around a few core concepts:
- **`flatMap()`** is essential for chaining our asynchronous service calls.
- **`WebClient`** for making non-blocking HTTP calls to other microservices.
- **Error handling with `onErrorResume()`** to gracefully handle failures.
- **`Mono` and `Flux`** as the core data types I work with.

These are the building blocks of every reactive endpoint I write."
