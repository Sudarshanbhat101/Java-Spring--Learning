/**
 * Encapsulation: hide fields behind getters/setters (access control via private fields).
 */
class Human {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class EncapsulationDemo {

    public static void main(String[] args) {

        Human person = new Human();

        person.setAge(30);
        person.setName("Reddy");

        System.out.println(person.getName() + " : " + person.getAge());
    }
}
