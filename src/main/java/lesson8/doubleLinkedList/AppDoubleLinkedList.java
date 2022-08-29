package lesson8.doubleLinkedList;

public class AppDoubleLinkedList {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println(doubleLinkedList);
        System.out.println("Size of current linked list is: " + doubleLinkedList.size() + ".");
        System.out.println("----------");
        doubleLinkedList.addLast(1);
        System.out.println(doubleLinkedList);
        System.out.println("Size of current linked list is: " + doubleLinkedList.size() + ".");
        System.out.println("First object = " +doubleLinkedList.getFirst() + ".");
        System.out.println("Last object = " +doubleLinkedList.getLast() + ".");
        System.out.println("----------");
        doubleLinkedList.addLast(2);
        System.out.println(doubleLinkedList);
        System.out.println("Size of current linked list is: " + doubleLinkedList.size() + ".");
        System.out.println("First object = " +doubleLinkedList.getFirst() + ".");
        System.out.println("Last object = " +doubleLinkedList.getLast() + ".");
        System.out.println("----------");
        doubleLinkedList.addLast(3);
        System.out.println(doubleLinkedList);
        System.out.println("Size of current linked list is: " + doubleLinkedList.size() + ".");
        System.out.println("First object = " +doubleLinkedList.getFirst() + ".");
        System.out.println("Last object = " +doubleLinkedList.getLast() + ".");
        System.out.println("----------");
        doubleLinkedList.addLast(4);
        System.out.println(doubleLinkedList);
        System.out.println("Size of current linked list is: " + doubleLinkedList.size() + ".");
        System.out.println("First object = " +doubleLinkedList.getFirst() + ".");
        System.out.println("Last object = " +doubleLinkedList.getLast() + ".");
        System.out.println("----------");
        doubleLinkedList.addFirst(55);
        System.out.println(doubleLinkedList);
        System.out.println("Size of current linked list is: " + doubleLinkedList.size() + ".");
        System.out.println("First object = " +doubleLinkedList.getFirst() + ".");
        System.out.println("Last object = " +doubleLinkedList.getLast() + ".");

    }
}
