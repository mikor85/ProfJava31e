package lesson7.list;

import java.util.Iterator;

public class MyListSimpleImplementation implements MyList {

    private int[] data;

    public MyListSimpleImplementation() {
        data = new int[0];
    }

    @Override
    public void add(int value) {
        int[] newData = new int[size() + 1];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
        newData[size()] = value;
        data = newData;
    }

    @Override
    public void add(int index, int value) {
        int[] newData = new int[size() + 1];
        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }
        newData[index] = value;
        for (int i = 0; i < size()
                ; i++) {
            newData[i + 1] = data[i];
        }
        data = newData;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public int get(int index) {
        return data[index];
    }

    @Override
    public void remove(int index) {
        int[] newData = new int[size() - 1];
        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }
        for (int i = index + 1; i < size(); i++) {
            newData[i - 1] = data[i];
        }
        data = newData;
    }

    @Override
    public int size() {
        return data.length;
    }

    // hasNext() - есть ли следующий элемент
    // net()     - значение следующего элемента и переход на него
    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {  // анонимный внутренний класс
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size();  // проверяем если позиция итераторе меньше длины контейнера
            }

            @Override
            public Integer next() {
                return get(position++);
            }
        };
    }
}
