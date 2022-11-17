package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lesson34 {
    public static void main(String[] args) {
        // https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD
        // {"amount":10.0,"base":"GBP","date":"2022-11-17","rates":{"USD":11.7965}}
        // берем сумму и вызываем с ней же веб-сервис для перевода USD в EUR

//        CompletableFuture<Rate> u = CompletableFuture.supplyAsync(new Supplier<Rate>() {
//                    @Override
//                    public Rate get() {
//                        return Request.getRate(10, "GBP", "USD");
//                    }
//                })
//                .thenApplyAsync(new Function<Rate, Rate>() {
//                    @Override
//                    public Rate apply(Rate rate) {
//                        return Request.getRate(rate.rates.get("USD"), "USD", "EUR");
//                    }
//                }).handle(new BiFunction<Rate, Throwable, Rate>() {
//                    @Override
//                    public Rate apply(Rate rate, Throwable throwable) {
//                        if (throwable != null) {
//                            System.out.println(throwable.getMessage());
//                        }
//                        return rate;
//                    }
//                });

        CompletableFuture<Rate> u =
                CompletableFuture.supplyAsync(() -> Request.getRate(10, "GBP", "USD"))
                        .thenApplyAsync(rate -> {
                            double amount = rate.rates.get("USD");
                            return Request.getRate(amount, "USD", "EUR");
                        }).handleAsync((rate, throwable) -> {
                            if (throwable != null) {
                                System.out.println(throwable.getMessage());
                            }
                            return rate;
                        });

        try {
            System.out.println(u.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}