package lesson28.genericPractice.genericArrayList;

// Интерфейс - это набор методов, которые должны реализовать наследники этого интерфеса.
// Иными словами - это контракт, которому должны следовать все его дочение классы.


//  ДЗ:
//  3. Реализовать интерфейс AdvancedArrayList  - дописать класс MyArrayList.
//     a. * Добавить в интерфейс метод void append(int [] a) и дописать MyArrayList.


import java.util.Iterator;

public interface MyArrayListGeneric<V> extends Iterable {
    void set(int index, V value);

    V get(int index);

    int size();

    void append(V value);

    void append(V[] a);

    void insert(int index, V value);
    //void insert(int index, int [] a);

    void add(V value);

    void remove(int index);
    //void delete(int index, int howMany);

    void insert(int index);

    boolean contains(V value);

    Iterator<V> iterator();

}
