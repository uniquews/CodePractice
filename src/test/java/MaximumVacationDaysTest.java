import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class MaximumVacationDaysTest {
    @Test
    public void testF1() {
        int[][] flight = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] days = {{1,3,1},{6,0,3},{3,3,3}};
        assertEquals(12, new MaximumVacationDays().maxVacationDays(flight, days));
//        assertEquals(18, new MaxSumOfRectangle().maxSumOfRectangle(matrix));
    }

    @Test
    public void testF2() {
        int[][] flight = {{0}};
        int[][] days = {{1}};
        assertEquals(1, new MaximumVacationDays().maxVacationDays(flight, days));
//        assertEquals(18, new MaxSumOfRectangle().maxSumOfRectangle(matrix));
    }
}
