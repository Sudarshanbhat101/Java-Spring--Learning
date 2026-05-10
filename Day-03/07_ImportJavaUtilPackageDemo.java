import java.util.ArrayList;
import java.util.List;

class ImportJavaUtilPackageDemo {
    public static void main(String[] args) {
        List<String> topics = new ArrayList<>();
        topics.add("Inheritance");
        topics.add("Method Overriding");
        topics.add("Access Modifiers");

        System.out.println("Topics learned today:");
        for (String topic : topics) {
            System.out.println("- " + topic);
        }
    }
}
