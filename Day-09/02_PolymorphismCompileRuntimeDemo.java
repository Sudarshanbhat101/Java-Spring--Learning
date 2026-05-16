/**
 * Compile-time type (reference) vs runtime type (actual object).
 * Method call resolved at runtime for instance methods (dynamic dispatch).
 */
class AnimalPoly {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class DogPoly extends AnimalPoly {
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}

class PolymorphismCompileRuntimeDemo {

    public static void main(String[] args) {
        AnimalPoly ref = new DogPoly(); // compile-time type AnimalPoly, runtime type DogPoly

        System.out.println("Compile-time type: " + ref.getClass().getSuperclass().getSimpleName());
        System.out.println("Runtime type: " + ref.getClass().getSimpleName());

        ref.speak(); // runtime dispatch -> DogPoly.speak()

        if (ref instanceof DogPoly) {
            DogPoly dog = (DogPoly) ref; // downcast after check
            dog.speak();
        }
    }
}
