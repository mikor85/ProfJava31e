package lesson6.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressListTest {

    @Test
    public void testGetAddresses() {
        List<Address> res = Arrays.asList(
                new Address("Main street", "12"),
                new Address("Fleet street", "1"),
                new Address("Light street", "44"));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Max Kotkov", new Address("Main street", "12")));
        people.add(new Person("Semen Petrov", new Address("Fleet street", "1")));
        people.add(new Person("Maria Ivanova", new Address("Light street", "44")));

        assertEquals(res, Tester.getAddresses(people));
    }
}