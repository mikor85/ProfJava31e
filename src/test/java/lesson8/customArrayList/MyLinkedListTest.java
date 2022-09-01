package lesson8.customArrayList;

import lesson8.linkedList.MyLinkedList;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyLinkedListTest {


    @Test
    public void testLinkedList() {
        MyLinkedList l = new MyLinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(3, l.size());

        assertEquals(3, l.get(2));

        assertTrue(l.contains(2));
        l.set(2, 22);
        assertEquals(l.get(2), 22);
        l.add(2, 33);
        assertEquals("[1, 2, 33, 22]", l.toString());
        l.remove(2);
        assertEquals("[1, 2, 22]", l.toString());

    }

    @Test
    public void testHeadRemove() {
        MyLinkedList l = new MyLinkedList();
        l.add(10);
        l.add(20);
        l.remove(0);
        assertEquals("[20]", l.toString());

    }

    @Test
    public void testRemove() {
        MyLinkedList l = new MyLinkedList();
        l.add(10);
        l.add(20);
        l.add(30);
        l.remove(1);
        assertEquals("[10, 30]", l.toString());

    }

    @Test
    public void testTailRemove() {
        MyLinkedList l = new MyLinkedList();
        l.add(10);
        l.add(20);
        l.add(30);
        l.remove(2);
        assertEquals("[10, 20]", l.toString());
    }

    @Test
    public void testIterator() {
        MyLinkedList l = new MyLinkedList();
        l.add(10);
        l.add(20);
        l.add(30);

        Iterator<Integer> i = l.iterator();
        assertTrue(i.hasNext());
        i.remove();
        assertEquals("[20, 30]", l.toString());
        assertTrue(i.hasNext());
        i.remove();
        assertEquals("[30]", l.toString());
        assertTrue(i.hasNext());
        i.remove();
        assertEquals("[]", l.toString());
    }
}
