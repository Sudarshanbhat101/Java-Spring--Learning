/**
 * StringBuilder: mutable sequence for efficient string building (vs repeated String concat).
 */
class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Core ");
        builder.append("Java ");
        builder.append("Day-08");
        System.out.println("append: " + builder);

        builder.insert(0, "[");
        builder.append("]");
        System.out.println("insert/append: " + builder);

        builder.reverse();
        System.out.println("reverse: " + builder);

        String result = builder.reverse().toString(); // back to readable order
        System.out.println("toString: " + result);
    }
}
