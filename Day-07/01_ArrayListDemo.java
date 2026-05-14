import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList: resizable array implementation of List — fast random access, slower middle insert/remove.
 */
class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add(0, "cherry"); // insert at index
        System.out.println("List: " + items);
        System.out.println("get(1): " + items.get(1));
        System.out.println("size: " + items.size());
        System.out.println("contains banana? " + items.contains("banana"));

        items.set(1, "blueberry");
        items.remove("cherry");
        System.out.println("After set/remove: " + items);

        List<String> view = items.subList(0, items.size());
        System.out.println("subList view: " + view);

        for (String s : items) {
            System.out.println("iterate: " + s);
        }
    }
}
