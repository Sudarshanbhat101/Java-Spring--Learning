class DefaultUser {
    // no access modifier => default (package-private)
    String username = "day03_user";

    void displayUsername() {
        System.out.println("Default user: " + username);
    }
}

class DefaultAccessModifierDemo {
    public static void main(String[] args) {
        DefaultUser user = new DefaultUser();
        user.displayUsername();
    }
}
