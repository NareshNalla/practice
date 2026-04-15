# Java Thread Creation — Interview Prep

## All 9 Ways

| # | Way | Returns Value? | Throws Checked Exception? | Use Case |
|---|---|---|---|---|
| 1 | `extends Thread` | ❌ | ❌ | Simple, not preferred |
| 2 | `implements Runnable` | ❌ | ❌ | Decoupled, preferred over #1 |
| 3 | `Callable + FutureTask` | ✅ | ✅ | Need result from thread |
| 4 | `ExecutorService` | ✅ via Future | ✅ | Production thread pools |
| 5 | `ScheduledExecutorService` | ✅ | ✅ | Delayed / periodic tasks |
| 6 | `CompletableFuture` | ✅ | ✅ | Async pipelines, Java 8+ |
| 7 | `ForkJoinPool` | ✅ | ✅ | Parallel divide-and-conquer |
| 8 | Lambda / Anonymous Runnable | ❌ | ❌ | Shorthand for Runnable |
| 9 | **Virtual Threads** | ❌ / ✅ | ✅ | Massive I/O concurrency, Java 21+ |
 
---

## Interview Notes

**Way 1 — extends Thread**
- Not preferred. Single inheritance — blocks extending any other class.

**Way 2 — implements Runnable**
- Preferred over Way 1. Separates task from thread. Functional interface → supports lambda.

**Way 3 — Callable + FutureTask**
- `Callable` returns value, throws checked exceptions. `FutureTask.get()` blocks until result ready.

| | Runnable | Callable |
|---|---|---|
| Returns value | ❌ | ✅ |
| Throws checked exception | ❌ | ✅ |

**Way 4 — ExecutorService**
- Thread reuse, pool management. `shutdown()` waits for tasks. `shutdownNow()` interrupts immediately.

| Pool Type | Behavior |
|---|---|
| `newFixedThreadPool(n)` | Fixed n threads |
| `newCachedThreadPool()` | Grows/shrinks dynamically |
| `newSingleThreadExecutor()` | Single thread, sequential |
| `newScheduledThreadPool(n)` | For scheduled tasks |

**Way 5 — ScheduledExecutorService**
- `scheduleAtFixedRate` — timer from **start** of last run (can overlap).
- `scheduleWithFixedDelay` — timer from **end** of last run (no overlap).

**Way 6 — CompletableFuture**
- Non-blocking chaining. Runs on `ForkJoinPool.commonPool()` by default.
- Key methods: `supplyAsync`, `thenApply`, `thenCompose`, `thenCombine`, `exceptionally`, `allOf`, `anyOf`.

**Way 7 — ForkJoinPool**
- Divide-and-conquer, CPU-bound tasks. Uses **work-stealing** — idle threads steal from busy threads.
- `RecursiveTask<V>` returns value. `RecursiveAction` does not.

**Way 8 — Lambda / Anonymous**
- Syntactic sugar for Runnable. Most common shorthand in modern Java.

**Way 9 — Virtual Threads (Java 21)**

| | Platform Thread | Virtual Thread |
|---|---|---|
| Mapping | 1:1 OS thread | M:N (JVM managed) |
| Stack size | ~1 MB | Very small |
| Scale | Thousands | Millions |
| Best for | CPU-bound | I/O-bound |

- When VT blocks on I/O → carrier thread released → serves other VTs.
- **Thread pinning:** `synchronized` + I/O blocks carrier thread. Fix: use `ReentrantLock`.

---

## Top 10 Interview Q&A

**Q1: Why prefer Runnable over extends Thread?**
Single inheritance — extending Thread locks out other classes. Runnable separates task from thread.

**Q2: Runnable vs Callable?**
Runnable returns void, no checked exceptions. Callable returns value and throws checked exceptions.

**Q3: What if you call run() instead of start()?**
Runs on current thread synchronously — no new thread created.

**Q4: shutdown() vs shutdownNow()?**
`shutdown()` — completes submitted tasks, no new ones. `shutdownNow()` — interrupts running tasks immediately.

**Q5: scheduleAtFixedRate vs scheduleWithFixedDelay?**
FixedRate triggers from task start (overlap risk). FixedDelay waits for task end before delay (no overlap).

**Q6: CompletableFuture vs Future?**
Future blocks on `get()`. CompletableFuture supports non-blocking chaining, combining, exception handling.

**Q7: What is work-stealing in ForkJoinPool?**
Idle threads steal tasks from busy threads' deques — maximizes CPU utilization.

**Q8: Virtual Thread vs Platform Thread?**
Platform = 1:1 OS thread, expensive. Virtual = M:N JVM-managed, millions can run, best for I/O-bound tasks.

**Q9: What is thread pinning?**
Virtual thread stuck to carrier thread inside `synchronized` + blocking I/O. Fix with `ReentrantLock`.

**Q10: ForkJoinPool vs ExecutorService?**
ForkJoinPool for recursive CPU-bound tasks. ExecutorService for independent task queues (simpler, I/O-friendly).
 
---
*Java 5: Callable/Executor | Java 8: CompletableFuture | Java 21: Virtual Threads*