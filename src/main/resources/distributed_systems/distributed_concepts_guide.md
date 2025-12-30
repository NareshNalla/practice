# Distributed Data Processing: Architectural Concepts

This guide covers high-level, framework-agnostic architectural patterns and concepts for distributed data processing systems.

---

## 1. Architectural Patterns

### Kappa vs. Lambda Architecture

-   **Lambda Architecture:**
    -   **Structure:** A hybrid approach consisting of two layers for data processing:
        1.  **Batch Layer (Cold Path):** Periodically runs on the complete, historical dataset to produce accurate, comprehensive views.
        2.  **Speed/Streaming Layer (Hot Path):** Processes data in real-time to provide low-latency, speculative results for recent data.
    -   **Serving Layer:** Merges the results from both the batch and speed layers to answer queries.
    -   **Trade-off:** High operational cost and complexity due to developing and maintaining two separate codebases and systems.

-   **Kappa Architecture:**
    -   **Structure:** A simplified, streaming-first architecture that uses a **single, unified processing layer**.
    -   **Core Idea:** It handles both real-time processing and historical reprocessing using a single stream processing engine. Batch processing is treated as a special case of streaming.
    -   **Replay Mechanism:** This architecture relies on a robust **replay mechanism** to re-process data in case of code changes or bug fixes. This is typically achieved by using a durable, replayable message queue like Apache Kafka or Google Cloud Pub/Sub that retains data for a long period.

---

## 2. Core Streaming Concepts

### Event Time vs. Processing Time

This is the most fundamental concept for ensuring data correctness in a streaming system.

-   **Event Time:** The timestamp embedded in the data itself, representing **when the event actually occurred** at the source (e.g., when a user clicked a button on a mobile app). This is the "source of truth."
-   **Processing Time:** The timestamp representing **when the data is observed or processed** by the pipeline worker.

**Why it matters:** In any real-world distributed system, network lag, system delays, and retries will cause data to arrive out of order. Relying on Processing Time will lead to incorrect results (e.g., grouping an event that happened at 10:00 AM into the 10:02 AM window just because it arrived late). Correctness-critical systems must operate on **Event Time**.

### Watermarks

-   **Definition:** A watermark is a heuristic timestamp that represents the point in event time up to which the system believes it has seen all the data. It's a "progress bar" for event time.
-   **Purpose:** Watermarks are the mechanism that allows a streaming system to know when a time-based window (e.g., "all events from 10:00 to 10:05") is considered "complete" and can be processed or aggregated.
-   **How it works:** As the system processes data, it observes the event times and advances the watermark. When the watermark passes the end of a window's timestamp, it triggers the processing for that window.

### Handling Late Data

-   **Definition:** Late data is any data that arrives after the system's watermark has already passed its event time.
-   **Best Practice:** Do not simply drop late data. A robust pipeline should have an explicit strategy for handling it. A common pattern is to use a **side-output** to send any late data to a **"Dead Letter Queue" (DLQ)** for later analysis, manual correction, or reprocessing.

### Triggers

-   **Definition:** A trigger is a mechanism that determines when to emit the results of a window.
-   **Event Time Triggers:** The default and most common type. They fire when the watermark passes the end of the window.
-   **Processing Time Triggers:** Fire based on the system's wall-clock time. These are non-deterministic and should be avoided for correctness-critical logic. They are primarily useful for providing speculative, low-latency updates for a UI, where speed is more important than perfect accuracy.
