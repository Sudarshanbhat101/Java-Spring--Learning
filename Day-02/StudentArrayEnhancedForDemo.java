/**
 * Array of objects / references and enhanced for-loop (for-each).
 */
class Student {

    String name;
    int rollNumber;
}

public class StudentArrayEnhancedForDemo {

    public static void main(String[] args) {
        Student first = new Student();
        first.name = "Sudarshan";
        first.rollNumber = 13;

        Student second = new Student();
        second.name = "Manoj";
        second.rollNumber = 15;

        Student third = new Student();
        third.name = "Kiran";
        third.rollNumber = 14;

        Student[] members = new Student[3];
        members[0] = first;
        members[1] = second;
        members[2] = third;

        for (Student student : members) {
            System.out.println(student.name + " : " + student.rollNumber);
        }
    }
}
