/**
 * StringBuffer: mutable character sequence;
 * capacity() reports current buffer allocation (often 16 more than length by default constructor rules).
 */
public class StringBufferCapacityDemo {

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("navin");
        System.out.println(buffer.capacity());
    }
}
