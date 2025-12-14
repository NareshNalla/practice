# Core Java Interview Notes

## 1. Core Java & OOP Concepts

### Immutability
An object is immutable if its state cannot be changed after it is created.

**Rules for Creating an Immutable Class:**
1.  **Final Class:** Declare the class as `final` to prevent it from being extended.
2.  **Private Final Fields:** Make all fields `private` and `final`.
3.  **No Setters:** Do not provide any "setter" methods.
4.  **Defensive Copying for Mutable Fields:** If a class has fields that are mutable objects (e.g., `java.util.Date`, `ArrayList`), you must make copies.
    -   **In the constructor:** Create a new copy of any incoming mutable objects.
    -   **In the getter:** Return a new copy of any internal mutable objects.
    -   **Shallow vs. Deep Copy:**
        -   Use a **shallow copy** for your defensive copy if the elements inside the mutable object are themselves immutable (e.g., a `List<String>`).
        -   Use a **deep copy** if the elements inside are also mutable (e.g., a `List<Person>`).

### OOP Principles
- **Composition vs. Inheritance:**
    - **Composition ("has-a"):** An object is composed of other objects. This is achieved by having instance variables that are references to other objects. It is generally favored over inheritance as it's more flexible.
    - **Inheritance ("is-a"):** A class inherits properties and behaviors from a parent class.
- **Upcasting vs. Downcasting:**
    - **Upcasting:** Implicitly and safely casting a child object to a parent reference type (`Parent p = new Child();`).
    - **Downcasting:** Explicitly casting a parent reference back to a child type (`Child c = (Child) p;`). This is risky and can throw a `ClassCastException` if the object being referenced is not actually of the child type.
- **Method Hiding vs. Overriding:**
    - **Overriding:** An instance method in a subclass with the same signature as in the superclass overrides the parent's method. The method called depends on the **object's actual type** at runtime.
    - **Method Hiding:** `static` methods are not overridden; they are hidden. The method called depends on the **reference type**, not the object type.
- **Cohesion & Coupling:**
    - **Cohesion:** How focused and related the responsibilities of a single class are. **High cohesion** is good (the class does one thing well).
    - **Coupling:** How dependent two classes are on each other. **Low coupling** is good (changes in one class are less likely to require changes in another).

### Generics & Type Erasure
- **Purpose:** To provide compile-time type safety and prevent `ClassCastException` at runtime.
- **Type Erasure:** This is how Java implements generics. The compiler removes all generic type information at compile time.
    1.  It replaces generic type parameters with their bounds (or `Object` if unbounded).
    2.  It inserts necessary type casts to maintain type safety.
    - **Benefit:** This ensures that no new classes are created for parameterized types at runtime, avoiding runtime overhead and maintaining backward compatibility with older Java versions.

### Serialization & Externalization
- **Serialization:** The process of converting an object's state into a byte stream to be stored or transmitted.
    - **`Serializable`:** A marker interface. Implementing it makes a class serializable.
    - **`serialVersionUID`:** A version ID for a class. It's used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible.
    - **`transient`:** A keyword used to mark fields that should **not** be included in the serialization process.
    - **Deserialization Process:** No constructor is called during standard deserialization. The object is created directly from the byte stream.
- **Externalization:** Provides complete, manual control over the serialization process.
    - **`Externalizable` Interface:** Must be implemented. It extends `Serializable`.
    - **Methods to Implement:** You must implement `writeExternal(ObjectOutput out)` and `readExternal(ObjectInput in)`.
    - **Constructor Call:** The public no-argument constructor **is called** during deserialization before `readExternal` is invoked.

---

## 2. Collections Framework

### `hashCode()` and `equals()` Contract
This contract is fundamental for the correct functioning of hash-based collections like `HashMap`, `HashSet`, and `Hashtable`.
1.  If `obj1.equals(obj2)` is true, then `obj1.hashCode()` MUST be equal to `obj2.hashCode()`.
2.  If `obj1.hashCode()` is equal to `obj2.hashCode()`, it does **not** mean that `obj1.equals(obj2)` must be true. (This is a hash collision).

### Iterators: Fail-Fast vs. Fail-Safe
- **Fail-Fast:** Throws a `ConcurrentModificationException` if the collection is structurally modified (e.g., adding or removing elements) in any way after the iterator is created, except through the iterator's own `remove()` method. (e.g., `ArrayList`, `HashMap`).
- **Fail-Safe:** Works on a clone or snapshot of the collection, so it does not throw an exception if the original collection is modified. Changes made to the collection may not be reflected in the iterator. (e.g., `ConcurrentHashMap`, `CopyOnWriteArrayList`).

### `HashMap` and Related Classes
- **`HashMap`:**
    - **Synchronization:** Unsynchronized and not thread-safe.
    - **Nulls:** Allows one `null` key and multiple `null` values.
    - **Java 8+ Performance:** When the number of entries in a single bucket exceeds a threshold (`TREEIFY_THRESHOLD`, default is 8), the linked list in that bucket is converted into a self-balancing binary search tree (a Red-Black Tree). This improves the worst-case lookup performance from O(n) to O(log n).
    - **`keySet()` vs. `entrySet()`:** Iterating over `entrySet()` is more efficient. It provides direct access to both key and value. Iterating `keySet()` and then calling `get(key)` for each key results in an extra lookup for each element.
- **`ConcurrentHashMap`:**
    - **Synchronization:** Thread-safe. It achieves this without locking the entire map by using a technique called "lock striping," where different parts (or buckets) of the map can be locked independently.
    - **Iterator:** Provides a fail-safe iterator.
- **`Hashtable`:**
    - **Legacy Class:** Should be avoided in new code.
    - **Synchronization:** Fully synchronized. Every method locks the entire map, leading to poor performance in concurrent environments.
    - **Nulls:** Does not allow `null` keys or values.
- **`LinkedHashMap`:**
    - **Ordering:** A subclass of `HashMap` that maintains the insertion order of elements.
- **`TreeMap`:**
    - **Ordering:** Stores keys in a sorted order (either natural order or by a provided `Comparator`).
    - **Implementation:** Implemented as a Red-Black Tree, which guarantees O(log n) time cost for `put`, `get`, and `remove` operations.

### Other Collections
- **`WeakHashMap`:**
    - A `Map` implementation that stores its keys as "weak references."
    - If a key is no longer strongly referenced anywhere else in the application, its entry in the `WeakHashMap` can be garbage collected. This is very useful for implementing caches.
- **`IdentityHashMap`:**
    - Compares keys using reference equality (`==`) instead of object equality (`equals()`). Two keys are considered equal only if they are the exact same object.
- **`ArrayList` Growth:**
    - An `ArrayList` is backed by an array. When the array becomes full, a new, larger array is allocated, and all the elements from the old array are copied to the new one. This is a **shallow copy** of the elements.

---

## 3. Concurrency and Multithreading

### Core Threading Concepts
- **`Thread.yield()`:** A static method that is a hint to the thread scheduler. It suggests that the current thread is willing to yield its current use of a processor, allowing other threads to run. The scheduler is free to ignore this hint.
- **`Thread.join()`:** An instance method that makes the current thread wait until the thread it is joining with completes its execution.

### Deadlocks
A situation where two or more threads are blocked forever, waiting for each other.
**How to Avoid Deadlocks:**
1.  **Avoid Nested Locks:** A thread should release its locks before acquiring new ones if possible.
2.  **Lock Ordering:** If multiple locks are necessary, ensure that every thread acquires the locks in the same fixed order.
3.  **Use `tryLock` with a Timeout:** Instead of using a blocking lock (`lock.lock()`), use `lock.tryLock(timeout, unit)`. This allows a thread to back off and release its own locks if it cannot acquire all necessary locks within a certain time.
4.  **Reduce Lock Scope:** Keep lock-holding sections as small as possible.

### Exception Handling in Threads
- A `try-catch` block in a parent thread **cannot** catch an exception thrown in a child thread because each thread has its own execution stack.
- To handle exceptions from a thread, you can use `Thread.setUncaughtExceptionHandler(handler)`.

---

## 4. JVM and Memory Management

### Java Memory Model
- **Heap Memory:** Stores all Java objects. It is shared among all threads.
    - `-Xms`: Sets the initial heap size.
    - `-Xmx`: Sets the maximum heap size.
- **Metaspace:** (Java 8+) Replaced the old PermGen space. It stores class metadata (e.g., class structure, method data) in native memory. It auto-grows by default.
- **Stack Memory:** Each thread has its own private stack. The stack stores local variables, method call frames, and partial results.
- **Code Cache:** An area of memory used by the Just-In-Time (JIT) compiler to store compiled native code for frequently executed methods.

### Garbage Collection (GC)
- **Process:** 1. **Marking** (finding all live objects), 2. **Sweeping/Deletion** (removing dead objects), and 3. **Compacting** (moving live objects together to reduce fragmentation).
- **Generational GC Hypothesis:** Most objects die young.
    - **Young Generation:** Where new objects are allocated (in "Eden" space). Minor GCs run frequently here. Objects that survive are moved to Survivor spaces (S0, S1).
    - **Old (Tenured) Generation:** Objects that survive multiple GC cycles in the Young Generation are "promoted" to the Old Gen. Major GCs run here, which are slower.
- **GC Algorithms:**
    - **Serial:** Single-threaded, "Stop-The-World" (STW) collector. Freezes the application during GC.
    - **Parallel:** Multi-threaded version of the serial collector. Still STW, but faster on multi-core machines.
    - **CMS (Concurrent Mark Sweep):** Tries to do most of the marking and sweeping work concurrently with the application to minimize pause times. Can suffer from fragmentation.
    - **G1 (Garbage-First):** The default GC in modern Java (8+). Divides the heap into regions and prioritizes collecting regions with the most garbage, aiming for more predictable pause times.
    - **Shenandoah / ZGC:** The newest collectors, focused on achieving ultra-low pause times (sub-millisecond) on very large heaps.

### Class Loader
- **Responsibility:** Dynamically loads Java classes into the JVM.
- **Hierarchy and Delegation:**
    1.  **Bootstrap Class Loader:** Loads core Java APIs (from `rt.jar`). It's the parent of all others.
    2.  **Platform Class Loader:** (Java 9+) Loads internal platform classes.
    3.  **System/Application Class Loader:** Loads classes from the application classpath.
- **Process:** When a class needs to be loaded, the request is delegated up the hierarchy. A class loader will only attempt to load a class if its parent cannot find it.

---

## 5. Java 8+ Features

### Functional Programming
- **Functional Interface:** An interface with exactly one abstract method. The `@FunctionalInterface` annotation is optional but recommended for clarity.
    - **`Predicate<T>`:** `boolean test(T t)` - Represents a boolean-valued function.
    - **`Function<T, R>`:** `R apply(T t)` - Represents a function that accepts one argument and produces a result.
    - **`BinaryOperator<T>`:** `T apply(T t1, T t2)` - Represents an operation on two operands of the same type, returning a result of the same type.
- **Lambda Expressions:** A concise, anonymous function that can be used to provide an implementation for a functional interface.
- **Default and Static Methods:** Interfaces can now have methods with implementations, allowing for evolution of interfaces without breaking existing implementations.

### `Optional`
- A container object that may or may not contain a non-null value.
- **Purpose:** To provide a clear and explicit way to handle the absence of a value, thereby reducing the likelihood of `NullPointerException`. It forces the developer to actively consider the "not found" case.

### `StringJoiner`
- A utility class used to construct a sequence of characters (a `String`) separated by a delimiter, with an optional prefix and suffix. `String.join()` uses `StringJoiner` internally.

### New `Map` Methods
- **`computeIfAbsent(key, mappingFunction)`:** If the key is not already associated with a value, attempts to compute its value using the given mapping function and enters it into the map.
- **`computeIfPresent(key, remappingFunction)`:** If the specified key is present, computes a new mapping given the key and its current value.
- **`getOrDefault(key, defaultValue)`:** Returns the value to which the specified key is mapped, or `defaultValue` if this map contains no mapping for the key.
- **`merge(key, value, remappingFunction)`:** If the key is not present, inserts the given value. If the key is present, the remapping function is used to merge the old and new values.

---

## 6. Miscellaneous

### Code Obfuscation
- **Purpose:** To make the reverse-engineering of compiled Java bytecode more difficult. It is not true security but raises the bar for attackers.
- **Techniques:** Renaming classes, methods, and variables to meaningless names; inserting bogus code; encrypting string literals.
- **Tool:** **ProGuard** is a very popular open-source tool for shrinking, optimizing, and obfuscating Java code. It is often integrated into Android build processes.

### `String.substring()` Memory Leak
- In older Java versions (before Java 7 update 6), the `String` object created by `substring()` would internally hold a reference to the original, complete character array of the source string, along with an offset and length.
- **Problem:** If you had a very long original string and created a small substring from it, the garbage collector could not reclaim the memory of the long character array as long as the small substring was still referenced, leading to a memory leak.
- **Fix:** Since Java 7u6, `substring()` creates a **new character array** for the new string, so this leak no longer occurs.

### Spring Actuator
- A sub-project of Spring Boot that provides production-ready features for monitoring and managing a running application.
- **Common Endpoints:**
    - `/actuator/health`: Shows application health status (e.g., "UP" or "DOWN"). Can include details about database connections, disk space, etc.
    - `/actuator/info`: Displays arbitrary application information.
    - `/actuator/metrics`: Shows a wide range of application metrics (e.g., JVM memory usage, HTTP request counts, system CPU usage).
    - `/actuator/loggers`: Allows viewing and modifying application log levels at runtime.
