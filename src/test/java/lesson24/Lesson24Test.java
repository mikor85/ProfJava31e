package lesson24;

import lesson11.CustomArrayDeque;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Lesson24Test {
    @Test
    public void sumLastNTest() {

        List<Integer> list = List.of(10,9,8,7,6,5,4,3,2,1,0);
        List<Integer> list1 = List.of(2,1,0);CustomArrayDeque one = new CustomArrayDeque();

        assertEquals(10, Lesson24.sumLastN(list,5));
        assertEquals(3, Lesson24.sumLastN(list1,5));
    }

    @Test
    public void filterList() {

        List<String> months = List.of("january", "february", "march", "june", "march"); // {"january", "february", "march"}
        Set<String> res = Lesson24.filterList(months, "r");
        assertEquals(res.size(), 3);
        assertTrue(res.contains("january"));
        assertTrue(res.contains("february"));
        assertTrue(res.contains("march"));
    }
}
