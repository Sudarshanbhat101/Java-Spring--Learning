import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Scheduler: ScheduledExecutorService schedules tasks at a fixed rate or delay.
 */
class ScheduledExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger ticks = new AtomicInteger(0);

        var future = scheduler.scheduleAtFixedRate(
                () -> {
                    int n = ticks.incrementAndGet();
                    System.out.println("Tick " + n + " on " + Thread.currentThread().getName());
                },
                0,
                200,
                TimeUnit.MILLISECONDS);

        Thread.sleep(750);
        future.cancel(true);
        scheduler.shutdown();
        scheduler.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Scheduler stopped.");
    }
}
