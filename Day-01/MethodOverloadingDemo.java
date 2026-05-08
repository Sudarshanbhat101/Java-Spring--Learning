public class MethodOverloadingDemo {
    int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    int add(double firstNumber, double secondNumber) {
        return (int) (firstNumber + secondNumber);
    }

    public static void main(String[] args) {
        MethodOverloadingDemo overloadedMethods = new MethodOverloadingDemo();
        System.out.println(
                overloadedMethods.add(3, 5) + "  " + overloadedMethods.add(5.0, 6.0));
    }
}
