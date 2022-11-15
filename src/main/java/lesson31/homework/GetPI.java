package lesson31.homework;

// ДЗ проф ява:
// 1. ** Вычислите многопоточно число pi, инструкции ниже:
// Заведите два целых счетчика -
// один для точек, у которых вычисленное расстояние до начала координат R меньше 1.0 ("yes" счетчик)
// и второй -      у которых вычисленное расстояние до начала координат R больше 1.0 ("no" счетчик)
// Создайте производный от Runnable класс и внутри run метода напишите:
// - сгенерируйте с помощью генератора случайных чисел два double числа
// из диапазона [0.0 - 1.0] - x и y координаты точки;
// - с помощью теоремы Пифагора, вычислите для нее расстояние от начала координат - R;
// - если для сгенерированной точки расстояние R до начала координат меньше 1.0,
// то увеличивайте на единицу счетчик "yes"; если R больше 1.0 увеличивайте на единицу счетчик "no";
// - создайте и запустите 1_000_000 таких Runnable через ExecutorService;
// - по результатам эксперимента вычислите значение pi как 4.0*yes/(yes+no).

// 2. *** поэкспериментируйте с количеством потоков в ExecutorService -
// при каком их примерном количестве вычисление занимает сравнительно меньше времени?

// Результаты эксперимента:
// Duration for 1 threads = 746
// Duration for 2 threads = 917
// Duration for 3 threads = 753
// Duration for 4 threads = 767


import java.util.concurrent.*;
import java.util.stream.IntStream;

public class GetPI {

    private static int yes = 0;
    private static int no = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new RunnablePIClass();
        int threadAmount = 4;
        ExecutorService service = Executors.newFixedThreadPool(threadAmount);

        long before = System.currentTimeMillis();
        int runnableNum = 1_000_000;
        IntStream.range(0, runnableNum)
                .forEach(r -> service.submit(runnable));

//        Future<Double> pi = service.submit(new CallablePIClass());
//        Thread.sleep(10_000);
//        if (pi.isDone()) {
//            try {
//                System.out.println("PI number is: " + pi.get());
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println("YES count = " + yes);
//            System.out.println("NO count = " + no);
//            System.out.println("YES + NO counters = " + (yes + no));
//        } else {
//            System.out.println("Result is not available at this time");
//        }

        service.shutdown();
        int sleepTime = 500;
        Thread.sleep(sleepTime);

        System.out.println("PI is = " + 4.0 * yes / (yes + no));
        System.out.println("YES count = " + yes);
        System.out.println("NO count = " + no);
        System.out.println("Number of EXECUTED threads = " + (yes + no));
        System.out.println("Number of LOST threads = " + (runnableNum - yes - no));

        long after = System.currentTimeMillis();
        System.out.println("Duration for " + threadAmount + " threads = " + (after - before - sleepTime));

    } // main

    public synchronized static void increaseCounters(double R) {
        if (R < 1) {
            yes++;
        } else {
            no++;
        }
    }

    static class RunnablePIClass implements Runnable {

        @Override
        public void run() {

            double x = ThreadLocalRandom.current().nextDouble(0, 1);
            double y = ThreadLocalRandom.current().nextDouble(0, 1);
            double R = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            increaseCounters(R);
        }
    }

    static class CallablePIClass implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            return 4.0 * yes / (yes + no);
        }
    }
}