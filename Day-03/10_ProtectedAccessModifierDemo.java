class ParentProfile {
    protected String role = "Backend Learner";

    protected void printRole() {
        System.out.println("Role from parent: " + role);
    }
}

class ChildProfile extends ParentProfile {
    void showParentRole() {
        // protected members are directly accessible in subclass
        printRole();
    }
}

class ProtectedAccessModifierDemo {
    public static void main(String[] args) {
        ChildProfile profile = new ChildProfile();
        profile.showParentRole();
    }
}
