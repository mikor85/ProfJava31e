package lesson11;

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
        //System.out.println("getLast = " + one.getLast());


    }
}
