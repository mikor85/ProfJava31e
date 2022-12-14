package lesson11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayDeque implements CustomDeque {

    private int[] source;              // массив с содержимым
    private int size = 0;              // размер контейнера
    private int firstElementIndex = 0; // чтобы быстрее удалить или добавить элемент в начало

    private static final int CAPACITY = 4;

    public CustomArrayDeque() {
        source = new int[CAPACITY];
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


    // My version toString
    // @Override
    public String toStringVer2() {
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        StringBuilder result = new StringBuilder();
        result.append("[");
        if (firstElementIndex == 0) {
            for (int i = 0; i < size; i++) {
                result.append(source[i]);
                if (i != size - 1) {
                    result.append(", ");
                }
            }
        } else if (firstElementIndex + size <= source.length) {
            for (int i = firstElementIndex; i < firstElementIndex + size; i++) {
                result.append(source[i]);
                if (i != firstElementIndex + size - 1) {
                    result.append(", ");
                }
            }
        } else {
            for (int i = firstElementIndex; i < source.length; i++) {
                result.append(source[i]);
                result.append(", ");
            }
            for (int i = 0; i <= lastElementIndex; i++) {
                result.append(source[i]);
                if (i != lastElementIndex) {
                    result.append(", ");
                }
            }
        }
        result.append("]");

        return result.toString();
    }

    @Override
    public void addFirst(int value) {
        if (size == source.length) {
            // делаем новый массив в 2 раза больше и копируем элементы из старого в начало нового
            increaseCapacity();
        }
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
//        if(firstElementIndex == 0)
//            firstElementIndex = source.length - 1;
//        else
//            firstElementIndex = firstElementIndex - 1;

        source[firstElementIndex] = value;
        size++;
    }

    private void increaseCapacity() {
        int[] newSource = new int[source.length * 2];
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
    public int getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() {
        // вернуть элемент по firstElementIndex и
        // увеличить на единицу firstElementIndex
        // уменьшить на единицу size
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int element = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return element;
    }


    @Override
    public void addLast(int value) {
        if (size == source.length) {
            increaseCapacity();
        }
        source[(firstElementIndex + size) % source.length] = value;
        size++;
    }

    // My version addLast()
    // @Override
    public void addLastVer2(int value) {
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
    public int getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        return source[lastElementIndex];
    }

    @Override
    public int removeLast() {
        // вернуть значение элемента по последнему индексу,
        // уменьшить на единицу size
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        int element = source[lastElementIndex];
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iteratorBackwards() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position++ < size();
            }

            @Override
            public Integer next() {
                return source[((size + firstElementIndex) % source.length) - position];
            }
        };
    }

    @Override
    public Iterator<Integer> getBackwardIterator() {
        return new Iterator<>() {
            private int position = size;

            @Override
            public boolean hasNext() {
                return --position >= 0;
            }

            @Override
            public Integer next() {
                if (position < 0 || position >= size) {
                    throw new NoSuchElementException();
                }
                return source[(firstElementIndex + position) % source.length];
            }
        };
    }

    public BackwardIterator getBigToSmall() {
        return new BackwardIterator();
    }

    private class BackwardIterator implements Iterator<Integer> {

        private int[] data = new int[size];
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
        public Integer next() {
            if (position < 0 || position >= size) {
                throw new NoSuchElementException();
            }
            return data[position];
        }
    }
}
