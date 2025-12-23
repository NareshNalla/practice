# Consolidated Core Java Interview Guide (Canonical, Deduplicated)

Note: This is a single, canonical file created by merging your three Core Java note files and removing duplicated text. The originals remain unchanged in the same folder:
- `core_java_interview_deep_dive.md`
- `core_java_interview_deep_dive1.md`
- `core_java_notes.md`

How to use
- Read the "Quick Answers" for short interview responses.
- Read the "Deep Dive" subsections for follow-up explanations and trade-offs.
- Practice the "Top Questions" out loud using the provided structure: one-liner, why it matters, gotcha and solution.

=================================================================
Table of Contents
=================================================================
1. Core Java & OOP Concepts
2. Serialization & Object IO
3. Collections Framework
4. Concurrency & Multithreading
5. JVM & Memory Management
6. Class Loading
7. Modern Java (8,11,17,21)
8. Spring Essentials
9. Miscellaneous (strings, obfuscation)
10. Interview Strategy, Top Questions, Study Plan

=================================================================
1. Core Java & OOP Concepts
=================================================================
Quick answer (for interviews)
- Immutability: Object state cannot change after construction. Make class final, fields private final, no setters, defensive copy mutable fields.
- Prefer composition over inheritance unless a clear "is-a" relationship exists and Liskov Substitution holds.
- final (keyword), finally (exception cleanup), finalize() (deprecated).
- Generics give compile-time safety; type information erased at runtime (type erasure).

Deep dive — Immutability
- Why: thread-safety without synchronization, predictable behavior, safe map keys, cache-friendly.
- Defensive copying: copy mutable inputs in constructor and return copies from getters. Use shallow copy when elements are immutable; use deep copy when elements are mutable.
- Example gotcha: storing a caller's List reference allows external mutation; fix with new ArrayList<>(input) and List.copyOf for unmodifiable view.

Composition vs Inheritance
- Composition (has-a) is more flexible and loosely coupled. Inheritance (is-a) is fine when subclass can be substituted for superclass and the relationship is stable.
- Inheritance pitfalls: fragile base-class, tight coupling, exposure of unwanted behavior.

final / finally / finalize
- final: restricts modification (variable, method, class).
- finally: always executes after try/catch (good for cleanup), but prefer try-with-resources for AutoCloseable.
- finalize(): unpredictable and deprecated; don't use.

Marker vs Functional Interfaces
- Marker: empty interfaces used as metadata (e.g., Serializable).
- Functional: single abstract method, target for lambdas (e.g., Runnable, Predicate). Use @FunctionalInterface for clarity.

Generics & Type Erasure
- Generics ensure compile-time type safety. At runtime type parameters are erased; the compiler inserts casts. This prevents creating overloads that differ only by generic type parameters.

=================================================================
2. Serialization & Object IO
=================================================================
Quick answer
- Serializable: easy, reflection-based; Externalizable: manual control.
- Use private writeObject/readObject for custom Serializable behavior.
- Declare serialVersionUID to manage compatibility; mark sensitive fields transient.

Deep dive
- Serializable pros/cons: easy to implement, but fragile and can expose deserialization security risks. Avoid deserializing untrusted data or use safe alternatives (JSON with schema, protobuf).
- Externalizable pros/cons: full control of format, potentially better stability/performance, but requires more coding and careful handling of superclasses.
- Security: deserialization of untrusted data can lead to remote code execution; validate inputs and consider safer libraries.

=================================================================
3. Collections Framework
=================================================================
equals()/hashCode() contract
- If a.equals(b) then a.hashCode() must equal b.hashCode(). Violating this breaks hash-based collections.

Iterators
- Fail-fast: detects structural modification and throws ConcurrentModificationException (ArrayList iterator, HashMap iterator).
- Fail-safe: iterates over snapshot or weakly-consistent view (CopyOnWriteArrayList, ConcurrentHashMap iterator).

HashMap internals (concise)
- put: compute key.hashCode(), mix, index = hash & (capacity-1). If bucket empty insert. On collision, compare equals(): replace or append.
- Pre-Java 8: per-bucket linked list. Java 8+: bucket converts to Red-Black Tree if entries exceed TREEIFY_THRESHOLD (default 8) and table sufficiently large — reduces worst-case lookup from O(n) to O(log n).
- Resize: when size > capacity * loadFactor (default loadFactor 0.75) -> rehashing is expensive; pre-size if possible.

ConcurrentHashMap vs Collections.synchronizedMap
- synchronizedMap: single lock for the entire map; high contention; iterator must be used inside synchronized block.
- ConcurrentHashMap: fine-grained concurrency (per-bin CAS/locks), reads often lock-free, weakly-consistent iterators, better throughput.

Other maps
- LinkedHashMap: maintains insertion or access order; useful for LRU caches.
- TreeMap: sorted map implemented with Red-Black Tree, O(log n) ops.
- WeakHashMap: keys are weak references — entries GC'd when keys no longer strongly referenced.
- IdentityHashMap: uses == for key equality.

ArrayList growth
- Backed by Object[]; on overflow allocate larger array and shallow-copy elements. Amortized add is O(1) but resize is O(n).

Best practices
- Iterate entrySet() when you need both key and value to avoid extra lookups.
- Use concurrent collections when sharing between threads; avoid manual synchronization when possible.

=================================================================
4. Concurrency & Multithreading
=================================================================
Quick answers
- Thread.yield() is only a hint; Thread.join() waits for thread completion.
- Use Executors (ThreadPoolExecutor) instead of creating raw threads.

Deadlocks and avoidance
- Deadlock: threads wait forever for locks held by each other.
- Avoidance: consistent lock ordering, tryLock() with timeout (back off), reduce lock scope, prefer higher-level concurrency utilities.

Java Memory Model (JMM)
- Distinguish JVM memory areas (heap/stack) vs JMM (visibility and ordering rules).
- Happens-before: ensures visibility (e.g., synchronized unlock -> subsequent lock, volatile write -> subsequent read).
- volatile guarantees visibility and ordering for that variable but does not provide atomicity for compound actions.

Thread exceptions
- Exceptions in child threads do not propagate to parent; use Thread.setUncaughtExceptionHandler or capture via Future.get().

Thread dumps and debugging
- Generate with jstack, jcmd, or kill -3. Inspect states RUNNABLE, BLOCKED, WAITING. jstack can report deadlocks.

Executors and thread pools
- Use proper pool sizing, queueing, rejection policies. Know fixed, cached, scheduled, single thread pools.

Virtual threads (Java 21)
- Lightweight JVM-managed threads (Project Loom). Allow massive concurrency with simpler blocking-style code. Mention in interviews as modern alternative to complex async models.

=================================================================
5. JVM & Memory Management
=================================================================
Memory areas (short)
- Heap: objects shared across threads. Stack: per-thread frames and locals. Metaspace: class metadata. CodeCache: JIT compiled code.

Garbage Collection (overview)
- Generational model: young (Eden+Survivors) and old/tenured.
- Collectors: Serial (single-threaded STW), Parallel (multithreaded STW, throughput-focused), G1 (regions, predictable pause goals — default), CMS (deprecated predecessor for low-pause), ZGC/Shenandoah (low-pause collectors for very large heaps).

Tuning points
- Trade-offs: throughput vs pause times. Use -Xms/-Xmx to size heap; G1 tuning for pause targets (-XX:MaxGCPauseMillis); monitor promotion/allocation rates to avoid excessive full GCs.

Quick GC commands and metrics
- jcmd GC.class_histogram <pid>, jcmd <pid> GC.run, jstat -gcutil

=================================================================
6. Class Loading
=================================================================
Delegation model
- Bootstrap -> Platform -> System/Application. Class loader delegates to parent before loading a class itself.
- Ensures uniqueness and security (core classes cannot be replaced by application classes).

Custom class loaders
- Used for modularity, plugin isolation, application servers. Classes with same name loaded by different loaders are distinct types.

=================================================================
7. Modern Java (8, 11, 17, 21)
=================================================================
Java 8
- Lambdas, Streams, Optional, default/static methods in interfaces, java.time API.
- Streams: source -> intermediate (lazy) -> terminal (e.g., collect). Use parallelStream() carefully (shared state pitfalls).

Java 11
- var local type inference, String.isBlank/lines/strip, Files.readString/writeString, standardized HTTP client.

Java 17
- Records (concise immutable data carriers), sealed classes, pattern matching for instanceof.

Java 21
- Virtual threads, sequenced collections, enhanced pattern matching for switch.

Practical notes
- Prefer String.strip() over trim() for Unicode-aware trimming.
- Prefer records for DTOs when immutability and boilerplate reduction align with requirements.

=================================================================
8. Spring Essentials (brief)
=================================================================
Bean lifecycle (high level)
- Instantiation -> Populate properties (DI) -> Aware callbacks -> @PostConstruct -> Bean ready -> @PreDestroy on shutdown.
- ConfigurableApplicationContext provides lifecycle management (refresh(), close()). In Spring Boot this is usually handled for you.

=================================================================
9. Miscellaneous
=================================================================
String.substring() history
- Older Java (pre-7u6) substring shared backing char[] which could cause memory retention; modern JVM copies characters.

strip() vs trim()
- strip(): Unicode-aware (Character.isWhitespace()); trim(): legacy ASCII <= U+0020. Use strip() in modern code.

Code obfuscation
- ProGuard and similar tools shrink/rename/obfuscate bytecode — raises bar for reverse engineering but is not a security feature by itself.

=================================================================
10. Interview Strategy, Top Questions, Study Plan
=================================================================
How to structure answers
1. One-liner definition (10–20s).
2. Why it matters — 2–3 points.
3. Gotcha + how to mitigate.
4. Optional succinct code snippet or production tip.

Sample: Immutability (practice answer)
- One-liner: Immutable objects cannot be changed after construction (final class, private final fields, no setters).
- Why: thread-safety, predictability, safe map keys.
- Gotcha: mutable internal fields — use defensive copying.

Top questions to drill
- Design an immutable class containing mutable fields.
- Explain HashMap internals and Java 8 treeify.
- Compare ConcurrentHashMap vs synchronizedMap.
- Explain the Java Memory Model and happens-before rules with an example.
- Describe GC collector trade-offs (G1 vs ZGC) and tuning goals.
- Explain classloader delegation and implications.
- When to use Externalizable vs Serializable.
- Explain fail-fast vs fail-safe iterators.
- How to detect and avoid deadlocks.
- What are virtual threads and when to use them?

4-week study plan (high level)
- Week 1: OOP, immutability, equals/hashCode, basics of collections.
- Week 2: Collections internals (HashMap, ConcurrentHashMap), iterators, generics.
- Week 3: Concurrency (JMM, synchronized/volatile, thread pools, deadlocks), thread dumps.
- Week 4: JVM internals, GC, class loaders, Java 8+ features, mock interviews.

Next steps I can do for you (pick any)
- Produce a deduped printable PDF or condensed 2-page cheat sheet.
- Generate Anki flashcards (CSV) from the Top Questions.
- Create runnable Java examples and unit tests for tricky topics (HashMap collision demo, deadlock reproduction + fix).
- Produce a 30/60-day drilling schedule with daily micro-tasks.

Quick commands & tips
- jstack <pid> (thread dump)
- jcmd <pid> Thread.print or GC.class_histogram
- Use List.copyOf() (Java 10+) for unmodifiable copies
- Prefer try-with-resources over finalize()

---------------------------------------
End of canonical consolidated guide
---------------------------------------
