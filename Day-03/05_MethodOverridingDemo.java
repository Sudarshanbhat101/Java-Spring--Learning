class Payment {
    void processPayment() {
        System.out.println("Generic payment processing");
    }
}

class UpiPayment extends Payment {
    @Override
    void processPayment() {
        System.out.println("UPI payment processing");
    }
}

class MethodOverridingDemo {
    public static void main(String[] args) {
        Payment payment = new UpiPayment();
        payment.processPayment(); // runtime polymorphism
    }
}
