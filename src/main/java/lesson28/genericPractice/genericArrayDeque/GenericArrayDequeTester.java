package lesson28.genericPractice.genericArrayDeque;

public class GenericArrayDequeTester {
    public static void main(String[] args) {
        GenericArrayDeque<Integer> deque = new GenericArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(10);
        deque.addLast(11);

        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);

        System.out.println("----------");

        GenericArrayDeque<String> dequeString = new GenericArrayDeque<>();
        dequeString.addFirst("Max");
        dequeString.addFirst("Anna");
        dequeString.addLast("Gena");
        dequeString.addLast("Katia");

        System.out.println(dequeString);
        dequeString.removeLast();
        System.out.println(dequeString);

    }
}