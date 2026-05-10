class BaseLogger {
    void log() {
        System.out.println("Base logger: writing generic log");
    }
}

class AppLogger extends BaseLogger {
    @Override
    void log() {
        System.out.println("App logger: writing app-specific log");
    }

    void logWithParentBehavior() {
        super.log(); // call superclass version explicitly
        log();       // call overridden child version
    }
}

class SuperMethodAccessDemo {
    public static void main(String[] args) {
        AppLogger logger = new AppLogger();
        logger.logWithParentBehavior();
    }
}
