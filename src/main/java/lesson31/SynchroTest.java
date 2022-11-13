package lesson31;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchroTest {

    public static int[] data = {0};

    private static final Object lock = new Object();

    // доступ в этот участок кода синхронизируется на классе SynchroTest
    //synchronized public static void add() {
    public static void add() {
        // синхронизируется на поле lock
        synchronized (lock) {
            int j = data[0];
            j++;
            data[0] = j;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // создайте и запустите 5 потоков Thread на базе MyRunnable
        Runnable r = new MyRunnable();
        // распечатайте содержимое массива data[]
//        IntStream.range(0, 5)
//                .forEach(i -> new Thread(r).start());

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();  // дождаться окончания потока в майне
        t2.join();  // дождаться окончания потока в майне
        t3.join();  // дождаться окончания потока в майне
        t4.join();  // дождаться окончания потока в майне
        t5.join();  // дождаться окончания потока в майне

        System.out.println(Arrays.toString(data));
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                add();
//                int j = data[0];
//                j++;
//                data[0] = j;
            }
            System.out.println("thread " + Thread.currentThread().getId() + " is finished");
        }
    }
}