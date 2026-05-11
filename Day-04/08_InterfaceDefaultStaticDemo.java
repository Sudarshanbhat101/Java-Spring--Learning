/**
 * Java 8+ interface: default instance methods and static utility methods on interface.
 */
interface Logger {
    void log(String message);

    default void logInfo(String message) {
        log("[INFO] " + message);
    }

    static void printBanner() {
        System.out.println("======== Logger ========");
    }
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class InterfaceDefaultStaticDemo {

    public static void main(String[] args) {
        Logger.printBanner();
        Logger logger = new ConsoleLogger();
        logger.logInfo("Application started");
    }
}
