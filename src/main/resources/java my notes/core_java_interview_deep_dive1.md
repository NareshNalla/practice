# Core Java & Spring: Interview Deep Dive

This document provides a more nuanced, in-depth look at key concepts, focusing on the trade-offs and deeper principles expected in a technical interview.

===================================================================================
## 1. Core Java & OOP Concepts
===================================================================================

### Immutability

**The Standard Answer:** An immutable object is one whose state cannot be changed after creation. You make a class `final`, make fields `private final`, and don't provide setters.

**The Deeper, Interview-Level Answer:**
The key is understanding *why* this is important and how to handle mutable fields.
*   **Why it's Important:**
    1.  **Thread Safety:** Inherently thread-safe, simplifying concurrent programming.
    2.  **Predictability:** State is fixed, making code easier to debug.
    3.  **Cacheability:** Perfect for caching (e.g., `String` pool).
    4.  **Safe for Collections:** Can be safely used as keys in `HashMap`s or elements in `Set`s.
*   **The "Gotcha" - Defensive Copying:** If a class contains a mutable field (like a `List`), you must make defensive copies.
    1.  **In the constructor:** Create a *new* copy of the incoming mutable object. Do not store the reference directly.
    2.  **In the getter:** Return a *new* copy of the internal mutable object. Do not return a direct reference.

---
### Composition vs. Inheritance

**The Standard Answer:** Inheritance is an "is-a" relationship, and composition is a "has-a" relationship.

**The Deeper, Interview-Level Answer:**
The modern consensus is to **"favor composition over inheritance."**
*   **Problems with Inheritance:** It creates tight coupling (the "fragile base class" problem) and is rigid (Java only allows single inheritance).
*   **Advantages of Composition:** It's flexible (you can change components at runtime) and leads to loosely coupled, clearer designs.
*   **When is Inheritance Okay?** When there is a genuine "is-a" relationship and the subclass can be perfectly substituted for the superclass (Liskov Substitution Principle).

---
### final, finally, and finalize

**The Smart, Concise Answer:**
"`final` is a keyword to restrict modification. `finally` is a block for guaranteed cleanup in exception handling. And `finalize` is a deprecated method that should never be used in modern code."

**The Deeper, Interview-Level Answer:**

| Keyword | Type | Purpose & Key Points |
| :--- | :--- | :--- |
| **`final`** | Keyword | **Restriction.**<br>- `final` variable: A constant.<br>- `final` method: Cannot be overridden.<br>- `final` class: Cannot be inherited. |
| **`finally`** | Block | **Guaranteed Cleanup.**<br>- Always executes after `try-catch`, even if a `return` is present.<br>- Used for releasing resources (e.g., closing streams, database connections). |
| **`finalize`** | Method | **Deprecated Cleanup.**<br>- A method from `Object` that was intended to be called by the Garbage Collector.<br>- Its execution is **unpredictable** and unreliable. Use `try-with-resources` instead. |

---
### Marker vs. Functional Interfaces

**The Smart, Concise Answer:**
"A **Marker Interface** is an empty interface with no methods, used to provide metadata to the JVM, like `Serializable`. A **Functional Interface** has exactly one abstract method and is used to enable Lambda Expressions, like `Runnable`."

**The Deeper, Interview-Level Answer:**

| Feature | Marker Interface | Functional Interface |
| :--- | :--- | :--- |
| **Purpose** | Provides runtime type information (metadata). | Provides a target for a single piece of behavior. |
| **Methods** | **Zero** abstract methods. | **Exactly one** abstract method. |
| **Annotation**| None. | `@FunctionalInterface` (optional but recommended). |
| **Example** | `Serializable`, `Cloneable`. | `Runnable`, `Predicate`, `Function`. |
| **Usage** | Checked with `instanceof`. | Implemented with a Lambda Expression. |

---
### Serialization: `Serializable` vs. `Externalizable`

**The Standard Answer:** `Serializable` is a marker interface for automatic serialization, while `Externalizable` gives you manual control.

**The Deeper, Interview-Level Answer:**
The choice is a trade-off between **ease of use vs. performance and security**.
*   **`Serializable`:** Easy to use, but the default reflection-based process can be slow and create security risks (deserialization of untrusted data).
*   **`Externalizable`:** Requires more work (you must implement `writeExternal` and `readExternal`), but gives you full control over the format, which can be much more performant and secure.

===================================================================================
## 2. Collections Framework
===================================================================================

### `HashMap` Internals

**The Standard Answer:** `HashMap` uses `hashCode()` to find a bucket and stores entries in a linked list.

**The Deeper, Interview-Level Answer:**
An interviewer wants to see that you understand the process, edge cases, and Java 8 improvements.
*   **Process:** `hashCode()` -> secondary hash -> index calculation -> find bucket.
*   **Collision Handling:**
    *   **Before Java 8:** Always a linked list. Worst-case lookup is O(n).
    *   **Since Java 8:** If a bucket's linked list grows beyond a threshold (8), it converts to a **Red-Black Tree**. This improves worst-case lookup to O(log n).
*   **Resizing:** When `(size) > (capacity * load factor)`, the map doubles its capacity and all entries are re-hashed. This is an expensive operation.

---
### `ConcurrentHashMap` vs. `Collections.synchronizedMap`

**The Standard Answer:** Both are thread-safe, but `ConcurrentHashMap` is more performant.

**The Deeper, Interview-Level Answer:**
The difference is their **concurrency strategy**.
*   **`Collections.synchronizedMap`:** Uses a **single map-wide lock**. Only one thread can read or write at any time, causing high contention.
*   **`ConcurrentHashMap`:** Uses **fine-grained locking** (also called lock striping). It divides the map into segments, each with its own lock. Multiple threads can operate on different segments simultaneously, providing much higher throughput.

===================================================================================
## 3. JVM, Concurrency & Debugging
===================================================================================

### Java Memory Model (JMM)

**The Standard Answer:** The JMM defines how threads interact with memory.

**The Deeper, Interview-Level Answer:**
It's crucial to distinguish between the **JVM Memory Structure** (the "where": Heap, Stack) and the **JMM** (the "when" and "how").
*   **The Problem:** For performance, a thread might keep a copy of a shared variable in its own CPU cache, leading to visibility issues.
*   **The JMM's Solution:** The JMM defines a **"happens-before"** relationship, which guarantees that memory writes by one thread are visible to others. This is enforced primarily through:
    1.  **`synchronized` blocks:** Unlocking a monitor happens-before any subsequent lock on that same monitor.
    2.  **`volatile` variables:** A write to a `volatile` variable happens-before every subsequent read of that same variable.

---
### Thread Dump Analysis

**The Smart, Concise Answer:**
"A thread dump is a snapshot of all threads in the JVM, used to diagnose issues like deadlocks or high CPU usage. You generate it with `jstack` or `jcmd`, and the key is to look for threads in `BLOCKED` or `WAITING` states to understand what they are stuck on."

**The Deeper, Interview-Level Answer:**
*   **How to Generate:** `jstack <pid>`, `jcmd <pid> Thread.print`, or `kill -3 <pid>` on Linux.
*   **Key States to Analyze:**
    *   **`RUNNABLE`:** Actively running or ready to run.
    *   **`BLOCKED`:** Waiting to acquire a `synchronized` lock. A key indicator of contention.
    *   **`WAITING` / `TIMED_WAITING`:** Waiting on a condition (`Object.wait()`, `Thread.join()`).
*   **Deadlock Analysis:** `jstack` automatically detects and reports deadlocks, showing which threads are waiting on which locks in a cycle.

---
### Garbage Collection (GC)

**The Standard Answer:** GC automatically frees memory.

**The Deeper, Interview-Level Answer:**
An interviewer wants to see that you understand the *impact* of GC on application performance, specifically **application pause times ("Stop-The-World" or STW)**.
*   **Generational GC:** Most objects die young, so the heap is split into a **Young Generation** (frequent, fast Minor GCs) and an **Old Generation** (less frequent, slower Major GCs).
*   **GC Collectors:** The evolution is about minimizing pause times.
    *   **Parallel GC:** Throughput focused, but has long STW pauses.
    *   **G1 GC (Default in modern Java):** A balance of throughput and low latency, aiming for predictable pause time goals.
    *   **ZGC / Shenandoah:** Ultra-low-latency collectors for massive heaps.

---
### Class Loader

**The Standard Answer:** It loads classes in a hierarchy.

**The Deeper, Interview-Level Answer:**
The key principle is the **Delegation Model**.
1.  A class loader first **delegates** the request to its parent.
2.  It only tries to load the class itself if the parent chain **fails**.
*   **Why it's important:**
    1.  **Uniqueness:** Prevents the same class from being loaded multiple times.
    2.  **Security:** Prevents malicious code from replacing core Java classes like `java.lang.String`.

===================================================================================
## 4. Modern Java Features (8+)
===================================================================================

### Streams API

**The Standard Answer:** Streams provide a cleaner, functional way to process collections.

**The Deeper, Interview-Level Answer:**
Streams marked a shift from **imperative** ("how") to **declarative** ("what") data processing.
*   **Key Concepts:**
    1.  **Pipeline Structure:** Source -> Intermediate Operations -> Terminal Operation.
    2.  **Laziness:** Intermediate operations (`filter`, `map`) are not executed until a terminal operation (`collect`) is called. This allows for significant optimizations.
    3.  **Parallelism:** Simply calling `.parallelStream()` can process data across multiple CPU cores.

---
### `strip()` vs. `trim()` (Java 11)

**The Standard Answer:** `strip()` is the modern version of `trim()`.

**The Deeper, Interview-Level Answer:**
The key difference is that `strip()` is **Unicode-aware**.
*   **The Flaw with `trim()`:** Only handles basic ASCII whitespace (`<= U+0020`).
*   **How `strip()` Fixes This:** It uses `Character.isWhitespace()`, which correctly identifies all Unicode-defined whitespace characters.
*   **Conclusion:** In any modern Java application (11+), always prefer `strip()` over `trim()`.

---
### Records vs. Lombok

**The Smart, Concise Answer:**
"No, you should never use Lombok with a `record`. A `record` is Java's native solution to the same problem Lombok solves, making Lombok redundant for data classes."

**The Deeper, Interview-Level Answer:**
*   **Immutability & Setters:** A `record` is immutable by design; its fields are `final`, and it **cannot have setters**. Lombok's `@Data` is for mutable beans.
*   **Accessors:** A `record` generates accessors that match the field name (e.g., `person.name()`). Lombok follows the JavaBean convention (`person.getName()`).
*   **Conclusion:** For new data carriers, prefer a `record`. It's a native language feature with no dependencies and strong, built-in guarantees.

===================================================================================
## 5. Spring Framework Concepts
===================================================================================

### Q: "Explain the Spring Bean Lifecycle."

**The Smart, Concise Answer:**
"The Spring Bean Lifecycle describes how the IoC container creates, configures, and destroys a bean. The main phases are: **Instantiation**, **Population** (dependency injection), **Initialization** (custom init methods), and **Destruction**."

**The Deeper, Interview-Level Answer:**
The key is knowing the callback points.
1.  **Instantiation:** The container creates the bean instance.
2.  **Populate Properties:** The container injects dependencies.
3.  **Aware Interfaces:** Methods like `setBeanName()` are called.
4.  **`@PostConstruct`:** A method annotated with this is called. This is the preferred initialization callback.
5.  **Bean is Ready:** The bean is now fully initialized.
6.  **`@PreDestroy`:** When the container is closed, a method with this annotation is called. This is the preferred destruction callback.

---
### Q: "What is the `ConfigurableApplicationContext`?"

**The Smart, Concise Answer:**
"`ConfigurableApplicationContext` is the main interface for managing the Spring container's lifecycle. While `ApplicationContext` is the read-only interface for beans, `ConfigurableApplicationContext` is the read-write 'admin' interface used to `refresh()` (start) and `close()` (stop) the container."

**The Deeper, Interview-Level Answer:**
*   **The "Why": Separation of Concerns:** This design prevents application beans from managing the container's lifecycle.
*   **Key Lifecycle Methods:**
    *   **`refresh()`:** Triggers the entire startup process: loading bean definitions, instantiating singletons, and performing dependency injection.
    *   **`close()`:** Performs a graceful shutdown, calling `@PreDestroy` methods and releasing resources.
*   **Practical Usage:** While Spring Boot hides this, you use it directly in standalone apps, often in a `try-with-resources` block for automatic cleanup.

===================================================================================
## 6. Other Protocols
===================================================================================

### FTP (File Transfer Protocol)
- **What it is:** A standard client-server protocol for transferring files.
- **How it works:** It uses two separate connections:
    1.  **Control Connection:** For sending commands (e.g., `USER`, `GET`).
    2.  **Data Connection:** For transferring the actual file data.
- **Security:** FTP is inherently **insecure** as it transmits data in plain text. For secure transfers, **SFTP** (over SSH) or **FTPS** (FTP with SSL/TLS) should be used.
