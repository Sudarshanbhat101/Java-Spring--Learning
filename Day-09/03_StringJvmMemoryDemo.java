/**
 * String immutability and String pool (conceptual demo).
 * == compares references; equals compares character content.
 */
class StringJvmMemoryDemo {

    public static void main(String[] args) {
        String s1 = "hello";              // may use String pool literal
        String s2 = "hello";
        String s3 = new String("hello");  // always new heap object

        System.out.println("s1 == s2 ? " + (s1 == s2));       // often true (pool)
        System.out.println("s1 == s3 ? " + (s1 == s3));       // false (new object)
        System.out.println("s1.equals(s3) ? " + s1.equals(s3)); // true (same content)

        String built = new StringBuilder("hel").append("lo").toString();
        System.out.println("content equal: " + s1.equals(built));
        // Strings are immutable — methods return new String instances
        String upper = s1.toUpperCase();
        System.out.println("original: " + s1 + ", upper: " + upper);
    }
}
