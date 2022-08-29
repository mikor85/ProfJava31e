package lesson8.linkedList;

import lesson7.list.MyList;

import java.util.Iterator;

// ДЗ проф ява:
// 1. Дописать delete, iterator() и тесты.

// 2. * Дописать remove в итераторе.

// 3. Дописать методы void addFirst(int), void removeFirst(), int getFirst()
// добавляющие, удаляющие и получающие первый элемент в списке.

public class MyLinkedList implements MyList {
    // List implementations, LinkedList.

    private Node head;  // первый элемент списка

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    } // end of Node

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        Node n = head;
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
        Node n = head;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    @Override
    public void add(int value) {
        // идти начиная с head до последнего (пока getNext() != null)
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        // потом добавить новый Node и сделать так, чтобы последний на новый ссылался
        n.setNext(new Node(value));
    }

    @Override
    public void add(int index, int value) {
        Node n = head;
        Node one = null;
        Node two = null;
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
            one.setNext(new Node(value, two));
        }
    }

    @Override
    public void addFirst(int value) {
        if (head == null) {
            head = new Node(value);
        }
        Node n = new Node(value);
        n.setNext(head);
        head = n;
    }

    @Override
    public void set(int index, int value) {
        Node n = head;
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
    public boolean contains(int value) {
        Node n = head;
        while (n != null) {
            if (n.getValue() == value) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    @Override
    public int get(int index) {
        Node n = head;
        int i = 0;
        while (n != null) {
            if (index == 0) {
                return n.getValue();
            }
            index--;
            n = n.getNext();
        }
        return n.getValue();
    }

    @Override
    public int getFirst() {
        return head.getValue();
    }

    @Override
    public void remove(int index) {
        if (head.getNext() == null){
            head = null;
        }
        if (index == 0 && head != null) {
            head = head.getNext();
            return;
        }
        Node n = head;
        while (n.getNext() != null) {
            if (index == 1) {
                n.next = n.getNext().getNext();
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public void removeFirst() {
        head = head.getNext();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size();
            }

            @Override
            public Integer next() {
                return get(position++);
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(position);
            }
        };
    }

    public static void main(String[] args) {
        // Node n = new MyLinkedList().new Node(); // внутренний не статический класс
        // Node n = new MyLinkedList.Node(); // внутренний статический класс
        MyLinkedList l = new MyLinkedList();
        System.out.println(l);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        System.out.println(l);
        System.out.println("Size of current linked list is: " + l.size());
        System.out.println("----------");
        l.remove(1);
        System.out.println("After remove method: " + l);
        System.out.println("----------");
        System.out.println("----------");
        l.removeFirst();
        System.out.println("After removeFirst method: " + l);
        System.out.println("----------");
        l.addFirst(1);
        System.out.println("After addFirst method: " + l);
        System.out.println("Size of current linked list is: " + l.size());
        System.out.println("----------");
        l.addFirst(0);
        System.out.println("After addFirst method: " + l);
        System.out.println("Size of current linked list is: " + l.size());
        System.out.println("getFirst object: " + l.getFirst());

        System.out.println("----------");
        l.iterator().remove();


    } // end of main
}