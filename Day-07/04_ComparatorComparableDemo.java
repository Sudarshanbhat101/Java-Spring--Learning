import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparable: natural ordering (compareTo). Comparator: external ordering strategy.
 */
class Student implements Comparable<Student> {
    private final String name;
    private final int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score); // ascending by score
    }

    @Override
    public String toString() {
        return name + ":" + score;
    }
}

class ComparatorComparableDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bob", 80));
        students.add(new Student("Alice", 90));
        students.add(new Student("Carol", 70));

        Collections.sort(students); // uses Comparable
        System.out.println("Comparable (score asc): " + students);

        students.sort(Comparator.comparing(Student::getName)); // Comparator by name
        System.out.println("Comparator by name: " + students);

        students.sort(Comparator.comparingInt(Student::getScore).reversed());
        System.out.println("Comparator score desc: " + students);

        students.sort(Comparator.comparingInt(Student::getScore).thenComparing(Student::getName));
        System.out.println("thenComparing name: " + students);
    }
}
