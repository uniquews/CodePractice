import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuaiwang on 4/17/17.
 */
public class MaximumSubarrayNoLargerThanKTest {
    @Test
    public void testFunc() {
        MaximumSubarrayNoLargerThanK test = new MaximumSubarrayNoLargerThanK();
        int[] num = {3, 2, -4, 5, 8};
        int k = 4;
        assertEquals(3, test.maxSubarrayNoLargerThanK(num, k));
    }

    @Test
    public void testFunc2() {
        MaximumSubarrayNoLargerThanK test = new MaximumSubarrayNoLargerThanK();
        int[] num = {3, 2, -4, 5, 8};
        int k = 5;
        assertEquals(5, test.maxSubarrayNoLargerThanK(num, k));
    }

    @Test
    public void testFunc3() {
        MaximumSubarrayNoLargerThanK test = new MaximumSubarrayNoLargerThanK();
        int[] num = {3, 2, -4, 5, 8};
        int k = 7;
        assertEquals(6, test.maxSubarrayNoLargerThanK(num, k));
    }

    @Test
    public void testFunc4() {
        MaximumSubarrayNoLargerThanK test = new MaximumSubarrayNoLargerThanK();
        int[] num = {3, 2, -4, 5, 8};
        int k = 13;
        assertEquals(13, test.maxSubarrayNoLargerThanK(num, k));
    }

    @Test
    public void testFunc5() {
        MaximumSubarrayNoLargerThanK test = new MaximumSubarrayNoLargerThanK();
        int[] num = {2,2,-1};
        int k = 0;
        assertEquals(-1, test.maxSubarrayNoLargerThanK(num, k));
    }

}
