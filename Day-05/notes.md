# Day 05 Notes

One numbered file per **concept**; multiple small examples can live inside the same file.

## 1) Lambda expressions

- Syntax: `(params) -> { body }` or `(params) -> expression`.
- Works with **functional interfaces** (exactly one abstract method), e.g. `Runnable`, `Comparator`, or your own `@FunctionalInterface`.
- **Method references** (`System.out::println`) are shorthand when a lambda only forwards to one method.

**File:** `01_LambdaExpressionsDemo.java`

---

## 2) Polymorphism

- **Compile-time type** (e.g. `Notification ref`) vs **runtime type** (`new EmailNotification()`).
- Calling `ref.send(...)` runs the **overridden** method of the actual object — same method name, different behavior.
- Enables flexible APIs: pass “the kind of thing” without branching on every subtype.

**File:** `02_PolymorphismDemo.java`

---

## 3) Wrapper classes

- Each primitive has a wrapper: `int` ↔ `Integer`, `double` ↔ `Double`, etc.
- **Autoboxing:** primitive assigned to wrapper (or passed where wrapper expected).
- **Unboxing:** wrapper used as primitive.
- `Integer.parseInt(String)` returns `int`; `Integer.valueOf(String)` returns `Integer` (cached for small values).

**File:** `03_WrapperClassDemo.java`

---

## 4) Exceptions, try / catch, and “kinds” of problems

### Compile-time errors

- Violations the **compiler** catches: missing semicolon, wrong types, unknown symbols.
- **Not** handled with `try/catch` — you fix the code and recompile.

### Runtime exceptions (unchecked)

- Extend `RuntimeException` (e.g. `ArithmeticException`, `NullPointerException`).
- Compiler does not force you to declare them; still use `try/catch` when you can recover or add context.

### Checked exceptions

- Extend `Exception` but not `RuntimeException` (e.g. `IOException`).
- Caller must **catch** or **declare** (`throws`) — compiler enforces handling.

### Logical errors

- Program runs but **wrong answer** (off-by-one, wrong formula). **No exception** is thrown — use tests, reviews, debuggers.

**File:** `04_ExceptionsDemo.java` (unchecked `ArithmeticException` in `try/catch/finally`, checked `IOException` on missing file)

---

## Quick checklist

- When is a lambda better than an anonymous class?
- What is the difference between `parseInt` and `valueOf`?
- Why does polymorphism rely on overriding + superclass reference?
- Checked vs unchecked: which must appear in `throws` or try/catch?
