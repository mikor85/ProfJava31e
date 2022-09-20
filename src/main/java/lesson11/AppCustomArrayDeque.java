package lesson11;

import java.util.Arrays;
import java.util.Iterator;

public class AppCustomArrayDeque {
    public static void main(String[] args) {

        CustomArrayDeque one = new CustomArrayDeque();
        System.out.println(one);
        one.addFirst(50);
        one.addFirst(40);
        one.addFirst(30);
        one.addFirst(20);
        one.addFirst(10);
        System.out.println(one);
        System.out.println("getFirst = " + one.getFirst());
        System.out.println("getLast = " + one.getLast());
        System.out.println("----------");
        System.out.println(one.size());

        Iterator<Integer> integerIterator = one.getBackwardIterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        CustomArrayDeque newCAD = new CustomArrayDeque();
        newCAD.addFirst(10);
        newCAD.addFirst(5);
        newCAD.addFirst(50);
        newCAD.addFirst(2);
        newCAD.addFirst(25);
        System.out.println("----------");

        // Manual sort
        int a[] = {10, 5, 50, 2, 25};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        // end of Manual sort

        System.out.println("----------");
        // Iterator<Integer> bigToSmallIterator = newCAD.new BackwardIterator();
        Iterator<Integer> bigToSmallIterator = newCAD.getBigToSmall();
        while (bigToSmallIterator.hasNext()) {
            System.out.println(bigToSmallIterator.next());
        }
    }
}
