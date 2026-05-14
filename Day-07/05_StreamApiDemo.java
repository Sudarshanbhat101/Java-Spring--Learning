import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API: pipeline of operations on a data source (often collections).
 * Intermediate ops are lazy; terminal ops trigger evaluation.
 */
class StreamApiDemo {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 7, 1, 7, 2, 9, 4);

        // filter, map, sorted, distinct, limit, skip
        List<Integer> transformed = numbers.stream()
                .filter(n -> n > 2)
                .map(n -> n * 10)
                .sorted()
                .distinct()
                .skip(1)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("filter/map/sorted/distinct/skip/limit -> " + transformed);

        // forEach (terminal)
        System.out.print("forEach: ");
        Stream.of("a", "b").forEach(s -> System.out.print(s + " "));
        System.out.println();

        // reduce
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("reduce sum: " + sum);

        // count, anyMatch, allMatch, noneMatch
        long count = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println("count evens: " + count);
        System.out.println("anyMatch > 8? " + numbers.stream().anyMatch(n -> n > 8));
        System.out.println("allMatch positive? " + numbers.stream().allMatch(n -> n > 0));

        // findFirst, min, max (Optional)
        Optional<Integer> first = numbers.stream().sorted().findFirst();
        System.out.println("findFirst: " + first.orElse(null));
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("max: " + max.orElse(null));

        // IntStream range + map + sum
        int triangleSum = IntStream.rangeClosed(1, 5).sum();
        System.out.println("IntStream 1..5 sum: " + triangleSum);

        // collect joining
        String joined = Stream.of("java", "streams").collect(Collectors.joining(", "));
        System.out.println("Collectors.joining: " + joined);
    }
}
