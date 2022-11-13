package lesson31;

import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Класс представляющий собой поток выполнения
        Thread t1 = new Thread() {
            @Override
            public void run() {
                // код в функции run выполняется в порожденном потоке
                // порожденный поток работает пока не закончилась run
                try {
                    Thread.sleep(2_000); // миллисекунды
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long threadId = Thread.currentThread().getId();
                System.out.println("Hello from Thread " + threadId);
            }
        };
        t1.setDaemon(true);  // main не будет дожидаться окончания этого потока
        t1.setPriority(Thread.MAX_PRIORITY);
        // создает новый поток и запускает в нем метод run
        System.out.println(t1.getState());
        t1.start();

//        new Thread(() -> {
//            long threadId = Thread.currentThread().getId();
//            System.out.println("Hello from Thread " + threadId);
//        }).start();


        long mainThreadId = Thread.currentThread().getId();
        System.out.println("Hello from Main " + mainThreadId);

        // создайте и запустите 10 экземпляров MyThread
//        IntStream.range(0, 10).forEach(
//                i -> new MyThread().start()
//        );
//        for (int i = 0; i < 10; i++) {
//            new MyThread().start();
//        }

        // Запустить поток второй раз невозможно
        //t1.start();  // IllegalThreadStateException
        System.out.println(t1.getState());

        Runnable r1 = new MyRunnable("hello");

        // создается новый поток каждый раз, но Runnable один и тот же
//        new Thread(r1).start();
//        new Thread(r1).start();
//        new Thread(r1).start();
//        new Thread(r1).start();

        // набор потоков + очередь из Runnable и Callable
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);


        Runnable rr = new RandomRunnable();

        IntStream.range(0, 5).forEach(i -> service.submit(rr));

        MyCallable callable = new MyCallable();
        // Future - результат, который будет доступен в будущем
        Future<String> futureResult = service.submit(callable);

        Thread.sleep(2_000);
        if (futureResult.isDone()) {   // если результат есть
            System.out.println("Result is: " + futureResult.get());  // получим его(результат)
        } else {
            System.out.println("Result is not available at this time");
        }


        // остановка сервиса дождавшись выполнения всех задач в очереди
        service.shutdown();


    }  // end of main
}

// в отличие от Runnable, Callable может вернуть значение
class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1_000);
        return "hello from callable " + System.currentTimeMillis();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("hello from thread " + threadId);
    }
}

// напишите свой класс расширяющий Runnable
// внутри метод run будет ждать рандомное время до 500мс
// new Random.nextInt(500)
// пусть печатает текущее время и номер потока
// System.currentTimeMillis()
// запустить 5шт на ExecutorService
class MyRunnableClass implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long threadId = Thread.currentThread().getId();
        long currTime = System.currentTimeMillis();
        System.out.println("Current time is: " + currTime + " " + "Tread No.: " + threadId);
    }
}

class RandomRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("" + System.currentTimeMillis() + " " + Thread.currentThread().getId());
    }
}


class MyRunnable implements Runnable {
    private String text;

    public MyRunnable(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("hello from Runnable " + threadId);
    }
}