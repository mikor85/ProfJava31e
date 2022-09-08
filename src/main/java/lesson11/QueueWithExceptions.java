package lesson11;

import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueWithExceptions {
    public static void main(String[] args) {
        // Data structures 'Queue', 'Stack'. Custom ArrayDeque implementation.

        // Queue - Очередь позволяет либо добавить элемент с конца очереди, либо забрать его сначала
        // First-In First-Out - принцип работы очереди

        // ДОБАВЛЕНИЕ ЭЛЕМЕНТА
        // boolean add(String s) - выбрасывает исключение IllegalStateException, если нет места.
        // boolean offer(String s) - возвращает true если элемент вставлен.

        // ПОЛУЧЕНИЕ ЭЛЕМЕНТА
        // String remove() - возвращает первый элемент из очереди и удаляет его из очереди,
        // если очередь пустая, то выбрасывает исключение NoSuchElementException.

        // String poll() - возвращает первый элемент из очереди и удаляет его из очереди,
        // если очередь пустая, то возвращает null.

        // ИНСПЕКЦИЯ
        // String element() - возвращает первый элемент, если очередь пустая выбрасывает исключение NoSuchElementException.
        // String peek() - возвращает первый элемент, если очередь пустая, то возвращает null.

        Queue<String> bankQueue = new LinkedList<>();
        bankQueue.add("Max Dolgih");
        bankQueue.add("Nadya Kopeikina");
        bankQueue.add("Sidor Kolokoltsev");

        System.out.println(bankQueue.remove());
        System.out.println(bankQueue.remove());
        System.out.println(bankQueue.remove());
        System.out.println(bankQueue.poll());

        // пол умолчанию приоритет - это порядок сортировки для типа
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("One");
        priorityQueue.add("Two");
        priorityQueue.add("Three");
        priorityQueue.add("Four");
        priorityQueue.add("Five");

        System.out.println("----------");

        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());

        try {
            hello();
        }
//        catch (NoSuchElementException e) {
//            System.out.println("Got a NoSuchElementException");
//        }
//        catch (IOException e) {
//            System.out.println("Got a IOException");
//        }
        catch (NoSuchElementException | IOException e) {
            System.out.println("Got an exception " + e.getClass() + " " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Got an exception " + e.getClass() + " " + e.getMessage());
        }
        System.out.println("End of program");

    } // end of main

    public static void hello() throws NoSuchElementException, IOException {

        Queue<String> bankQueue = new LinkedList<>();
        bankQueue.add("Max Dolgih");
        bankQueue.add("Nadya Kopeikina");
        bankQueue.add("Sidor Kolokoltsev");

        System.out.println(bankQueue.remove());
        System.out.println(bankQueue.remove());
        System.out.println(bankQueue.remove());
        // System.out.println(bankQueue.poll()); // null
        //System.out.println(bankQueue.remove()); // NoSuchElementException
        throw new IllegalArgumentException("Exception");

    }

}