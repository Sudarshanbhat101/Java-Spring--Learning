/**
 * Reference casting: upcast (implicit) and downcast (explicit) with instanceof.
 */
class AnimalRef {
    void speak() {
        System.out.println("Animal sound");
    }
}

class DogRef extends AnimalRef {
    @Override
    void speak() {
        System.out.println("Woof");
    }

    void fetch() {
        System.out.println("Dog fetches ball");
    }
}

class TypeCastingReferenceDemo {

    public static void main(String[] args) {
        AnimalRef animal = new DogRef(); // upcast: subclass -> superclass reference
        animal.speak();

        if (animal instanceof DogRef) {
            DogRef dog = (DogRef) animal; // downcast: recover subclass type
            dog.fetch();
        }
    }
}
