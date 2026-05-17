/**
 * Arrays: fixed-size, contiguous memory for elements (primitives or references).
 */
class ArraysMemoryDemo {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30}; // array object on heap; 'numbers' is reference on stack
        System.out.println("length: " + numbers.length);
        System.out.println("numbers[1]: " + numbers[1]);

        numbers[1] = 99;
        System.out.println("after update: " + numbers[1]);

        int[] copy = numbers; // same array object — alias
        copy[0] = 1;
        System.out.println("numbers[0] via alias: " + numbers[0]);

        int[] another = new int[3];
        another[0] = 1;
        another[1] = 99;
        another[2] = 30;
        System.out.println("another array (separate object): " + another[0]);
    }
}
