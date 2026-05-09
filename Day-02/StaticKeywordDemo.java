/**
 * Demonstrates the `static` keyword in Java:
 * - static variable: one copy per class, shared by all instances
 * - static method: belongs to the class; can use static fields without an object
 * - static block: runs once when the class is loaded
 */
class Sample {

    // Instance field: each object has its own copy
    private String title;

    // Static field: shared across all Sample instances
    private static int objectCount = 0;

    static {
        System.out.println("Static block ran: class Sample is loading.");
    }

    Sample(String title) {
        this.title = title;
        objectCount++;
    }

    static int getTotalObjectsCreated() {
        return objectCount;
    }

    void displayTitle() {
        System.out.println("Instance: " + title);
    }

    static void utilityMessage() {
        System.out.println("This is a static method. Use it without creating an object.");
    }
}

public class StaticKeywordDemo {

    static int staticNumber = 100;

    public static void main(String[] args) {
        Sample.utilityMessage();
        System.out.println("Objects created so far: " + Sample.getTotalObjectsCreated());

        Sample first = new Sample("First object");
        Sample second = new Sample("Second object");

        first.displayTitle();
        second.displayTitle();

        System.out.println("Total objects after creating two instances: "
                + Sample.getTotalObjectsCreated());

        System.out.println("Static field from main class: " + StaticKeywordDemo.staticNumber);
        showStaticVsInstance();
    }

    /**
     * `static` helper from the same outer class — can be called directly from main.
     */
    static void showStaticVsInstance() {
        System.out.println("Static helper method: no `this`, works at class level.");
    }
}
