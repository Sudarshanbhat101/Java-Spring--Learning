# Day 02 Notes

## Static keyword

- **Static variable (class variable):**  
  Stored once in memory for the whole class. All objects share the same copy. Declare with `static` inside the class.

- **Static method:**  
  Belongs to the class, not a single object. Called as `ClassName.methodName(...)`. Cannot use non‑static fields directly (`this` is not tied to one instance).

- **Static block:**  
  Runs once when the class is **first loaded** (before `main` if `main` uses that class). Good for class‑level initialization.

- **Why it matters:**  
  Shared counters, utility/helper methods, constants, singleton patterns, and JDK APIs like `Integer.parseInt` are common static use cases.

- **Practice file:** See `StaticKeywordDemo.java`.

## Revision tips

- Instance members need an object (`new ClassName(...)`).
- Static members belong to the class loader’s view of the class — use sparingly where shared state truly fits backend design later.
