import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * try / catch / finally, multiple catch, try-with-resources.
 */
class TryCatchFinallyDemo {

    static void divideSafely(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Caught: " + ex.getClass().getSimpleName());
        } finally {
            System.out.println("finally always runs (after try/catch).");
        }
    }

    static void tryWithResources() {
        Path temp = Path.of("day06_temp_try.txt");
        try {
            Files.writeString(temp, "hello");
            try (var lines = Files.lines(temp)) {
                lines.forEach(line -> System.out.println("Line: " + line));
            }
        } catch (IOException ex) {
            System.out.println("IO problem: " + ex.getMessage());
        } finally {
            try {
                Files.deleteIfExists(temp);
            } catch (IOException ignored) {
                // cleanup best-effort
            }
        }
    }

    public static void main(String[] args) {
        divideSafely(10, 2);
        divideSafely(10, 0);
        tryWithResources();
    }
}
