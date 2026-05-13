/**
 * Threads: subclassing Thread vs implementing Runnable + multithreaded execution.
 */
class CounterThread extends Thread {
    private final String label;
    private final int limit;

    CounterThread(String label, int limit) {
        this.label = label;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            System.out.println(label + " -> " + i);
        }
    }
}

class RunnableTask implements Runnable {
    private final String label;

    RunnableTask(String label) {
        this.label = label;
    }

    @Override
    public void run() {
        System.out.println(label + " running in " + Thread.currentThread().getName());
    }
}

class ThreadBasicsDemo {

    public static void main(String[] args) throws InterruptedException {
        CounterThread threadA = new CounterThread("A", 3);
        CounterThread threadB = new CounterThread("B", 3);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        Thread runnableThread = new Thread(new RunnableTask("Runnable job"), "worker-1");
        runnableThread.start();
        runnableThread.join();
    }
}
