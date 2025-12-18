# Spring WebFlux: Key Methods for Interviews

This document provides a quick, high-level summary of the most commonly used methods in Project Reactor (the library behind WebFlux), structured for interview preparation.

---

### 1. Core Reactive Types
- **`Mono.just()`**: Creates a `Mono` that emits a single, specified value.
- **`Mono.empty()`**: Creates a `Mono` that completes without emitting any value.
- **`Flux.just(...)`**: Creates a `Flux` that emits one or more specified values.
- **`Flux.fromIterable(...)`**: Creates a `Flux` from a collection (e.g., a `List`).

---

### 2. Transformation Methods (Most Important)
- **`map()`**: Transforms an item synchronously. (e.g., `T -> R`). Use this for simple, non-blocking transformations.
- **`flatMap()`**: Transforms an item **asynchronously** by returning another reactive publisher (`Mono` or `Flux`). This is the most critical method for chaining dependent reactive calls (e.g., making a network call based on the result of a previous one).

---

### 3. Filtering & Fallback
- **`filter()`**: Emits an item only if it satisfies a given condition.
- **`switchIfEmpty()`**: Subscribes to a fallback publisher if the original `Mono` or `Flux` completes without emitting any items.

---

### 4. Error Handling (Crucial)
- **`onErrorResume()`**: Subscribes to a fallback publisher if an error occurs. This is the most common way to handle errors gracefully (e.g., by returning a default response from a cache).
- **`onErrorReturn()`**: Emits a static default value if an error occurs.
- **`onErrorMap()`**: Transforms an error into a different exception.

---

### 5. Side-Effect Operations (Logging & Debugging)
- **`doOnNext()`**: Adds a side-effect action that is triggered when an item is emitted. Perfect for logging each item.
- **`doOnError()`**: Adds a side-effect action that is triggered when an error occurs. Used for logging errors.
- **`doOnSubscribe()`**: Adds a side-effect action triggered when a subscription occurs. Useful for tracking when a flow starts.

---

### 6. Combining Publishers
- **`zip()` / `zipWith()`**: Combines multiple `Mono`s into a single `Mono` that emits a tuple of their results. It waits for **all** sources to complete before emitting.
- **`merge()` / `mergeWith()`**: Merges multiple streams into one, emitting items as they arrive. Does not preserve order (interleaves items).
- **`concat()` / `concatWith()`**: Merges multiple streams into one, but waits for each source to complete before subscribing to the next. **Preserves order**.

---

### 7. Threading & Schedulers
- **`subscribeOn()`**: Specifies the thread pool (Scheduler) on which the **entire subscription and upstream execution** should happen.
- **`publishOn()`**: Switches the thread pool for all **downstream** operations that follow it in the chain.

---

### 8. Terminal Operations (Triggering the Flow)
- **`subscribe()`**: The ultimate trigger. Nothing happens in a reactive chain until `subscribe()` is called.
- **`block()`**: **Blocks** the current thread until the result is available. This should be **avoided at all costs** in a reactive application, except in tests or at the very top level of a non-reactive context.

---

### 9. WebClient (Making REST Calls)
- **`get()`, `post()`, `put()`, `delete()`**: Standard methods to begin defining an HTTP request.
- **`bodyValue()`**: Sets the request body for a `POST` or `PUT` request.
- **`retrieve()`**: The primary way to declare how to extract the response body.
- **`bodyToMono()`**: Decodes the response body into a `Mono` (for a single object).
- **`bodyToFlux()`**: Decodes the response body into a `Flux` (for a stream of objects, like a list).
- **`onStatus()`**: Provides a way to handle HTTP error statuses (e.g., 4xx or 5xx) and transform them into a custom exception.

---

## ⭐ Interview Focus: The Must-Know Methods

If an interviewer asks what WebFlux methods you use daily, your answer should focus on the most practical and impactful ones.

**Your Answer:**

"On a daily basis, my most-used methods are:
- **`flatMap()`** for chaining asynchronous calls, which is the core of any reactive pipeline.
- **`map()`** for simple, synchronous data transformations.
- **`onErrorResume()`** as our standard way to handle errors gracefully, often by providing a fallback.
- **`switchIfEmpty()`** to handle cases where a database query or API call returns no result.
- And of course, the **`WebClient`** builder, especially using **`bodyValue()`** to send data and **`retrieve()`** with **`bodyToMono()`** or **`bodyToFlux()`** to process responses."
