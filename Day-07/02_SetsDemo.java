import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set: no duplicate elements. HashSet (unordered), LinkedHashSet (insertion order), TreeSet (sorted).
 */
class SetsDemo {

    public static void main(String[] args) {
        Set<Integer> hash = new HashSet<>();
        hash.add(3);
        hash.add(1);
        hash.add(3);
        System.out.println("HashSet: " + hash);

        Set<String> linked = new LinkedHashSet<>();
        linked.add("second");
        linked.add("first");
        linked.add("second");
        System.out.println("LinkedHashSet (insertion order): " + linked);

        Set<Integer> tree = new TreeSet<>();
        tree.add(30);
        tree.add(10);
        tree.add(20);
        System.out.println("TreeSet (sorted): " + tree);

        System.out.println("hash contains 1? " + hash.contains(1));
        hash.remove(1);
        System.out.println("after remove 1: " + hash);
    }
}
