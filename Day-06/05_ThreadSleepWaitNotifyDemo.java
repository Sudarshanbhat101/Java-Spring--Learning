/**
 * Thread.sleep (static, does not release locks) vs wait/notify (must hold monitor on same object).
 */
class ThreadSleepWaitNotifyDemo {

    private static final Object lock = new Object();

    static void sleepDemo() throws InterruptedException {
        System.out.println("sleepDemo: before sleep");
        Thread.sleep(300);
        System.out.println("sleepDemo: after sleep");
    }

    static void waitNotifyDemo() throws InterruptedException {
        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiter: waiting...");
                    lock.wait(2000);
                    System.out.println("Waiter: resumed");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "waiter-thread");

        waiter.start();
        Thread.sleep(100);
        synchronized (lock) {
            System.out.println("Main: notify");
            lock.notify();
        }
        waiter.join();
    }

    public static void main(String[] args) throws InterruptedException {
        sleepDemo();
        waitNotifyDemo();
    }
}
