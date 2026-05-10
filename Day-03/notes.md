# Day 03 Notes

Today focused on object-oriented concepts heavily used in backend Java codebases.

## 1) Inheritance (Single, Multilevel)

### Single inheritance
- One child class extends one parent class.
- Child gets access to parent's non-private members.
- Supports code reuse and cleaner domain modeling.

### Multilevel inheritance
- A class extends a class that already extends another class.
- Example chain: `Animal -> Dog -> Puppy`.
- Each level adds behavior while keeping reusable base logic.

### Practice files
- `01_SingleInheritanceDemo.java`
- `02_MultilevelInheritanceDemo.java`

## 2) `this`, `super`, and `final` keyword

### `this`
- Refers to current object.
- Commonly used when constructor parameters and fields have same names.
- Helps avoid ambiguity: `this.name = name`.

### `super`
- Refers to immediate parent class object.
- Used to call parent constructor (`super()`).
- Used to access parent fields/methods when needed.

### `final`
- `final` variable: assigned once.
- `final` method: cannot be overridden.
- `final` class: cannot be extended.

### Practice files
- `03_ThisKeywordDemo.java`
- `04_SuperAndFinalKeywordDemo.java`

## 3) Method overriding and accessing parent method using `super`

### Method overriding
- Child class provides its own implementation of parent method.
- Method signature must match parent method.
- Enables runtime polymorphism.

### Accessing parent method with `super`
- In overridden methods or helper methods, `super.methodName()` calls parent version.
- Useful when extending parent behavior instead of fully replacing it.

### Practice files
- `05_MethodOverridingDemo.java`
- `06_SuperMethodAccessDemo.java`

## 4) Packages and importing packages

### Why packages
- Organize related classes.
- Avoid class-name conflicts.
- Improve maintainability in large projects.

### Importing
- Use `import package.ClassName;` to avoid fully qualified names.
- Wildcard import (`*`) imports classes in a package (not subpackages).

### Practice files
- `07_ImportJavaUtilPackageDemo.java`
- `08_ImportJavaTimePackageDemo.java`

## 5) Access modifiers (`protected`, default)

### Default (package-private)
- No keyword means class/member is accessible only within same package.
- Good for internal helpers not meant for public API.

### `protected`
- Accessible within same package.
- Also accessible in subclasses (even in different packages).
- Frequently used in framework/base-class extension patterns.

### Practice files
- `09_DefaultAccessModifierDemo.java`
- `10_ProtectedAccessModifierDemo.java`

## Quick revision checklist
- Can you explain single vs multilevel inheritance with one real-world example?
- Can you distinguish `this` vs `super` in constructors?
- Can you write an overriding example and call parent method using `super`?
- Can you import `java.util.List` and `java.time.LocalDate` correctly?
- Can you explain default vs protected visibility in one sentence each?
