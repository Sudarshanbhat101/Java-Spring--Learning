/**
 * Enum type: fixed set of named constants; each constant is an instance of the enum.
 */
enum Priority {
    LOW,
    MEDIUM,
    HIGH
}

class EnumBasicsDemo {

    public static void main(String[] args) {
        Priority p = Priority.HIGH;
        System.out.println("Selected: " + p);
        System.out.println("Ordinal: " + p.ordinal());
        System.out.println("Name: " + p.name());

        for (Priority value : Priority.values()) {
            System.out.println("Constant: " + value);
        }
    }
}
