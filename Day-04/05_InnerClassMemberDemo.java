/**
 * Non-static member inner class: tied to an instance of the outer class.
 */
class OuterMember {
    private int value = 10;

    class InnerMember {
        void showOuter() {
            System.out.println("Inner sees outer value: " + value);
        }
    }

    void createInner() {
        InnerMember inner = new InnerMember();
        inner.showOuter();
    }
}

class InnerClassMemberDemo {

    public static void main(String[] args) {
        OuterMember outer = new OuterMember();
        outer.createInner();

        OuterMember.InnerMember inner = outer.new InnerMember();
        inner.showOuter();
    }
}
