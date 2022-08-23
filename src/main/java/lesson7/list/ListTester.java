package lesson7.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTester {
    public static void main(String[] args) {
        // Iterators and Iterable
        // Foreach syntax

        int[] a = {10, 20, 30, 40};

        List<Integer> b = Arrays.asList(100, 200, 300, 400);
        for (int i = 0; i < a.length; i++) {
            System.out.println("fori: " + a[i]);
        }

        for (int i : b) {  // foreach перебирает все значения
            System.out.println("foreach: " + i);
        }

        MyList list = new MyListSimpleImplementation();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i));
        }

        // итератор - указывает на конкретный элемент контейнера
        // операции итератора:
        // boolean hasNext() - есть ли следующий элемент
        // int next() - получить значение элемента и сделать следующий элемент "текущим"

        Iterator<Integer> myIterator = list.iterator();
        while (myIterator.hasNext()) {
            System.out.println("iterator next: " + myIterator.next());
        }

        for (int i : list) {  // Iterable - добавляем имплементацию в класс
            System.out.println("My list: " + i);
        }


    }
}
