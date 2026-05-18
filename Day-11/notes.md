# Day 11 — Wrapper classes (in depth)

Complete notes on **boxing**, **unboxing**, **autoboxing**, **`parseInt`**, **`valueOf`**, and **NullPointerException** when unboxing.

**Demo:** `01_WrapperClassesInDepthDemo.java`

---

## 1. What wrapper classes are

Every primitive has a matching **wrapper class** (object type):

| Primitive | Wrapper | `parse*` (→ primitive) | `valueOf` (→ wrapper) |
|-----------|---------|--------------------------|------------------------|
| `byte` | `Byte` | `Byte.parseByte` | `Byte.valueOf` |
| `short` | `Short` | `Short.parseShort` | `Short.valueOf` |
| `int` | `Integer` | **`Integer.parseInt`** | **`Integer.valueOf`** |
| `long` | `Long` | `Long.parseLong` | `Long.valueOf` |
| `float` | `Float` | `Float.parseFloat` | `Float.valueOf` |
| `double` | `Double` | `Double.parseDouble` | `Double.valueOf` |
| `boolean` | `Boolean` | `Boolean.parseBoolean` | `Boolean.valueOf` |
| `char` | `Character` | — (use `charAt` on String) | `Character.valueOf` |

Wrapper objects live on the **heap**; locals hold **references**.

---

## 2. Boxing and unboxing (manual)

**Boxing** — primitive → wrapper object:

```java
Integer x = Integer.valueOf(10);
// older style: new Integer(10) — deprecated, prefer valueOf
```

**Unboxing** — wrapper → primitive:

```java
int n = x.intValue();
```

Each wrapper exposes `xxxValue()` (`intValue`, `doubleValue`, …).

---

## 3. Autoboxing and auto-unboxing

Compiler inserts calls automatically (Java 5+):

```java
Integer a = 5;        // autobox: Integer.valueOf(5)
int b = a;            // auto-unbox: a.intValue()
```

Used heavily with **collections** (`List<Integer>`), **generics**, and **operators** on wrappers (compiler unboxes, computes, may rebox).

---

## 4. `Integer.parseInt` vs `Integer.valueOf`

| API | Returns | Use when |
|-----|---------|----------|
| **`Integer.parseInt(String s)`** | **`int`** (primitive) | You need a primitive; parsing user input, file text |
| **`Integer.valueOf(String s)`** | **`Integer`** (object) | You need a wrapper; putting into `List<Integer>`, nullable field |
| **`Integer.valueOf(int i)`** | **`Integer`** | Boxing a primitive without parsing text |

Both throw **`NumberFormatException`** if the string is not a valid number (unchecked).

```java
int p = Integer.parseInt("123");
Integer w = Integer.valueOf("123");
```

**Do not confuse** `parseInt` with `valueOf` return types.

---

## 5. `valueOf` and the Integer cache

`Integer.valueOf(int)` for values **-128 to 127** (inclusive) may return **cached** instances → `==` can be **true** for same value.

Outside that range, new objects (or different instances) → **`==` is false** even if values equal → use **`equals`**.

```java
Integer a = Integer.valueOf(127);
Integer b = Integer.valueOf(127);
System.out.println(a == b); // often true

Integer c = Integer.valueOf(128);
Integer d = Integer.valueOf(128);
System.out.println(c == d);       // false
System.out.println(c.equals(d));  // true
```

**Rule:** Compare wrapper **values** with **`equals`**, not `==` (unless you intentionally mean same object identity).

---

## 6. NullPointerException (NPE) and wrappers

A **primitive `int` cannot be null**. An **`Integer` reference can be null**.

Dangerous patterns:

```java
Integer x = null;
int n = x;              // auto-unboxing → NPE
if (x == 1) { ... }     // unboxing x for comparison → NPE
```

Safe patterns:

```java
if (x != null && x == 1) { ... }
int safe = (x != null) ? x : 0;
Optional.ofNullable(x).orElse(0); // later topic
```

Common in APIs: `Map.get` returns `null` → unboxing causes NPE in production.

---

## 7. Memory workflow (quick)

1. `Integer ref = 42;` — autobox may use cache or allocate on heap.
2. Stack/local: **reference** `ref`.
3. Heap: **Integer object** holding `int` value + object header.
4. `int n = ref;` — read object, extract primitive (NPE if `ref == null`).

Collections store **references** to wrapper objects, not raw `int` inline (unless specialized structures like primitive streams).

---

## 8. Useful wrapper methods (examples)

- **`Integer.toString(int)`** / **`String.valueOf(int)`** — primitive to String.
- **`Integer.compare(int a, int b)`** — compare without objects.
- **`Integer.MAX_VALUE` / `MIN_VALUE`** — constants.
- **`Boolean.logicalAnd`** etc. — utility methods on wrappers.

---

## 9. Interview / production checklist

- Difference between **boxing** and **autoboxing**?
- **`parseInt` vs `valueOf`** return types?
- Why **`==`** on `Integer(128)` pairs can fail?
- When does **NPE** happen with wrappers?
- Why use wrappers in **`List<Integer>`** instead of `List<int>`?

---

## 10. Link to frameworks

Spring/JPA often use **wrapper types** for nullable DB columns (`Integer` salary vs `int`). Unboxing without null checks is a top cause of NPE in enterprise apps — this day’s depth pays off before Spring.
