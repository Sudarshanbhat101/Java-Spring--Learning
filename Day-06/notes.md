# Day 06 Notes

One numbered file per **concept**; several small examples can live inside the same file.

## 1) Input (`01_InputDemo.java`)

- **`Scanner`:** token-oriented (`nextInt`, `nextLine`, …). Good for simple parsing.
- **`BufferedReader` + `InputStreamReader`:** line-oriented, efficient for large text.
- For real keyboard input, attach to **`System.in`**. The demo uses **`ByteArrayInputStream`** so it runs without blocking when you compile/run non-interactively.

## 2) `try` / `catch` / `finally` (`02_TryCatchFinallyDemo.java`)

- **`try`:** code that might throw.
- **`catch`:** handle specific exception types.
- **`finally`:** runs after `try`/`catch` for cleanup (prefer **try-with-resources** for `Closeable` instead of manual `finally` when possible).
- **`try-with-resources`:** `try (var x = …)` auto-closes at end of block.

## 3) Threads and multithreading (`03_ThreadBasicsDemo.java`)

- **`extends Thread`:** override `run()`, call `start()` (not `run()` directly for a new thread).
- **`implements Runnable`:** pass to `new Thread(runnable)` — preferred when you already extend another class.
- Multiple threads run **concurrently**; output interleaving is normal without synchronization.

## 4) Schedulers (`04_ScheduledExecutorDemo.java`)

- **`ScheduledExecutorService`:** run tasks after a delay or at a fixed rate.
- Prefer over raw `Timer` in new code for better thread-pool control.
- Always **`shutdown()`** (and optionally `awaitTermination`) so the JVM can exit.

## 5) `sleep`, `wait`, `notify` (`05_ThreadSleepWaitNotifyDemo.java`)

- **`Thread.sleep(ms)`:** pauses current thread; **does not release** locks if you hold any.
- **`wait()` / `notify()` / `notifyAll()`:** must be called while holding the **same object’s monitor** (`synchronized (lock)` on that `lock`).
- **`wait(timeout)`:** wake on notify or timeout.

## 6) Priority and `join` (`06_ThreadPriorityJoinDemo.java`)

- **`setPriority`:** hint only; JVM/platform may ignore strict ordering.
- **`join()`:** current thread waits until the target thread finishes — useful for ordering completion in small demos/tests.

## 7) Collections API (`07_CollectionsApiDemo.java`)

- **`Collection<E>`:** root interface for many collections (`add`, `remove`, `size`, …).
- **`List`:** ordered, allows duplicates; indexed access.
- **`Set`:** no duplicates (by `equals`/`hashCode` contract).
- **`Map<K,V>`:** key–value; **not** a `Collection`, but part of the collections framework.
- Common implementations: `ArrayList`, `HashSet`, `HashMap`.

## Quick checklist

- Why call `start()` instead of `run()`?
- Difference between `sleep` and `wait` regarding locks?
- Why must `wait`/`notify` be inside `synchronized` on the same monitor?
- Why shut down a `ScheduledExecutorService`?
