package lesson11;

public class CustomArrayDeque implements CustomDeque {

    private int[] source;              // массив с содержимым
    private int size = 0;              // размер контейнера
    private int firstElementIndex = 0; // чтобы быстрее удалить/добавить элемент в начало

    private static final int CAPACITY = 4;

    CustomArrayDeque() {
        source = new int[CAPACITY];
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
            // делаем новый массив в 2 раза больше и копируем элементы из старого в начало нового
            increaseCapacity();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        source[lastElementIndex] = value;
        size++;
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
}
