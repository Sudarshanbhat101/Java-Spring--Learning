# Day 09 — OOP, String, and JVM memory (in depth)

Theory-focused notes for interviews and backend Java. Small demos: `01_`–`03_` in this folder.

---

## 1. JVM memory layout (simplified workflow)

When a program runs, the JVM divides memory roughly into:

| Area | What lives here |
|------|------------------|
| **Stack** (per thread) | Local variables, method call frames. **References** to objects are often stored here. |
| **Heap** | **Objects** and arrays (instance data). Shared by threads; managed by **GC**. |
| **Method area / Metaspace** | Class metadata, static fields, constant pool (implementation details vary by JVM version). |
| **PC register / native stack** | Execution bookkeeping (less important at beginner interview level). |

**Workflow when you write `Box b = new Box(5);`**

1. JVM loads class `Box` (if not loaded) — metadata in metaspace.
2. `new Box(5)` allocates memory on the **heap** for one `Box` object; constructor runs.
3. Variable `b` on the **stack** (in `main`’s frame) holds a **reference** (address-like value) pointing to that heap object.
4. When `main` ends, frame pops; if no other reference points to the object, GC can reclaim heap memory later.

**Key idea:** The **variable is not the object**. The variable is a **reference** (pointer) to an object on the heap.

---

## 2. Reference type vs object type (compile-time vs runtime)

```java
Animal ref = new Dog();
```

| Term | Meaning in this line |
|------|----------------------|
| **Reference type** (compile-time type) | `Animal` — what the **compiler** knows about `ref`. You may only call methods visible on `Animal` without cast. |
| **Object type** / **runtime type** | `Dog` — the **actual class** of the object on the heap. |

- **Compile time:** compiler checks `ref.someMethod()` exists on `Animal`.
- **Runtime:** JVM uses the **real object** (`Dog`) for **virtual method dispatch** (overridden instance methods).

**Static methods, private methods, final methods** — binding can be resolved differently (no dynamic override for static).

---

## 3. Compile-time vs runtime (polymorphism)

### Compile-time polymorphism

- **Method overloading** — same name, different parameters. Compiler picks the method at **compile time**.
- **Type checking** — assignments, casts, which methods exist on reference type.

### Runtime polymorphism

- **Method overriding** — subclass replaces superclass behavior.
- Call `ref.speak()` when `ref` is `Animal` but object is `Dog` → **`Dog.speak()`** runs (**dynamic dispatch**).
- Requires: inheritance, instance method, override, assignment of subclass instance to superclass reference.

**Interview one-liner:** Overloading = compile time; overriding + superclass reference = runtime.

---

## 4. How references are accessed

- **Read field / call method:** JVM follows reference → heap object → field or vtable for method.
- **Null reference:** `null` means “points to nothing”. `null.method()` → `NullPointerException` at **runtime**.
- **Aliasing:** two references (`a` and `b`) to same object — change through one visible through other (`01_ReferenceAndHeapDemo.java`).
- **`==` on references:** same object identity (same heap address). **`equals`:** usually logical equality (class-dependent; `String` overrides `equals`).

---

## 5. String — what happens in memory

### Immutability

- `String` objects are **immutable**. `s.toUpperCase()` creates a **new** `String`; `s` unchanged.
- Safe to share across threads without locking (for the String object itself).

### String pool (conceptual)

- String literals like `"hello"` may be interned in a **pool** (implementation: often part of heap / string table in modern JVMs).
- `new String("hello")` typically creates a **new** object on heap even if `"hello"` exists in pool → `==` can differ, `equals` still true (`03_StringJvmMemoryDemo.java`).

### `String` vs `StringBuilder`

- Repeated `+` in loops creates many temporary `String` objects → use **`StringBuilder`** for building (`Day-08`).
- `StringBuilder` is **mutable**; not the same as string pool immutability story.

### `==` vs `equals` for String

- **`==`:** reference equality (same object in memory?).
- **`equals`:** character-by-character content (case-sensitive unless `equalsIgnoreCase`).

---

## 6. Where objects and references are “saved”

| What | Where | Lifetime |
|------|--------|----------|
| Local reference variable `b` | Stack frame of current method | Until method returns |
| Object `new Box()` | Heap | Until no reachable references (GC) |
| Instance fields | Inside object on heap | Same as object |
| Static fields | Metaspace / static storage (with class) | Until class unloaded (rare in apps) |
| String literal / interned | Pool / heap (JVM-dependent) | Long-lived |

**“Reference saves”** = stack slot holds address. **“Object saves”** = heap holds fields + object header.

---

## 7. End-to-end JVM workflow (high level)

1. **Compile** `.java` → `.class` bytecode (compile-time errors here).
2. **Class loader** loads classes when needed.
3. **Bytecode verifier** checks safety.
4. **Interpreter / JIT** executes bytecode; hot code may be JIT-compiled to native.
5. **Heap** allocates objects; **GC** reclaims unreachable objects.
6. **Threads** each have own stack; share heap.

---

## 8. Revision checklist

- Difference between reference variable and object on heap?
- What is compile-time type vs runtime type of a variable?
- Why does `Animal a = new Dog(); a.speak();` call `Dog.speak()`?
- Why is `String` immutable? When use `equals` instead of `==`?
- What happens on `NullPointerException`?

## Demo files

- `01_ReferenceAndHeapDemo.java` — aliasing, `==` on references
- `02_PolymorphismCompileRuntimeDemo.java` — reference vs runtime type, dynamic dispatch
- `03_StringJvmMemoryDemo.java` — pool literal vs `new String`, `equals` vs `==`
