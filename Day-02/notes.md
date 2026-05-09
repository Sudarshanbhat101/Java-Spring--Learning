# Day 02 Notes

## Files in this folder

| File | Topic |
|------|--------|
| `EncapsulationDemo.java` | Private fields, getters/setters |
| `StudentArrayEnhancedForDemo.java` | Array of objects, enhanced `for` |
| `StringBufferCapacityDemo.java` | `StringBuffer`, `capacity()` |
| `StaticKeywordDemo.java` | `static` fields, methods, static block |

## Encapsulation

- Mark fields `private`; expose access through **getters** and **setters**.
- Protects internal state and is a core OOP practice for maintainable code.

## Array of objects + enhanced for

- `Student[]` holds references to `Student` instances.
- **Enhanced for:** `for (Student s : members)` — simpler than index loops when you only need each element.

## StringBuffer

- Mutable string builder; `capacity()` shows internal buffer size (related to default capacity + content length).

## Static keyword

- **Static variable:** one copy per class, shared by all instances.
- **Static method:** belongs to the class; call as `ClassName.method(...)`.
- **Static block:** runs once when the class is first loaded.
- Practice: `StaticKeywordDemo.java`.

## Revision tips

- Instance members need `new`; static members belong to the class loading context.
