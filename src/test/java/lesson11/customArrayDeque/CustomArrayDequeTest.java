package lesson11.customArrayDeque;

import lesson11.CustomArrayDeque;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomArrayDequeTest {

    @Test
    public void testAddFirst() {
        CustomArrayDeque one = new CustomArrayDeque();
        one.addFirst(50);
        one.addFirst(40);
        one.addFirst(30);
        one.addFirst(20);
        one.addFirst(10);

        assertEquals("[10, 20, 30, 40, 50]", one.toString());
    }

    @Test
    public void testGetFirst() {
        CustomArrayDeque one = new CustomArrayDeque();
        one.addFirst(10);

        assertEquals(10, one.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        CustomArrayDeque one = new CustomArrayDeque();
        one.addFirst(20);
        one.addFirst(10);
        one.removeFirst();

        assertEquals("[20]", one.toString());
    }

    @Test
    public void testAddLast() {
        CustomArrayDeque one = new CustomArrayDeque();
        one.addLast(10);
        one.addLast(20);

        assertEquals("[10, 20]", one.toString());
        System.out.println(one);
    }

    @Test
    public void testGetLast() {
        CustomArrayDeque one = new CustomArrayDeque();
        one.addLast(10);

        assertEquals(10, one.getLast());
    }

    @Test
    public void testRemoveLast() {
        CustomArrayDeque one = new CustomArrayDeque();
        one.addFirst(20);
        one.addFirst(10);

        assertEquals(20, one.removeLast());
        assertEquals(1, one.size());
        assertEquals("[10]", one.toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testThrowsExceptionGettingElementFromEmptyDeque() {
        CustomArrayDeque d = new CustomArrayDeque();
        d.getLast();
    }

}
