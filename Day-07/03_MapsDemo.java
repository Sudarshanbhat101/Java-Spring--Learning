import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map: key → value, keys unique. HashMap, LinkedHashMap, TreeMap.
 */
class MapsDemo {

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("alice", 90);
        scores.put("bob", 85);
        scores.put("alice", 92); // overwrites
        System.out.println("HashMap: " + scores);
        System.out.println("get bob: " + scores.get("bob"));
        System.out.println("containsKey carol? " + scores.containsKey("carol"));

        Map<String, Integer> ordered = new LinkedHashMap<>();
        ordered.put("z", 1);
        ordered.put("a", 2);
        System.out.println("LinkedHashMap (insertion order): " + ordered);

        Map<Integer, String> rank = new TreeMap<>();
        rank.put(3, "bronze");
        rank.put(1, "gold");
        rank.put(2, "silver");
        System.out.println("TreeMap (sorted by key): " + rank);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
