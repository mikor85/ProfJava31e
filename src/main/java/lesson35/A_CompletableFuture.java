package lesson35;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class A_CompletableFuture {
    public static void main(String[] args) {

        // Void - никакого значения не возвращается
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                () -> {
                    // runAsync запускает Runnable в порожденном потоке
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread " + Thread.currentThread().getId());
                }
        );

        // блокируемся в текущем потоке и ожидаем результата
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("thread " + Thread.currentThread().getId());


        // Возвращение значения
        // supplyAsync выполняется в порожденном потоке и возвращает результат
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                        () -> {
                            System.out.println("supplyAsync " + Thread.currentThread().getId());
                            return "How are you?";
                        })
                // потребление возвращаемого значения
                .thenApply(s -> s + " I'm fine");

        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(System.out::println);
    }
}