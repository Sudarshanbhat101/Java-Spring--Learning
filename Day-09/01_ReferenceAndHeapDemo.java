/**
 * Reference (variable) vs object (instance on heap).
 * Variable holds an address; object lives in heap memory.
 */
class ReferenceAndHeapDemo {

    static class Box {
        int value;

        Box(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Box a = new Box(10); // reference 'a' -> Box object on heap
        Box b = a;           // second reference, same object
        b.value = 99;

        System.out.println("a.value = " + a.value); // 99 — one object, two references
        System.out.println("a == b ? " + (a == b)); // true — same heap address

        Box c = new Box(10); // new object
        System.out.println("a == c ? " + (a == c)); // false — different objects
        System.out.println("a.value == c.value ? " + (a.value == c.value)); // true — same field data
    }
}
