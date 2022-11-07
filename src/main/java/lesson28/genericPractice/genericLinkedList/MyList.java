package lesson28.genericPractice.genericLinkedList;

import java.util.Iterator;

public interface MyList<V> extends Iterable<V> {
    boolean isEmpty();

    void add(V value);

    void add(int index, V value);

    void set(int index, V value);

    boolean contains(V value);

    V get(int index);

    void remove(int index);

    int size();

    Iterator<V> iterator();

    void addFirst(V value);

    void removeFirst();

    V getFirst();
}
