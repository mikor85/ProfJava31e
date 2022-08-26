package lesson8.customArrayList;

import lesson7.arrayList.MyCustomArrayList;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyCustomArrayListTest {
    @Test
    public void testMyCustomArrayList()
    {
        MyCustomArrayList l  = new MyCustomArrayList();
        assertEquals(0, l.size());
        l.add(1);
        assertEquals(1, l.size());
        assertEquals(l.get(0), 1);
        l.add(2);
        l.add(3);
        Iterator<Integer> i = l.iterator();
        assertTrue(i.hasNext());
        assertEquals(1, (int) i.next());
        assertTrue(i.hasNext());
        assertEquals(2, (int) i.next());
        assertTrue(i.hasNext());

        i.remove();

        assertEquals(3, (int) i.next());
        assertTrue(i.hasNext());
    }
}
