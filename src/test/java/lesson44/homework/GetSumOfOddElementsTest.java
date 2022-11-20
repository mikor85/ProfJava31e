package lesson44.homework;

import org.junit.Assert;
import org.junit.Test;

public class GetSumOfOddElementsTest {

    @Test
    public void testGetSum() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Assert.assertEquals(20, GetSumOfOddElements.getSum(arr));
    }
}