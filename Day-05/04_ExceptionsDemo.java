import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Exceptions: try / catch / finally, checked vs unchecked.
 * Logical errors (wrong algorithm) are not exceptions — they are bugs.
 */
class ExceptionsDemo {

    static void runtimeExample() {
        try {
            int result = 10 / 0; // ArithmeticException at runtime
            System.out.println(result);
        } catch (ArithmeticException ex) {
            System.out.println("Caught runtime (unchecked): " + ex.getClass().getSimpleName());
        } finally {
            System.out.println("finally runs after try/catch.");
        }
    }

    static void checkedExample() {
        try {
            String content = Files.readString(Path.of("nonexistent-file-day05.txt"));
            System.out.println(content);
        } catch (IOException ex) {
            System.out.println("Caught checked: " + ex.getClass().getSimpleName() + " — " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        runtimeExample();
        checkedExample();
        System.out.println("Compile-time errors are fixed before run (e.g. type mismatch); no try/catch for those.");
    }
}
