/**
 * Static nested class: like a top-level class scoped inside outer; no implicit outer instance.
 */
class OuterStatic {
    private static String region = "IN";

    static class Config {
        static void printRegion() {
            System.out.println("Nested static sees: " + region);
        }
    }
}

class InnerClassStaticNestedDemo {

    public static void main(String[] args) {
        OuterStatic.Config.printRegion();
    }
}
