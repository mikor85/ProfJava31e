package lesson24;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson24 {
    public static void main(String[] args) {
        // Task Nr.1:
        List<Integer> list = List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        System.out.println(sumLastN(list, 5));
        List<Integer> list1 = List.of(2, 1, 0);
        System.out.println(sumLastN(list1, 5));

        // Task Nr.2:
        System.out.println("----------");
        List<String> months = List.of("january", "february", "march", "june", "march");
        System.out.println(filterList(months, "r")); // {"january", "february", "march"}

        // Task Nr.3:
        System.out.println("----------");
        List<String> names = List.of("Max", "Masha", "Daria", "Alex", "Sam");
        System.out.println(getStringLengthFrequency(names)); // {3:2, 4:1, 5:2}

        // Task Nr.4:
        System.out.println("----------");
        Car c1 = new Car("Mitsubishi", "Lancer", 33_000);
        Car c2 = new Car("Mitsubishi", "Lancer Evo 4", 64_000);
        Car c3 = new Car("Subaru", "WRX STI", 62_000);
        Car c4 = new Car("Subaru", "Forrester", 23_000);
        Car c5 = new Car("Nissan", "GTR", 73_000);
        Car c6 = new Car("Mitsubishi", "Gallant", 14_000);
        List<Car> cars = List.of(c1, c2, c3, c4, c5, c6);
        System.out.println(sortCars(cars));
    }

    // Task Nr.4:
    // Напишите функцию, принимающую список автомобилей и возвращающую
    // TreeMap<String, List<Car>> где ключ - это производитель maker,
    // а в списке - автомобили этого производителя отсортированные по цене по убыванию
    public static TreeMap<String, List<Car>> sortCars(List<Car> cars) {

        TreeMap<String, List<Car>> res = new TreeMap<>();
        for (Car car : cars) {
            List<Car> c = res.containsKey(car.getMaker()) ? res.get(car.getMaker()) : new ArrayList<>();
            c.add(car);
            res.put(car.getMaker(), c);
        }
        for (String maker : res.keySet()) {
            List<Car> c = res.get(maker);
            c.sort(Comparator.comparing(Car::getPrice).reversed());
            res.put(maker, c);
        }
        return res;
    }

    // Task Nr.3:
    // В функцию передается список строк, нужно вернуть Map<Integer, Integer> ,
    // ключ в которой это длина строки, а значение это сколько раз строка такой длины
    // встретилась в списке
    public static Map<Integer, Integer> getStringLengthFrequency(List<String> list) {
        Map<Integer, Integer> resMap = new HashMap<>();
        for (String word : list) {
            Integer count = resMap.get(word.length());
            if (count == null) {
                count = 0;
            }
            count++;
            resMap.put(word.length(), count);
        }
        return resMap;
    }

    // Task Nr.2:
    // Напишите функцию, которая принимает на вход список строк и строковой шаблон.
    // Возвращает набор не повторяющихся строк, содержащих шаблон.
    public static Set<String> filterList(List<String> list, String pattern) {
        return list.stream()
                .filter(s -> s.contains(pattern))
                .collect(Collectors.toSet());
    }

    // Task Nr.1:
    // Напишите функцию, которая посчитает сумму последних N элементов
    // из передаваемого в нее списка целых.
    public static int sumLastN(List<Integer> list, int N) {
        if (N > list.size()) {
            N = list.size();
        }
        int sum = 0;
        while (N != 0) {
            sum += list.get(list.size() - N);
            N--;
        }
        return sum;
    }

    public static int sumLastNStream(List<Integer> list, int N) {
        int skip = Math.max(list.size() - N, 0);
        return list.stream().skip(skip).reduce(0, Integer::sum);
    }
}

class Car {
    public String maker;
    public String model;
    public double price;

    public Car(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "car{" +
                "ma='" + maker + '\'' +
                ", mo='" + model + '\'' +
                ", p=" + price +
                '}';
    }
}