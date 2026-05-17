# Day 10 — Arrays, ArrayList, wrappers, `final`, `super` (memory + depth)

Deep notes before frameworks (Spring, etc.). One demo file per concept in this folder.

---

## 1. Arrays — memory workflow

### What an array is

- **Fixed length** once created.
- **Contiguous** slots: `int[]` holds `int` values inline; `String[]` holds **references** to `String` objects on heap.
- Variable `arr` on **stack** → reference; **array object** on **heap** (header + elements).

### Access

- `arr[i]` — index bounds checked at **runtime** (`ArrayIndexOutOfBoundsException`).
- Length: `arr.length` (field, not method).

### Aliasing

- `int[] b = a` — two references, **one** array object. Change via `b` visible in `a` (`01_ArraysMemoryDemo.java`).

### vs ArrayList

- Array: fixed size, can hold primitives directly.
- ArrayList: grows, only **objects** (wrappers for primitives), more overhead, richer API.

---

## 2. ArrayList — memory workflow

### Structure (conceptual)

- `ArrayList` object on heap contains:
  - Internal **Object[] elementData** (backing array).
  - **size** (logical count), **modCount** (for fail-fast iterators).
- `add` when full: allocate **larger** array, copy elements (amortized O(1) per add).

### References

- `ArrayList<String> list` — reference on stack → one ArrayList instance.
- Elements are references to `String` objects (or `null` slots).

### Operations and memory

- `get(i)` / `set(i, e)` — O(1) index into backing array.
- `add` end — usually O(1); occasional resize O(n).
- `remove` middle — shift elements left (O(n)).

**Why depth matters for frameworks:** Spring and JPA often return `List`; knowing backing structure helps with performance and concurrency.

---

## 3. Wrapper classes — memory workflow

### Mapping

| Primitive | Wrapper |
|-----------|---------|
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| … | … |

### Autoboxing / unboxing

- **Autobox:** `Integer x = 5;` — JVM creates or reuses `Integer` object, stack/local holds **reference**.
- **Unbox:** `int n = x;` — read primitive from object; **NPE** if `x` is `null`.

### Where memory goes

- **Primitive** local: often stack slot in frame.
- **Wrapper** reference: stack slot → **heap object** (value + object header).

### `Integer.valueOf` cache

- For `int` in **-128..127** (by spec for `Integer`), `valueOf` may return **same cached instance** → `==` can be true (`03_WrapperClassesMemoryDemo.java`).
- Outside cache, new objects → use **`equals`** for value comparison, not `==`.

### Why wrappers exist

- Collections need objects (`List<Integer>`).
- Nullable numeric fields (`Integer` can be `null`, `int` cannot).
- APIs (generics, reflection).

---

## 4. `final` keyword — depth

### `final` variable

- Assign **once** (declaration or constructor for fields).
- For references: reference cannot be reassigned; **object contents** may still change unless immutable.

### `final` method

- Cannot be **overridden** in subclass (used when behavior must stay fixed).

### `final` class

- Cannot be **extended** (e.g. `String`, `Integer` — security and design).

### Memory / JVM

- `final` fields can have special initialization rules in constructor; JVM may optimize. Main benefit is **design clarity** and thread-safe publication patterns (advanced).

---

## 5. `super` keyword — depth

### `super()` in constructor

- First line in subclass constructor (unless another constructor chains) runs **parent constructor**.
- Parent part of object must be initialized before subclass fields are fully usable.

### `super.method()` / `super.field`

- Call **parent version** of overridden method or access hidden parent field.
- Used when extending, not replacing, parent behavior (`05_SuperKeywordDemo.java`).

### With polymorphism

- `super.start()` calls parent implementation; virtual calls from outside still use runtime type for normal `ref.method()`.

---

## 6. How today’s topics connect (JVM picture)

```
Stack frame (main)
  ├── ref numbers  ──► int[] array object on heap [10, 20, 30]
  ├── ref list     ──► ArrayList object ──► Object[] backing ──► String objects...
  ├── ref boxed    ──► Integer object { value: 42 }
  └── ref car      ──► CarSuper object ──► includes VehicleSuper part in same object layout
```

- **Single object** for subclass includes superclass fields (layout is JVM-defined).
- **GC** reclaims heap objects when no references remain.

---

## 7. Path to frameworks (why this depth)

- **Spring beans** are objects on heap; **injection** passes references.
- **Immutability** (`final` fields, records later) reduces bugs in multi-threaded web apps.
- **Lists** from APIs are often `ArrayList`; knowing resize/copy helps performance tuning.
- **Null** on wrappers and unboxing causes production NPEs — understand before debugging Spring stack traces.

---

## 8. Demo files

| File | Topic |
|------|--------|
| `01_ArraysMemoryDemo.java` | Fixed array, index access, aliasing |
| `02_ArrayListMemoryWorkflowDemo.java` | Growable list, shared reference |
| `03_WrapperClassesMemoryDemo.java` | Autobox, cache, `==` vs `equals` |
| `04_FinalKeywordDemo.java` | final class, field, method |
| `05_SuperKeywordDemo.java` | `super(brand)`, `super.start()` |

## 9. Revision checklist

- Where does an array object live vs the reference variable?
- What happens internally when `ArrayList` runs out of space?
- Why can `Integer a == b` be true for 127 but not 128?
- `final` reference vs immutable object?
- When must `super(...)` appear in a constructor?
