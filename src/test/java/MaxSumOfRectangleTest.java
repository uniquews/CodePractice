import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuaiwang on 4/17/17.
 */
public class MaxSumOfRectangleTest {
    @Test
    public void testF1() {
        int[][] matrix = {{2,1,-3,-4,5}, {0,6,3,4,1}, {2,-2,-1,4,-5},{-3,3,1,0,3}};
        assertEquals(18, new MaxSumOfRectangle().maxSumOfRectangle(matrix));
    }
}
