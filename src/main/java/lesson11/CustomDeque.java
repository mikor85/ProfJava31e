package lesson11;

import java.util.Iterator;

// Deque - Double Ended Queue - двухсторонняя очередь,
// обеспечивает добавление и получение элементов с обоих концов контейнера
public interface CustomDeque /*extends Iterable<Integer>*/ {
    void addFirst(int i);                                 // добавление в начало

    int getFirst() throws IndexOutOfBoundsException;      // запрос первого элемента без удаления

    int removeFirst() throws IndexOutOfBoundsException;   // получение первого элемента и его последующее удаление

    void addLast(int i);                                  // добавление в конец

    int getLast() throws IndexOutOfBoundsException;       // получить последний элемент в очереди без удаления

    int removeLast() throws IndexOutOfBoundsException;    // получить последний элемент с его последующим удалением

    int size();                                           // кол-во элементов в массиве - размер массива для пользователя

    Iterator<Integer> getBackwardIterator();                // итератор для перебора в обратном направлении

    Iterator<Integer> iteratorBackwards();

    //Iterator<Integer> getBigToSmallIterator();           // итератор для перебора по убыванию значений элементов

}