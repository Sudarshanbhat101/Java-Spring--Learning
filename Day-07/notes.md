# Day 07 Notes

One numbered file per **concept**.

## 1) `ArrayList` (`01_ArrayListDemo.java`)

- Resizable array; implements `List`. Fast indexed `get`/`set`.
- Common ops: `add`, `add(index, e)`, `remove` (index or object), `get`, `set`, `size`, `contains`, `subList` (view backed by list).

## 2) `Set` (`02_SetsDemo.java`)

- **`HashSet`:** hash table, no order guarantee.
- **`LinkedHashSet`:** insertion order preserved.
- **`TreeSet`:** red-black tree, elements sorted by natural order or `Comparator`.
- No duplicate elements (`equals`/`hashCode` contract).

## 3) `Map` (`03_MapsDemo.java`)

- Key–value; keys unique.
- **`HashMap`:** average O(1) get/put; no key order.
- **`LinkedHashMap`:** insertion or access order (if configured).
- **`TreeMap`:** keys sorted. Iterate `entrySet()`, `keySet()`, `values()`.

## 4) `Comparable` vs `Comparator` (`04_ComparatorComparableDemo.java`)

- **`Comparable<T>`:** implemented by the element type; `compareTo` defines **natural** ordering (`Collections.sort(list)`).
- **`Comparator<T>`:** external ordering; `list.sort(Comparator.comparing(...))`, `reversed()`, `thenComparing`.
- Use `Comparable` when one obvious order; use `Comparator` for alternatives or types you do not own.

## 5) Stream API (`05_StreamApiDemo.java`)

- Create: `collection.stream()`, `Stream.of(...)`, `IntStream.rangeClosed`.
- **Intermediate (lazy):** `filter`, `map`, `flatMap`, `sorted`, `distinct`, `peek`, `limit`, `skip`.
- **Terminal:** `forEach`, `collect`, `reduce`, `count`, `min`/`max`, `findFirst`/`findAny`, `anyMatch`/`allMatch`/`noneMatch`.
- Pipelines are evaluated only when a **terminal** operation runs.

## Quick checklist

- When to pick `ArrayList` vs `LinkedList`?
- Why is `TreeSet` element order defined?
- Difference between `Comparable` and `Comparator`?
- Name two intermediate and two terminal stream operations.
