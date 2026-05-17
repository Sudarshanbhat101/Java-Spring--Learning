/**
 * Wrapper classes: object on heap holds primitive value; autoboxing creates objects.
 */
class WrapperClassesMemoryDemo {

    public static void main(String[] args) {
        int primitive = 42;
        Integer boxed = primitive;           // autobox: Integer object on heap
        int unboxed = boxed;                 // unbox: read int value from object

        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);    // may share cached instance for small ints
        Integer c = Integer.valueOf(128);
        Integer d = Integer.valueOf(128);

        System.out.println("127 cache: a==b ? " + (a == b));
        System.out.println("128 no cache: c==d ? " + (c == d));
        System.out.println("128 equals: " + c.equals(d));

        Integer fromNew = Integer.valueOf(50);
        System.out.println("boxed intValue: " + fromNew.intValue());
    }
}
