class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name; // this resolves field vs parameter
        this.id = id;
    }

    void show() {
        System.out.println("Employee: " + this.name + ", Id: " + this.id);
    }
}

class ThisKeywordDemo {
    public static void main(String[] args) {
        Employee employee = new Employee("Sudarshan", 101);
        employee.show();
    }
}
