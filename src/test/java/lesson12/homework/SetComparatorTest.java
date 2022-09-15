package lesson12.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetComparatorTest {

    @Test
    public void compareNullSets() {
        assertTrue(SetComparator.checkSets(null, null));
    }

    @Test
    public void compareEmptySets() {
        assertTrue(SetComparator.checkSets(new HashSet<String>(), new TreeSet<String>()));
    }

    @Test
    public void compareNonEmptySets() {
        Set<String> s1 = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        Set<String> s2 = new HashSet<>(Arrays.asList("One", "Three", "Two"));
        assertTrue(SetComparator.checkSets(s1, s2));
        Set<String> s3 = new HashSet<>(Arrays.asList("One", "Three"));
        assertFalse(SetComparator.checkSets(s1, s3));
        Set<String> s4 = new HashSet<>(Arrays.asList("One", "Three", "Five"));
        assertFalse(SetComparator.checkSets(s1, s4));
    }

    @Test
    public void checkSameSetEquals() {
        Set<String> s1 = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        assertTrue(SetComparator.checkSets(s1, s1));
    }
}
