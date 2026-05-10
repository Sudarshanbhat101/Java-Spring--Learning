import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class ImportJavaTimePackageDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Day-03 practice date: " + today.format(formatter));
    }
}
