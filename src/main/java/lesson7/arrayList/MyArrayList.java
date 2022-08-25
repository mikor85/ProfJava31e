package lesson7.arrayList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList implements AdvancedArrayList {

    // Поля
    private int[] source;

    // Конструкторы
    public MyArrayList(int initialSize) {
        source = new int[initialSize];
    }

    public MyArrayList(int[] array) {
        source = new int[array.length];
        for (int i = 0; i < source.length; i++) {
            source[i] = array[i];
        }
    }

    // Методы
    @Override
    public void set(int index, int value) {
        source[index] = value;
    }

    @Override
    public int get(int index) {
        return source[index];
    }

    @Override
    public int size() {
        return source.length;
    }

    @Override
    public void append(int value) {
        int[] newSource = new int[source.length + 1];
        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }
        newSource[size()] = value;
        source = newSource;
    }

    @Override
    public void append(int[] a) {
        int[] newSource = new int[source.length + a.length];
        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }
        for (int i = 0; i < a.length; i++) {
            newSource[source.length + i] = a[i];
        }
        source = newSource;
    }

    @Override
    public void insert(int index, int value) {
        int[] newSource = new int[source.length + 1];
        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        newSource[index] = value;
        for (int i = index + 1; i < newSource.length; i++) {
            newSource[i] = source[i - 1];
        }
        source = newSource;
    }

    @Override
    public void delete(int index) {
        int[] newSource = new int[source.length - 1];
        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        for (int i = index + 1; i < source.length; i++) {
            newSource[i - 1] = source[i];
        }
        source = newSource;
    }

    @Override
    public boolean contains(int value) {
        for (int i : source) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size();
            }

            @Override
            public Integer next() {
                return get(position++);
            }

            @Override
            public void remove() {
                Iterator.super.remove();
            }
        };
    }

    public void printArray() {
        System.out.println(Arrays.toString(source));
    }
}
