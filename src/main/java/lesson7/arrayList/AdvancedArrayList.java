package lesson7.arrayList;

// Интерфейс - это набор методов, которые должны реализовать наследники этого интерфеса.
// Иными словами - это контракт, которому должны следовать все его дочение классы.


//  ДЗ:
//  3. Реализовать интерфейс AdvancedArrayList  - дописать класс MyArrayList.
//     a. * Добавить в интерфейс метод void append(int [] a) и дописать MyArrayList.


import java.util.Iterator;

public interface AdvancedArrayList extends Iterable {
    void set(int index, int value);

    int get(int index);

    int size();

    void append(int value);

    void append(int[] a);

    void insert(int index, int value);
    //void insert(int index, int [] a);

    void delete(int index);
    //void delete(int index, int howMany);

    boolean contains(int value);

    Iterator<Integer> iterator();

}
