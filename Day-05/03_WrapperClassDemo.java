/**
 * Wrapper classes: object forms of primitives (Integer, Double, Boolean, ...).
 * Autoboxing / unboxing bridges primitives and wrappers.
 */
class WrapperClassDemo {

    public static void main(String[] args) {
        Integer boxed = 42;              // autoboxing: int -> Integer
        int primitive = boxed;           // unboxing: Integer -> int
        System.out.println("boxed=" + boxed + ", primitive=" + primitive);

        Integer fromString = Integer.valueOf("100");
        int parsed = Integer.parseInt("200");
        System.out.println("valueOf: " + fromString + ", parseInt: " + parsed);

        Double d = 3.14;
        System.out.println("Double wrapper: " + d.doubleValue());

        Boolean flag = Boolean.TRUE;
        System.out.println("Boolean wrapper: " + flag);
    }
}
