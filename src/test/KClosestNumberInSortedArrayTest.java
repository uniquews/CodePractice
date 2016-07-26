package test;

import main.KClosestNumberInSortedArray;
import org.junit.Test;
import org.junit.Assert;


/**
 * Created by shuaiwang on 7/24/16.
 */
public class KClosestNumberInSortedArrayTest {
    @Test
    public void test() {
        KClosestNumberInSortedArray test = new KClosestNumberInSortedArray();
        int[] input = {1,10,15,25,35,45,50,59};
        int target = 30;
        int k = 7;
        int [] result = {25,35,15,45,10,50,1};
        Assert.assertArrayEquals(result, test.kClosestNumbers(input, target, k));
    }
}
