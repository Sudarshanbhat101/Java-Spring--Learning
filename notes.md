# Master Notes

## Streak Strategy

- Commit only what is completed on the current day.
- Keep each day self-contained in its own folder.
- Prefer clean naming and small focused examples.

## Day 01 Coverage

- Java basics and output
- Methods with and without return values
- Object creation using classes
- Method overloading fundamentals

## Day 02 Coverage

- Encapsulation (private fields, getters/setters)
- Array of objects and enhanced `for` loop
- `StringBuffer` and `capacity()`
- `static` fields, methods, and static initialization blocks

## Day 03 Coverage

- Inheritance: single and multilevel
- `this`, `super`, and `final` keyword usage
- Method overriding and invoking parent methods using `super`
- Package imports from `java.util` and `java.time`
- Access modifiers: default (package-private) and `protected`

## Day 04 Coverage

- Primitive and reference type casting (`instanceof`, downcast)
- Abstraction: abstract classes and template-style methods
- Inner classes: member inner vs static nested
- Interfaces: pure contract, default/static methods (Java 8+), multiple interfaces
- Enum constants, `values()`, enums with fields and constructors
- Annotations: `@Override`, `@Deprecated`, `@SuppressWarnings`, custom `@interface` + reflection

## Day 05 Coverage

- Lambda expressions and functional interfaces
- Runtime polymorphism (overriding + superclass reference)
- Wrapper classes, autoboxing/unboxing, `parseInt` / `valueOf`
- Exceptions: `try`/`catch`/`finally`, checked vs unchecked, compile-time vs logical errors (notes)

## Day 06 Coverage

- Console input (`Scanner`, `BufferedReader`)
- `try` / `catch` / `finally` and try-with-resources
- Threads: `Thread`, `Runnable`, `start`, multithreading basics
- `ScheduledExecutorService` for scheduled tasks
- `Thread.sleep` vs `Object.wait` / `notify` (synchronization)
- Thread priority and `join`
- Collections API: `Collection`, `List`, `Set`, `Map`, common implementations

## Day 07 Coverage

- `ArrayList` operations and iteration
- `Set`: `HashSet`, `LinkedHashSet`, `TreeSet`
- `Map`: `HashMap`, `LinkedHashMap`, `TreeMap`
- `Comparable` natural order vs `Comparator` custom order
- Stream API: intermediate ops (`filter`, `map`, `sorted`, `distinct`, `limit`, `skip`) and terminal ops (`forEach`, `collect`, `reduce`, `count`, `anyMatch`/`allMatch`, `findFirst`, `min`/`max`, `IntStream`, `Collectors.joining`)

## Day 08 Coverage

- Generics: type parameters, generic methods, bounded types (`extends Number`)
- `StringBuilder`: `append`, `insert`, `reverse`, `toString` vs string concatenation

## Day 09 Coverage

- JVM: stack (references, frames) vs heap (objects)
- Reference type vs runtime object type; dynamic method dispatch
- Compile-time (overload, type check) vs runtime (override) polymorphism
- String immutability, pool vs `new String`, `==` vs `equals`

## Day 10 Coverage

- Arrays: heap layout, indexing, aliasing, fixed size
- ArrayList: backing array, growth, references to elements
- Wrapper memory: autobox/unbox, `Integer` cache, `==` vs `equals`
- `final`: variables, methods, classes
- `super`: constructor chaining, parent method/field access
