package lesson29;

import lesson28.homework.Car;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;

public class ProbeTester {

    @Test
    public void testProbeMessage() {
        assertThat(Probe.getMessage(3), anyOf(is("Hello"), is("World")));
        assertThat(Probe.getMessage(23), is("Hello"));
        assertThat(Probe.getMessage(3), is("World"));

        assertThat(Probe.getMessage(), anyOf(is("Hello"), is("World")));

        assertThat(Probe.getMessage(23), allOf(startsWith("He"), endsWith("lo")));
    }

    @Test
    public void carTest() {
        assertThat(Probe.getCar(), instanceOf(Car.class));
        assertThat((Car) Probe.getCar(), hasProperty("price", Matchers.closeTo(20_000, 0.1)));
    }

    @Test
    public void collectionTest() {
        List<String> names = List.of("Max", "Dima", "Alex", "Marina");
        assertThat(names, allOf(hasItem("Dima"), hasItem("Alex")));
        assertThat(names, hasItems("Dima", "Alex"));
        assertThat(names, containsInAnyOrder("Dima", "Alex", "Max", "Marina"));
    }
}