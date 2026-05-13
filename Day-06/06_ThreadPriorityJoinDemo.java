/**
 * Thread priority (hint to scheduler, platform-dependent) and join (wait for thread completion).
 */
class ThreadPriorityJoinDemo {

    static class Worker extends Thread {
        private final String label;

        Worker(String label) {
            super(label);
            this.label = label;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(label + " step " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker low = new Worker("low-priority");
        Worker high = new Worker("high-priority");
        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        high.start();
        low.start();

        high.join();
        low.join();
        System.out.println("Both workers finished (join ensured order of completion wait).");
    }
}
