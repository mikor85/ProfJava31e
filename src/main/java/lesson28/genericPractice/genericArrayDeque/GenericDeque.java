package lesson28.genericPractice.genericArrayDeque;

import java.util.Iterator;

public interface GenericDeque<T> {
    void addFirst(T value);                                 // добавление в начало

    T getFirst() throws IndexOutOfBoundsException;      // запрос первого элемента без удаления

    T removeFirst() throws IndexOutOfBoundsException;   // получение первого элемента и его последующее удаление

    void addLast(T value);                                  // добавление в конец

    T getLast() throws IndexOutOfBoundsException;       // получить последний элемент в очереди без удаления

    T removeLast() throws IndexOutOfBoundsException;    // получить последний элемент с его последующим удалением

    int size();                                           // кол-во элементов в массиве - размер массива для пользователя

    Iterator<T> getBackwardIterator();                // итератор для перебора в обратном направлении

    Iterator<T> iteratorBackwards();
}