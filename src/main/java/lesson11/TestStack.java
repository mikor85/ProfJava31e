package lesson11;

import java.util.*;

public class TestStack {
    public static void main(String[] args) {
        // Stack стэк - добавляем элемент с одной стороны и получаем с той же стороны.
        // LIFO Last-In First-Out

        // T push(T element) - добавляет элемент в стэк (сверху в общую стопку)
        // T pop() - удаляет и возвращает самый верхний элемент стэка; если стэк пустой - EmptyStackException
        // T peek() - возвращает верхний элемент стэка не удаляя его; если стэк пустой - EmptyStackException
        // boolean isEmpty()

        Stack<String> names = new Stack<>();
        names.push("Dima");
        names.push("Max");
        names.push("Darya");

        names.add(2, "Vasya");

        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());

        System.out.println("----------");
        System.out.println(reverse(Arrays.asList("Dima", "Max", "Dina")));

        System.out.println("----------");
        Queue<Integer> ints = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        System.out.println(partialReverse(ints, 5));


    }  // end of main

    // напишите функцию, которая принимает на вход коллекцию строк и
    // возвращает коллекцию строк в обратном порядке
    public static Collection<String> reverse(Collection<String> strings) {
        Stack<String> words = new Stack<>();
        words.addAll(strings);
        Collection<String> result = new ArrayList<>();
        while (!words.isEmpty()) {
            result.add(words.pop());
        }
        return result;
    }

    // [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
    // Если число int = 5
    // [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]

    // добавить 5 элементов из очереди в стэк
    // стэк [50, 40, 30, 20, 10]
    // очередь [60, 70, 80, 90, 100]
    // и из стэка добавить эти элементы в очередь
    // очередь [60, 70, 80, 90, 100, 50, 40, 30, 20, 10]
    // из очереди 5 элементов добавить в эту же очередь
    public static Queue<Integer> partialReverse(Queue<Integer> ints, int number) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number; i++) {
            stack.add(ints.remove());
        }

        for (int i = 0; i < number; i++) {
            ints.add(stack.pop());
        }

        for (int i = 0; i < ints.size() - number; i++) {
            ints.add(ints.remove());
        }
        return ints;
    }

}
