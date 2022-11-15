package lesson35;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class F_FutureTest {
    public static void main(String[] args) {
        // создать CompletableFuture из комбинации функций calcOne() и greeting(int i),
        // который бы вернул "Hello 3456"

        ExecutorService service1 = Executors.newFixedThreadPool(2);
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        //CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> greeting(calcOne()));
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                () -> calcOne(), service1
        ).thenApplyAsync(
                i -> greeting(i), service2);

        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static int calcOne() {
        return new Random().nextInt();
    }

    public static String greeting(int i) {
        return "Hello " + i;
    }
}