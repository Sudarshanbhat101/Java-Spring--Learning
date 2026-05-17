import java.util.ArrayList;

/**
 * ArrayList: dynamic array on heap; internal Object[] grows when full (amortized copy).
 */
class ArrayListMemoryWorkflowDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // reference on stack -> ArrayList object on heap
        list.add("alpha");
        list.add("beta");
        list.add("gamma"); // may trigger internal array resize (new larger backing array)

        System.out.println("size: " + list.size());
        System.out.println("get(1): " + list.get(1));

        list.set(1, "BETA");
        list.remove(0);
        System.out.println("after set/remove: " + list);

        ArrayList<String> sameRef = list;
        sameRef.add("delta");
        System.out.println("list and sameRef share one ArrayList: " + list);
    }
}
