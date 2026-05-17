/**
 * final: variable (one assignment), method (no override), class (no extend).
 */
final class FinalConfig {
    final int maxRetries;

    FinalConfig(int maxRetries) {
        this.maxRetries = maxRetries; // must assign final field in constructor
    }

    final void printConfig() {
        System.out.println("maxRetries=" + maxRetries);
    }
}

// class Child extends FinalConfig { } // compile error — final class

class FinalKeywordDemo {

    public static void main(String[] args) {
        final int day = 10;
        // day = 11; // compile error — final local

        FinalConfig config = new FinalConfig(3);
        config.printConfig();
    }
}
