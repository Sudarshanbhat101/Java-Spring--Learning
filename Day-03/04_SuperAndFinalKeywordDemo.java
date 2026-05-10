class ParentAccount {
    final String bankName = "ABC Bank"; // final: value cannot change

    ParentAccount() {
        System.out.println("ParentAccount constructor called");
    }
}

class ChildAccount extends ParentAccount {
    ChildAccount() {
        super(); // call immediate parent constructor
    }

    void printBank() {
        System.out.println("Bank: " + super.bankName);
    }
}

class SuperAndFinalKeywordDemo {
    public static void main(String[] args) {
        ChildAccount account = new ChildAccount();
        account.printBank();
    }
}
