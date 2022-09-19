package lesson11;

import java.util.Iterator;

public class AppCustomArrayDeque {
    public static void main(String[] args) {

        CustomArrayDeque one = new CustomArrayDeque();
        System.out.println(one);
        one.addFirst(20);
        one.addFirst(10);
        one.addLast(30);
        one.addLast(40);
        one.addLast(50);
        System.out.println(one);
        System.out.println("getFirst = " + one.getFirst());
        System.out.println("getLast = " + one.getLast());

        Iterator<Integer> integerIterator = one.iteratorBackwards();

        System.out.println("----------");
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }
}
