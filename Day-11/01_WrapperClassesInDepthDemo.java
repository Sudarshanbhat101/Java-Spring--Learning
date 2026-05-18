/**
 * Wrapper classes in depth: boxing, unboxing, autoboxing, valueOf, parseInt, NPE risks.
 */
class WrapperClassesInDepthDemo {

    public static void main(String[] args) {
        // --- Boxing / unboxing (explicit) ---
        int primitive = 100;
        Integer boxed = Integer.valueOf(primitive); // boxing
        int back = boxed.intValue();                  // unboxing

        // --- Autoboxing / auto-unboxing ---
        Integer autoBoxed = 200;     // autobox: int literal -> Integer
        int autoUnbox = autoBoxed;   // auto-unbox: Integer -> int (NPE if autoBoxed were null)

        // --- parseInt vs valueOf ---
        int fromParse = Integer.parseInt("42");           // returns primitive int
        Integer fromValueOf = Integer.valueOf("42");      // returns Integer object
        Integer fromValueOfInt = Integer.valueOf(42);     // boxing int constant

        System.out.println("parseInt: " + fromParse);
        System.out.println("valueOf String: " + fromValueOf);
        System.out.println("valueOf int: " + fromValueOfInt);

        // --- Cache: -128 to 127 for Integer ---
        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        Integer c = Integer.valueOf(128);
        Integer d = Integer.valueOf(128);
        System.out.println("127 == : " + (a == b));
        System.out.println("128 == : " + (c == d));
        System.out.println("128 equals: " + c.equals(d));

        // --- NullPointerException on unboxing ---
        Integer nullRef = null;
        try {
            int crash = nullRef; // auto-unboxing null -> NPE
            System.out.println(crash);
        } catch (NullPointerException ex) {
            System.out.println("NPE on unboxing null Integer");
        }

        // --- Safe pattern ---
        if (nullRef != null) {
            System.out.println(nullRef.intValue());
        }

        // --- Other wrappers (same ideas) ---
        Double dbl = Double.valueOf("3.14");
        Boolean flag = Boolean.valueOf("true");
        Character ch = Character.valueOf('A');
        System.out.println(dbl + " " + flag + " " + ch);
    }
}
