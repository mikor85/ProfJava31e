package lesson28.genericPractice.genericArrayDeque;

import java.util.Iterator;

public interface CustomDeque<V> {
    void addFirst(V value);                                 // добавление в начало

    V getFirst() throws IndexOutOfBoundsException;      // запрос первого элемента без удаления

    V removeFirst() throws IndexOutOfBoundsException;   // получение первого элемента и его последующее удаление

    void addLast(V value);                                  // добавление в конец

    V getLast() throws IndexOutOfBoundsException;       // получить последний элемент в очереди без удаления

    V removeLast() throws IndexOutOfBoundsException;    // получить последний элемент с его последующим удалением

    int size();                                           // кол-во элементов в массиве - размер массива для пользователя

    Iterator<V> getBackwardIterator();                // итератор для перебора в обратном направлении

    Iterator<V> iteratorBackwards();
}