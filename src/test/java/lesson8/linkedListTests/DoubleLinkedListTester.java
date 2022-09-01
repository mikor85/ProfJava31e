package lesson8.linkedListTests;

import lesson8.doubleLinkedList.DoubleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleLinkedListTester {
    @Test
    public void testAdd() {
        DoubleLinkedList l = new DoubleLinkedList();
        l.addLast(10);
        l.addLast(20);
        assertEquals("[10, 20]", l.toString());
        assertEquals(10, l.get(0));
        l.set(1, 30);
        assertEquals(30, l.get(1));
    }

    @Test
    public void testAssPosition() {
        DoubleLinkedList l = new DoubleLinkedList();
        l.add(0, 10);
        l.add(1, 30);
        l.add(1, 20);
        assertEquals("[10, 20, 30]", l.toString());
    }

    @Test
    public void testRemove() {
        DoubleLinkedList l = new DoubleLinkedList();
        l.addLast(10);
        l.addLast(20);
        l.addLast(30);
        l.remove(1);
        assertEquals("[10, 30]", l.toString());
        l.remove(1);
        assertEquals("[10]", l.toString());
        l.remove(0);
        assertEquals("[]", l.toString());
    }
}
