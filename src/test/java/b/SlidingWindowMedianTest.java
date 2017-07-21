package b;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bohan on 7/15/17.
 */
public class SlidingWindowMedianTest {
    @Test
    public void test() {
        SlidingWindowMedian test = new SlidingWindowMedian();
        double[] res = test.medianSlidingWindow(new int[]{-1, -1, 1, -1, -1, -1, 1, 1, 1, 1, -1, -1}, 1);
        Assert.assertArrayEquals(res, new double[]{-1.0, -1.0, 1.0, -1.0, -1.0, -1.0, 1.0, 1.0, 1.0, 1.0, -1.0, -1.0}, 0.00001);
    }

    @Test
    public void test2() {
        //[9,7,0,3,9,8,6,5,7,6]
        SlidingWindowMedian test = new SlidingWindowMedian();
        double[] res = test.medianSlidingWindow(new int[]{9, 7, 0, 3}, 2);
        //[8.00000,3.50000,1.50000,6.00000,8.50000,7.00000,5.50000,6.00000,6.50000]
        Assert.assertArrayEquals(new double[]{8.00000, 3.50000, 1.50000}, res, 0.00001);
    }
}
