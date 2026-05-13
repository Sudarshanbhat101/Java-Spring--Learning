import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Collections API: Collection (root for many concrete types), List, Set, Map (not Collection).
 */
class CollectionsApiDemo {

    public static void main(String[] args) {
        Collection<String> bag = new ArrayList<>();
        bag.add("java");
        bag.add("threads");
        System.out.println("Collection size: " + bag.size());

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(0, 5);
        System.out.println("List: " + list);

        Set<String> unique = new HashSet<>();
        unique.add("a");
        unique.add("a");
        unique.add("b");
        System.out.println("Set (no duplicates): " + unique);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("alice", 90);
        scores.put("bob", 85);
        System.out.println("Map get: " + scores.get("alice"));
    }
}
