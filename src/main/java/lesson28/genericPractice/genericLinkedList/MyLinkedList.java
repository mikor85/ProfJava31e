package lesson28.genericPractice.genericLinkedList;

import java.util.Iterator;

public class MyLinkedList<V> implements MyList<V> {

    private Node<V> head;

    private static class Node<V> {
        private V value;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
        }

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<V> getNext() {
            return next;
        }

        public void setNext(Node<V> next) {
            this.next = next;
        }

    } // end of Node

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        Node<V> n = head;
        b.append("[");
        while (n != null) {
            b.append(n.getValue());
            n = n.getNext();
            if (n != null) {
                b.append(", ");
            }
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<V> n = head;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    @Override
    public void add(V value) {
        // идти начиная с head до последнего (пока getNext() != null)
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        Node<V> n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        // потом добавить новый Node и сделать так, чтобы последний на новый ссылался
        n.setNext(new Node<>(value));
    }

    @Override
    public void add(int index, V value) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        if (index == 0) {
            Node<V> n = new Node<>(value);
            n.setNext(head);
            head = n;
            return;
        }
        Node<V> n = head;
        Node<V> one = null;
        Node<V> two = null;
        while (n != null) {
            if (index == 1) {
                one = n;
                two = n.getNext();
                break;
            }
            index--;
            n = n.getNext();
        }
        if (one != null) {
            one.setNext(new Node<>(value, two));
        }
    }

    @Override
    public void addFirst(V value) {
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        Node<V> n = new Node<>(value);
        n.setNext(head);
        head = n;
    }

    @Override
    public void set(int index, V value) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<V> n = head;
        while (n != null) {
            if (index == 0) {
                n.setValue(value);
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public boolean contains(V value) {
        Node<V> n = head;
        while (n != null) {
            if (n.getValue() == value) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    @Override
    public V get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.getValue();
        }
        Node<V> n = head;
        while (n.getNext() != null) {
            n = n.getNext();
            index--;
            if (index == 0) {
                return n.getValue();
            }
        }
        return n.getValue();
    }

    @Override
    public V getFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.getValue();
    }

    @Override
    public void remove(int index) {
        if (head == null) {
            throw new NullPointerException();
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }
        if (head.getNext() == null) {
            head = null;
        }
        Node<V> n = head;
        while (n.getNext() != null) {
            if (index == 1) {  // считаем до предыдущего элемента
                n.next = n.getNext().getNext();
                return;
            }
            index--;
            n = n.getNext();
        }
    }


    @Override
    public void removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        head = head.getNext();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int position = -1;

            @Override
            public boolean hasNext() {
                // убедиться, что следующая позиция после position лежит внутри size()
                // после операции проверки сдвинуть позицию вперед
                return position++ + 1 < size();
            }

            @Override
            public V next() {
                return get(position);
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(position--);
            }
        };
    }
}