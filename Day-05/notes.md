# Day 05 — Theory notes (no code)

Deep notes on **exceptions vs errors**, **handling**, **lambdas**, **polymorphism**, and **wrapper classes**. Use the numbered `.java` files in this folder only when you want runnable demos.

---

## 1. Throwable hierarchy: `Error` vs `Exception`

In Java, both **errors** and **exceptions** extend `java.lang.Throwable`.

### `Error` (serious JVM / environment failures)

- Examples: `OutOfMemoryError`, `StackOverflowError`, `VirtualMachineError`.
- Usually **not meant to be caught** in application code: they signal the JVM or environment is in a bad state; catching them rarely fixes the root cause and can hide serious problems.
- They are **unchecked** — the compiler does not require `throws` or `try/catch` for them.

### `Exception` (conditions your program might recover from or report cleanly)

- Broad category for problems you **can** sometimes handle: invalid input, missing file, network timeout, business rule violation.
- Split into **checked** and **unchecked** (see below).

**Plain-language difference**

- **Exception:** “Something went wrong in the **application** flow; you might catch it, log it, retry, or show a message.”
- **Error:** “Something went wrong at a **JVM / system** level; you usually don’t ‘handle’ it like a normal branch — you fix memory, config, or infinite recursion.”

---

## 2. Exception types (what the compiler and runtime care about)

### Checked exceptions

- Extend `Exception` but **not** `RuntimeException`.
- Examples: `IOException`, `SQLException`.
- The **compiler requires** you either:
  - **catch** them in `try/catch`, or  
  - **declare** them with `throws` on the method (pushing responsibility to the caller).

**Why they exist:** For failures that are **expected** in I/O and external systems, Java forces you to think about failure paths in the API contract.

### Unchecked exceptions (runtime exceptions)

- Extend `RuntimeException`.
- Examples: `NullPointerException`, `IllegalArgumentException`, `ArithmeticException`, `IndexOutOfBoundsException`.
- The compiler **does not** force `throws` or `try/catch`.
- Often indicate **programming mistakes** or violated preconditions (e.g. null where an object was required).

### “Logical errors” (not exceptions)

- Wrong formula, wrong loop bound, inverted condition: the program **runs** but produces **wrong results**.
- No `Throwable` is thrown unless you **explicitly** throw (e.g. `throw new IllegalStateException(...)`).
- Handled with **tests**, code review, logging of domain invariants — not with `catch` alone.

### Compile-time errors (not exceptions at runtime)

- Syntax/type errors the **compiler** rejects before the program runs.
- Fixed by editing code; **not** handled with `try/catch`.

---

## 3. Exception handling in Java (mechanisms and intent)

### `try / catch / finally`

- **`try`:** Block where an exception might occur.
- **`catch`:** Handles a specific type (or superclass) of `Throwable` thrown from `try`. You can have multiple `catch` blocks — **most specific types first**, then more general.
- **`finally`:** Runs after `try` whether an exception occurred or not (almost always — see JVM shutdown edge cases). Use for **cleanup** (e.g. closing resources if not using try-with-resources).

### `try-with-resources` (Java 7+)

- For `AutoCloseable` resources (e.g. streams, connections): compiler generates safe close logic. Prefer this over manual `finally` for I/O.

### `throws` on a method signature

- Declares: “this method may propagate a **checked** exception; callers must handle or declare.”
- Part of the **API contract** for libraries and teams.

### `throw` (statement)

- Actively signals failure: `throw new IllegalArgumentException("age must be positive");`
- Use for **invalid arguments or illegal state** you detect in code (defensive programming, domain rules).

### Good practices (recruiter / production minded)

- Catch **specific** types; avoid empty `catch` blocks and broad `catch (Exception e)` unless you rethrow or log at boundary layers.
- Preserve cause: `throw new ServiceException("...", e)` when wrapping.
- **Don’t** use exceptions for normal control flow (performance and readability).
- For public APIs, document checked exceptions and when unchecked ones are thrown.

---

## 4. “Error handling” vs “exception handling” (wording)

- **Exception handling** usually means: `try/catch/finally`, `throws`, designing failure paths — in Java, centered on `Exception` subclasses.
- **Error handling** in everyday speech often means “handling all failures” (including logical bugs, validation, HTTP 4xx/5xx). In Java, **errors (`Error`)** are a narrow technical category; you still “handle errors” in a product sense via **validation, return types (e.g. `Optional`), logging, retries, circuit breakers** — not only `try/catch`.

---

## 5. Lambda expressions — uses and why they matter

### What they are

- Syntax for implementing a **functional interface** (single abstract method) without writing a full anonymous class.
- Encourage **behavior as data**: pass sorting strategy, predicates, async tasks, stream operations.

### Common uses

- **Collections / Streams:** `filter`, `map`, `forEach`, `sorted` with small bits of logic.
- **Callbacks:** run after an event (UI, async completion) when modeled as functional types.
- **APIs designed for lambdas:** `Comparator.comparing`, `Runnable`, `Supplier`, `Predicate`, etc.

### Why recruiters / teams care

- Modern Java (8+) codebases use lambdas and streams heavily; reading and writing them is a baseline skill.
- Less boilerplate than anonymous classes → clearer intent when the behavior is short.
- Fits **functional-style** patterns that appear in Spring and reactive libraries (conceptually, not always identical API).

### When not to use a lambda

- Logic is long or has many branches → a **named method** or class improves readability and testability.

---

## 6. Polymorphism — importance (beyond “same method name”)

### Definition (runtime polymorphism)

- Same **operation** (method call through a supertype reference), **different behavior** depending on the **actual object** at runtime (typically via **method overriding**).

### Why it matters in real systems

- **Open/closed idea:** depend on abstractions (`PaymentProcessor`, `Repository`) and plug implementations without changing every caller.
- **Testing:** substitute fakes/mocks implementing the same interface.
- **Frameworks:** Spring wires interfaces/implementations; web layers call services through types, not concrete classes everywhere.

### Relation to other ideas

- **Overloading** = compile-time polymorphism (same name, different parameters).
- **Overriding + supertype reference** = runtime polymorphism (focus for “importance of polymorphism” in OOP interviews).

---

## 7. Wrapper classes — role and importance

### What they are

- Object types for primitives: `Integer`, `Long`, `Double`, `Boolean`, `Character`, etc.

### Why they exist

- **Collections** store objects: `List<Integer>` not `List<int>` (until specialized APIs; classic APIs use wrappers).
- **Nullability:** a wrapper reference can be `null` to mean “missing”; primitives always have a default value.
- **APIs** that need objects: reflection, generics, some libraries.

### Autoboxing and unboxing

- Compiler automatically converts `int` ↔ `Integer` where context allows — convenient but can hide **NPE** if `Integer` is null and unboxed to `int`.

### Caching and `valueOf` vs `parseInt`

- `Integer.valueOf(127)` may reuse cached instances for small integers; `new Integer(...)` is deprecated / disfavored.
- `Integer.parseInt(String)` returns **`int`**; `Integer.valueOf(String)` returns **`Integer`** — choose based on whether you need an object or a primitive.

### Interview / production note

- Be aware of **performance** (accidental boxing in tight loops) and **null** when using wrappers in hot paths or APIs.

---

## 8. One-page revision map

| Idea | Remember one line |
|------|---------------------|
| `Error` | JVM/system-level; don’t treat like normal app flow. |
| Checked `Exception` | Compiler forces handle or `throws`. |
| `RuntimeException` | Unchecked; often precondition / bug signal. |
| Logical bug | No throw; fix with tests / design. |
| Lambda | Short implementation of a functional interface. |
| Polymorphism | Same call, actual subtype decides behavior. |
| Wrapper | Object form of primitive; collections, null, APIs. |

---

## Link to this day’s demos (optional)

Runnable examples for these topics live in `01_`–`04_` `*.java` in this folder; this file is **theory-only** for deeper reading and interview prep.
