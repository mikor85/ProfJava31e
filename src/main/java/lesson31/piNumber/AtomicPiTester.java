package lesson31.piNumber;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicPiTester {

    // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html

    private static int yes = 0;
    private static int no = 0;

    private static AtomicInteger atomicYes = new AtomicInteger();
    private static AtomicInteger atomicNo = new AtomicInteger();

    private static Random random = new Random();

    public static void main(String[] args) {

        atomicYes.set(0);
        atomicNo.set(0);

        // проверить кол-во ядер на локальной машине
        System.out.println(Runtime.getRuntime().availableProcessors());

        runner(2);
        yes = 0;
        no = 0;
        runner(5);
        yes = 0;
        no = 0;
        runner(10);
        yes = 0;
        no = 0;
        runner(20);
        yes = 0;
        no = 0;
        runner(40);
        yes = 0;
        no = 0;
        runner(100);
    }

    private synchronized static void addYesSynchro() {
        yes++;
    }

    private static void addYes() {
        atomicYes.incrementAndGet();
    }

    private synchronized static void addNoSynchro() {
        no++;
    }

    private static void addNo() {
        atomicNo.incrementAndGet();
    }

    static void runner(int numberOfThreads) {
        long before = System.currentTimeMillis(); // число миллисекунд с 1 января 1970г.

        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        IntStream.range(0, 1_000_000)
                .forEach(
                        i -> service.submit(new PiRunnable())
                );

        // останавливает сервис сразу после того как в него отправлен последний Runnable
        service.shutdown();

        try {
            service.awaitTermination(2_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis(); // число миллисекунд с 1 января 1970г.

        // NOT ATOMIC
//        System.out.println("Threads number: " + numberOfThreads +
//                "pi: " + 4.0 * yes / (yes + no) +
//                " yes: " + yes +
//                " no: " + no +
//                " sum: " + (yes + no) +
//                " time: " + (after - before));

        // ATOMIC counters type
        System.out.println("Threads number: " + numberOfThreads +
                "pi: " + 4.0 * atomicYes.get() / (atomicYes.get() + atomicNo.get()) +
                " yes: " + atomicYes.get() +
                " no: " + atomicNo.get() +
                " sum: " + (atomicYes.get() + atomicNo.get()) +
                " time: " + (after - before));
    }

    static class PiRunnable implements Runnable {

        @Override
        public void run() {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                addYes();
            } else {
                addNo();
            }
        }
    }
}