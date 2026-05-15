import java.util.ArrayList;
import java.util.List;

/**
 * Generics: type-safe collections and methods at compile time (no raw types).
 */
class GenericsDemo {

    static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    static <T extends Number> double sumNumbers(List<T> numbers) {
        double total = 0;
        for (T n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Generics");
        System.out.println("List: " + names);

        printTwice(42);
        printTwice("hello");

        List<Integer> ints = List.of(10, 20, 30);
        System.out.println("sumNumbers: " + sumNumbers(ints));
    }
}
