package lesson8.doubleLinkedList;

// 4. **** Сделать DoubleLinkedList класс на базе MyLinkedList -
// добавить ссылку на предыдущий элемент в каждый
// DoubleLinkedNode (prev, next ссылки на предыдущий и следующий элементы)
// и добавить ссылку DoubleLinkedNode tail (на конечный элемент) в класс;
// добавить методы void addLast(int), void removeLast() и int getLast()
// добавляющие, удаляющие и получающие последний элемент в списке.

import lesson8.linkedList.MyLinkedList;

import java.util.Iterator;

public class DoubleLinkedList implements MyDoubleLinkedList {

    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    private static class DoubleLinkedNode {
        private int value;
        private DoubleLinkedNode next;
        private DoubleLinkedNode prev;

        public DoubleLinkedNode(int value) {
            this.value = value;
        }

        public DoubleLinkedNode(int value, DoubleLinkedNode next, DoubleLinkedNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DoubleLinkedNode getNext() {
            return next;
        }

        public void setNext(DoubleLinkedNode next) {
            this.next = next;
        }

        public DoubleLinkedNode getPrev() {
            return prev;
        }

        public void setPrev(DoubleLinkedNode prev) {
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder resPrint = new StringBuilder();
        DoubleLinkedNode node = head;
        resPrint.append("[");
        while (node != null) {
            resPrint.append(node.getValue());
            node = node.getNext();
            if (node != null) {
                resPrint.append(", ");
            }
        }
        resPrint.append("]");
        return resPrint.toString();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        DoubleLinkedNode node = head;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    @Override
    public void add(int index, int value) {

    }

    @Override
    public void addFirst(int value) {
        if (head == null && tail == null) {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        if (size() == 1 /*&& head.equals(tail)*/) {
            head = new DoubleLinkedNode(value);
            tail.setPrev(head);
            head.setNext(tail);
            return;
        }
        DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(value);
        head.prev = doubleLinkedNode;
        doubleLinkedNode.setNext(head);
        head = doubleLinkedNode;

//        System.out.println("=== TEST == START ===");
//        System.out.println("HEAD.getNext() = " + head.getNext());
//        System.out.println("HEAD.getPrev() = " + head.getPrev());
//        System.out.println("TAIL.getNext() = " + tail.getNext());
//        System.out.println("TAIL.getPrev() = " + tail.getPrev());
//        System.out.println("=== TEST == STOP ===");
    }

    @Override
    public void addLast(int value) {
        // проверяем, есть ли вообще объекты в листе
        if (head == null && tail == null) {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        // определяем условия добавления 1-ого элемента
        if (size() == 1 /*&& head.equals(tail)*/) {
            tail = new DoubleLinkedNode(value);
            head.setNext(tail);
            tail.setPrev(head);
            return;
        }
        // определяем условия добавления 2-ого и последующих элементов
        DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(value);
        tail.next = doubleLinkedNode;
        doubleLinkedNode.setPrev(tail);
        tail = doubleLinkedNode;
    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public int get(int index) {
        DoubleLinkedNode node = head;
        while (node != null) {
            if (index == 0) {
                return node.getValue();
            }
            index--;
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public int getFirst() {
        return head.getValue();
    }

    @Override
    public int getLast() {
        //System.out.println("TEST tail.prev = " + tail.getPrev());
        return tail.getValue();
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
