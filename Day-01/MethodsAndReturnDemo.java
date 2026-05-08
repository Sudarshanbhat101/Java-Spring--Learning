public class MethodsAndReturnDemo {
    public void display() {
        System.out.println("Music is playing");
    }

    public String getPen(int cost) {
        if (cost >= 10) {
            return "Pen";
        }
        return "Nothing";
    }

    public static void main(String[] args) {
        MethodsAndReturnDemo methods = new MethodsAndReturnDemo();
        methods.display();
        String result = methods.getPen(10);
        System.out.println(result);
    }
}
