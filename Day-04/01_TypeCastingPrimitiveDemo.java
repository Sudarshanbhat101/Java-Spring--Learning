/**
 * Primitive type casting: widening (implicit) and narrowing (explicit).
 */
class TypeCastingPrimitiveDemo {

    public static void main(String[] args) {
        int small = 100;
        long widened = small; // int -> long implicit widening
        System.out.println("Widening int to long: " + widened);

        double pi = 3.14159;
        int narrowed = (int) pi; // explicit cast truncates toward zero
        System.out.println("Narrowing double to int: " + narrowed);

        byte b = (byte) 130; // overflow after narrowing
        System.out.println("Narrowing int 130 to byte (overflow): " + b);
    }
}
