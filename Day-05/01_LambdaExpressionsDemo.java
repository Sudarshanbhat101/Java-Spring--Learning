import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda expressions: compact syntax for single-method interfaces (functional interfaces).
 */
@FunctionalInterface
interface Greeter {
    void greet(String name);
}

class LambdaExpressionsDemo {

    public static void main(String[] args) {
        // 1) Custom functional interface
        Greeter greeter = (name) -> System.out.println("Hello, " + name + "!");
        greeter.greet("Day-05");

        // 2) Runnable-style (no args)
        Runnable task = () -> System.out.println("Lambda as a task runs.");
        task.run();

        // 3) Comparator with lambda (sort descending)
        List<Integer> numbers = Arrays.asList(5, 1, 9, 3);
        numbers.sort(Comparator.comparingInt(n -> -n));
        System.out.println("Sorted (desc): " + numbers);

        // 4) Method reference (related to lambdas)
        numbers.forEach(System.out::println);
    }
}
