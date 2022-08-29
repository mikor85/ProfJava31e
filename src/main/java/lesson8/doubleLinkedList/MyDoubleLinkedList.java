package lesson8.doubleLinkedList;

import java.util.Iterator;

public interface MyDoubleLinkedList extends Iterable<Integer> {
    boolean isEmpty();

    int size();

    void add(int index, int value);

    void addFirst(int value);

    void addLast(int value);

    void set(int index, int value);

    boolean contains(int value);

    int get(int index);

    int getFirst();

    int getLast();

    void remove(int index);

    void removeFirst();

    void removeLast();

    Iterator<Integer> iterator();
}
