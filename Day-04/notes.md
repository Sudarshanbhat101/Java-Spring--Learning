# Day 04 Notes

Today covers core OOP and language features used heavily in Spring and enterprise Java.

## 1) Type casting

### Primitives
- **Widening:** smaller range → larger range (e.g. `int` → `long`) — implicit, safe.
- **Narrowing:** larger → smaller (e.g. `double` → `int`) — requires explicit `(type)`; may lose precision or overflow for `byte`/`short`.

### References
- **Upcast:** subclass instance assigned to superclass reference — implicit (`Dog d = new Dog(); Animal a = d;`).
- **Downcast:** superclass reference back to subclass — explicit cast; use `instanceof` first to avoid `ClassCastException`.

**Files:** `01_TypeCastingPrimitiveDemo.java`, `02_TypeCastingReferenceDemo.java`

---

## 2) Abstraction

- **Abstract class:** cannot be instantiated; may contain abstract methods (no body) and concrete methods.
- Hides implementation details; callers depend on abstract API.
- **Template method pattern:** non-abstract method in abstract class calls abstract steps — shared algorithm, varied steps.

**Files:** `03_AbstractionAbstractClassDemo.java`, `04_AbstractionTemplateMethodDemo.java`

---

## 3) Inner classes

- **Member inner class:** non-static class inside outer; holds implicit reference to outer instance — use `outer.new Inner()`.
- **Static nested class:** `static` inside outer; no outer instance required — use `Outer.Nested` like a namespaced top-level class.

**Files:** `05_InnerClassMemberDemo.java`, `06_InnerClassStaticNestedDemo.java`

---

## 4) Interfaces (important)

- **Contract only:** `implements` — class must provide all abstract methods (before Java 8, all methods were implicitly abstract public).
- **Default and static methods (Java 8+):** `default` methods add behavior without breaking old implementors; `static` methods on interface are utility entry points.
- **Multiple interfaces:** one class can `implements A, B` — supports composition of capabilities (unlike single inheritance for classes).

**Files:** `07_InterfaceContractDemo.java`, `08_InterfaceDefaultStaticDemo.java`, `09_InterfaceMultipleDemo.java`

---

## 5) Enum (enum type and enum constants)

- Enum defines a **fixed set of named constants**; each constant is a **singleton instance** of the enum type.
- `EnumName.CONSTANT`, `ordinal()`, `name()`, `values()`.
- Enums can have **fields, constructors (private by convention), and methods** — useful for status codes, states, strategies.

**Files:** `10_EnumBasicsDemo.java`, `11_EnumConstructorMethodDemo.java`

---

## 6) Annotations

- Metadata attached to code (methods, classes, fields). Compiler and tools can read them.
- **Built-in:** `@Override` (intent + compile check), `@Deprecated` (API warning), `@SuppressWarnings` (scoped compiler suppression).
- **Custom:** `@interface` with `@Retention` (e.g. `RUNTIME` for reflection) and `@Target` (e.g. `METHOD`). Spring uses many custom annotations (`@Component`, `@Autowired`, etc.) built on the same model.

**Files:** `12_AnnotationBuiltInDemo.java`, `13_AnnotationCustomDemo.java`

---

## Quick revision checklist

- When do you need an explicit cast for primitives vs references?
- What is the difference between a member inner class and a static nested class?
- Why are default methods useful on interfaces?
- How is an enum constant different from a `public static final String` constant?
- What does `@Retention(RetentionPolicy.RUNTIME)` enable for a custom annotation?
