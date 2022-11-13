package lesson31;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListTest {

    List<String> words = List.of("Hello", "Hell");

    @Test
    public void testList() {
        // проверьте что каждый элемент начинается на "H" и содержит "ll"
        assertThat(words, allOf(everyItem(containsString("ll")), everyItem(startsWith("H"))));
    }

}