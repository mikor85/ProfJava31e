package lesson28.genericPractice.genericArrayDeque;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayDeque<V> implements CustomDeque<V> {

    private Object[] source;              // массив с содержимым
    private int size = 0;              // размер контейнера
    private int firstElementIndex = 0; // чтобы быстрее удалить или добавить элемент в начало

    private static final int CAPACITY = 4;

    public CustomArrayDeque() {
        source = new Object[CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < size; i++) {
            b.append(source[(firstElementIndex + i) % source.length]);
            if (i < size - 1)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public void addFirst(V value) {
        if (size == source.length) {
            increaseCapacity();
        }
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = value;
        size++;
    }

    private void increaseCapacity() {
        Object[] newSource = new Object[source.length * 2];
        int j = 0;  // индекс в новом массиве
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j++] = source[i];
        }
        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j++] = source[i];
        }
        firstElementIndex = 0;
        source = newSource;
    }

    @Override
    public V getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return (V) source[firstElementIndex];
    }

    @Override
    public V removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        V element = (V) source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return element;
    }


    @Override
    public void addLast(V value) {
        if (size == source.length) {
            increaseCapacity();
        }
        source[(firstElementIndex + size) % source.length] = value;
        size++;
    }

    // My version addLast()
    // @Override
    public void addLastVer2(V value) {
        if (size == source.length) {
            // делаем новый массив в 2 раза больше и копируем элементы из старого в начало нового
            increaseCapacity();
        }
        size++;
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        source[lastElementIndex] = value;
        //size++;
    }

    @Override
    public V getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        return (V) source[lastElementIndex];
    }

    @Override
    public V removeLast() {
        // вернуть значение элемента по последнему индексу,
        // уменьшить на единицу size
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        V element = (V) source[lastElementIndex];
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iteratorBackwards() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position++ < size();
            }

            @Override
            public V next() {
                return (V) source[((size + firstElementIndex) % source.length) - position];
            }
        };
    }

    @Override
    public Iterator<V> getBackwardIterator() {
        return new Iterator<>() {
            private int position = size;

            @Override
            public boolean hasNext() {
                return --position >= 0;
            }

            @Override
            public V next() {
                if (position < 0 || position >= size) {
                    throw new NoSuchElementException();
                }
                return (V) source[(firstElementIndex + position) % source.length];
            }
        };
    }

    public BackwardIterator getBigToSmall() {
        return new BackwardIterator();
    }

    private class BackwardIterator implements Iterator<V> {

        private Object[] data = new Object[size];
        private int position = size;

        public BackwardIterator() {
            for (int i = 0; i < size; i++) {
                data[i] = source[(firstElementIndex + i) % source.length];
            }
            Arrays.sort(data);
        }

        @Override
        public boolean hasNext() {
            return --position >= 0;
        }

        @Override
        public V next() {
            if (position < 0 || position >= size) {
                throw new NoSuchElementException();
            }
            return (V) data[position];
        }
    }
}