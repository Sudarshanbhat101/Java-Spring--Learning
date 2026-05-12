/**
 * Polymorphism: same interface (method call), different runtime behavior (subtypes).
 */
class Notification {
    void send(String message) {
        System.out.println("Generic notification: " + message);
    }
}

class EmailNotification extends Notification {
    @Override
    void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsNotification extends Notification {
    @Override
    void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class PolymorphismDemo {

    static void dispatch(Notification channel, String text) {
        channel.send(text); // compile-time type Notification, runtime type decides behavior
    }

    public static void main(String[] args) {
        dispatch(new EmailNotification(), "Welcome aboard");
        dispatch(new SmsNotification(), "OTP: 482910");

        Notification polymorphic = new EmailNotification();
        polymorphic.send("Same variable type, subclass behavior");
    }
}
