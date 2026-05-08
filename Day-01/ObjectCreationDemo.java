public class ObjectCreationDemo {
    static class Calculator {
        public int add(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, 5);
        System.out.println("Calculator add result: " + result);
    }
}
