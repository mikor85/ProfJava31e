package lesson28.genericPractice.genericArrayList;

import java.util.Iterator;

public class MyGenericArrayList<V> implements MyArrayListGeneric<V> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] data;
    private int size = 0;

    public MyGenericArrayList() {
        data = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void set(int index, V value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    @Override
    public V get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (V) data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(V value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = value;
    }

    @Override
    public void append(Object[] a) {
        if (size == data.length + a.length) {
            increaseCapacity();
        }

        for (int i = 0; i < a.length; i++) {
            append((V) a[i]);
        }
    }

    @Override
    public void insert(int index, V value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (size == data.length)
            increaseCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void add(V value) {
        Object[] newData = new Object[size() + 1];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
        newData[size()] = value;
        data = newData;
    }

    @Override
    public void remove(int index) {
        Object[] newSource = new Object[data.length - 1];
        for (int i = 0; i < index; i++) {
            newSource[i] = data[i];
        }
        for (int i = index + 1; i < data.length; i++) {
            newSource[i - 1] = data[i];
        }
        data = newSource;
    }


    @Override
    public void insert(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newData = new Object[data.length - 1];
        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }
        for (int i = index + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }
        data = newData;
        size--;
    }

    @Override
    public boolean contains(V value) {
        for (Object i : data) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    private void increaseCapacity() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print(data[i] + ", ");
            } else {
                System.out.print(data[i]);
            }
        }
        System.out.print("]");
        System.out.println();
    }

    @Override
    public Iterator<V> iterator() {

        return new Iterator<V>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size();
            }

            @Override
            public V next() {
                if (position < size()) {
                    return get(position++);
                } else return null;
            }

            @Override
            public void remove() {
                MyGenericArrayList.this.remove(position);
            }
        };
    }
}