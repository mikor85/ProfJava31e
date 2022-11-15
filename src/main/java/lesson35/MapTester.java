package lesson35;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTester {
    public static void main(String[] args) {
        // HashMap нельзя использовать напрямую в многопоточном коде
        //Map<String, Integer> map = new HashMap<>();

        // Hashtable поддерживает работу в многопоточном режиме, но медленная
        //Map<String, Integer> map = new Hashtable<>();

        // ConcurrentHashMap поддерживает работу в многопоточном режиме, самая быстрая
        //Map<String, Integer> map = new ConcurrentHashMap<>();

        // Среднее между Hashtable и ConcurrentHashMap
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());


        List<Integer> res = parallelAdd100(map, 100);
        System.out.println(res);

    }

    // по ключу test -> 0
    // будем увеличивать этот ключ многопоточно
    public static List<Integer> parallelAdd100(Map<String, Integer> m, int executionTimes) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < executionTimes; i++) {
            m.put("test", 0);
            ExecutorService service = Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                service.execute(
                        () -> {
                            for (int k = 0; k < 10; k++) {
                                m.computeIfPresent("test",
                                        (key, value) -> value + 1);
                            }
                        }
                );
            }
            service.shutdown();
            try {
                service.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.add(m.get("test"));
        }
        return result;
    }
}
