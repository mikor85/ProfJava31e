package lesson11;


// Deque - Double Ended Queue - двухсторонняя очередь,
// обеспечивает добавление и получение элементов с обоих концов контейнера
public interface CustomDeque {
    void addFirst(int i);                                    // добавление в начало

    int getFirst() throws IndexOutOfBoundsException;         // запрос первого элемента без удаления

    int removeFirst() throws IndexOutOfBoundsException;      // получение первого элемента и его последующее удаление

    void addLast(int i);                                     // добавление в конец

    int getLast() throws IndexOutOfBoundsException;          // получить последний элемент в очереди без удаления

    int removeLast() throws IndexOutOfBoundsException;       // получить последний элемент с его последующим удалением

    int size();
}
