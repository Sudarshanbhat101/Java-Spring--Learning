import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Console input: Scanner (tokens) and BufferedReader (lines).
 * For automated runs, this demo reads from an in-memory stream; for real keyboard input use System.in.
 */
class InputDemo {

    public static void main(String[] args) throws Exception {
        String fakeInput = "Sudarshan\nsecond line\n";
        ByteArrayInputStream source = new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8));

        try (Scanner scanner = new Scanner(source, StandardCharsets.UTF_8)) {
            System.out.print("(Scanner) first token/line: ");
            if (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }

        ByteArrayInputStream source2 = new ByteArrayInputStream("Line A\nLine B\n".getBytes(StandardCharsets.UTF_8));
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(source2, StandardCharsets.UTF_8))) {
            System.out.print("(BufferedReader) readLine: ");
            System.out.println(reader.readLine());
        }

        System.out.println("Tip: replace ByteArrayInputStream with System.in for interactive console programs.");
    }
}
