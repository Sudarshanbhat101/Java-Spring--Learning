# Day 08 Notes

## 1) Generics (`01_GenericsDemo.java`)

- Write type-safe code: `List<String>` not raw `List`.
- Generic methods: `<T>` on method; bounded type: `<T extends Number>`.
- Catches class-cast mistakes at **compile time**.

## 2) StringBuilder (`02_StringBuilderDemo.java`)

- `String` is immutable; many `+` in loops creates many objects.
- `StringBuilder` is mutable: `append`, `insert`, `reverse`, `toString`.
- Use for building text in loops or many steps.
