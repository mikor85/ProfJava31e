package lesson31.homework;

// ДЗ проф ява:
// 1. ** Вычислите многопоточно число pi, инструкции ниже:
// Заведите два целых счетчика - один для точек,
// для которых вычисленное расстояние до начала координат R меньше  1.0 ("yes" счетчик)
// и второй счетчик для тех точек, для которых вычисленное расстояние до начала координат R больше 1.0
// Создайте производный от Runnable класс и внутри run метода напишите:
// - сгенерируйте с помощью генератора случайных чисел два double числа
// из диапазона [0.0 - 1.0] - x и y координаты точки;
// - с помощью теоремы Пифагора, вычислите для нее расстояние от начала координат - R;
// - если для сгенерированной точки расстояние R до начала координат меньше 1.0,
// то увеличивайте на единицу счетчик "yes"; если R больше 1.0 увеличивайте на единицу счетчик "no";
// - создайте и запустите 1_000_000 таких Runnable через ExecutorService;
// - по результатам эксперимента вычислите значение pi как 4.0*yes/(yes+no).

//2. *** поэкспериментируйте с количеством потоков в ExecutrorService - при каком их примерном количестве вычисление занимает сравнительно меньше времени?

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class GetPI {

    private static int yes = 0;
    private static int no = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Runnable runnable = new CountPIClass();
        ExecutorService service = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1_000_000)
                .forEach(r -> service.submit(runnable));

        GetPIClass callable = new GetPIClass();
        Future<Double> pi = service.submit(callable);
        Thread.sleep(10_000);
        if (pi.isDone()) {
            System.out.println("PI number is: " + pi.get());
        } else {
            System.out.println("Result is not available at this time");
        }

        service.shutdown();

        //System.out.println("PI is = " + 4.0 * yes / (yes + no));

    } // main

    public synchronized static void increaseCounters(double R) {
        if (R < 1) {
            yes++;
            //System.out.println("YES = " + yes);
        } else {
            no++;
            //System.out.println("NO = " + no);
        }
    }

    static class CountPIClass implements Runnable {

        @Override
        public void run() {

            double x = ThreadLocalRandom.current().nextDouble(0, 1);
            double y = ThreadLocalRandom.current().nextDouble(0, 1);
            double R = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            increaseCounters(R);
        }
    }

    static class GetPIClass implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            return 4.0 * yes / (yes + no);
        }
    }
}