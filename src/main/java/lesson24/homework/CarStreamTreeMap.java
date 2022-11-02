package lesson24.homework;

// 2. *** Переделать четвертое задание (с машинами) на stream.
// Напишите функцию, принимающую список автомобилей и возвращающую
// TreeMap<String, List<Car>> где ключ - это производитель maker,
// а в списке - автомобили этого производителя отсортированные по цене по убыванию.

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CarStreamTreeMap {
    public static void main(String[] args) {
        System.out.println("----------");
        Car c1 = new Car("Mitsubishi", "Lancer", 33_000);
        Car c2 = new Car("Mitsubishi", "Lancer Evo 4", 64_000);
        Car c3 = new Car("Subaru", "WRX STI", 62_000);
        Car c4 = new Car("Subaru", "Forrester", 23_000);
        Car c5 = new Car("Nissan", "GTR", 73_000);
        Car c6 = new Car("Mitsubishi", "Gallant", 14_000);
        List<Car> cars = List.of(c1, c2, c3, c4, c5, c6);
        System.out.println(sortCarsCollector(cars));
        System.out.println("----------");
        System.out.println(sortCarsStream(cars));
        System.out.println("----------");
        System.out.println(sortCars(cars));
        System.out.println("----------");
        System.out.println(sortCars1(cars));
    }

    public static TreeMap<String, List<Car>> sortCars1(List<Car> cars) {
        return cars.stream()
                .collect(
                        Collectors.toMap(
                                Car::getMaker,
                                car -> new ArrayList<>(List.of(car)),
                                (f, s) -> {
                                    f.addAll(s);
                                    f.sort(Comparator.comparing(Car::getPrice).reversed());
                                    return f;
                                },
                                TreeMap::new
                        )
                );
    }

    public static TreeMap<String, List<Car>> sortCars(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getMaker))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> {
                                    List<Car> crs = entry.getValue();
                                    crs.sort(Comparator.comparing(Car::getPrice).reversed());
                                    return crs;
                                },
                                (f, s) -> {
                                    f.addAll(s);
                                    return f;
                                },
                                TreeMap::new
                        )
                );
    }

    // My Collector
    public static TreeMap<String, List<Car>> sortCarsCollector(List<Car> cars) {

        return cars.stream()
                .collect(new Collector<Car, TreeMap<String, List<Car>>, TreeMap<String, List<Car>>>() {
                    @Override
                    public Supplier<TreeMap<String, List<Car>>> supplier() {
                        return TreeMap::new;
                    }

                    @Override
                    public BiConsumer<TreeMap<String, List<Car>>, Car> accumulator() {
                        return (treeMap, car) -> {
                            // взять по значению ключа лист с авто
                            // проверить, есть ли в TreeSet лист с нужным ключом (производитель)
                            // если List отсутствует, то его нужно создать
                            // добавить в лист новый авто
                            // отсортировать лист по убыванию цены
                            // добавить в TreeSet лист с авто
                            List<Car> carList =
                                    treeMap.containsKey(car.getMaker()) ?
                                            treeMap.get(car.getMaker()) : new ArrayList<>();
                            carList.add(car);
                            carList.sort(Comparator.comparing(Car::getPrice).reversed());
                            treeMap.put(car.getMaker(), carList);
                        };
                    }

                    @Override
                    public BinaryOperator<TreeMap<String, List<Car>>> combiner() {
                        return (treeMap1, treeMap2) -> {
                            treeMap1.putAll(treeMap2);
                            return treeMap1;
                        };
                    }

                    @Override
                    public Function<TreeMap<String, List<Car>>, TreeMap<String, List<Car>>> finisher() {
                        return Function.identity();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                    }
                });
    }

    // My Stream
    public static TreeMap<String, List<Car>> sortCarsStream(List<Car> cars) {
        return cars.stream()
                .collect(TreeMap::new,
                        (treeMap, car) -> {
                            List<Car> carList =
                                    treeMap.containsKey(car.getMaker()) ?
                                            treeMap.get(car.getMaker()) : new ArrayList<>();
                            carList.add(car);
                            carList.sort(Comparator.comparing(Car::getPrice).reversed());
                            treeMap.put(car.getMaker(), carList);
                        },
                        TreeMap::putAll);
    }
}