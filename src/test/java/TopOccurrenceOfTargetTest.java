import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuaiwang on 7/23/16.
 */
public class TopOccurrenceOfTargetTest {

    @Test
    public void test() {
        TopOccurrenceOfTarget test = new TopOccurrenceOfTarget();
        int[] input = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(11, test.totalOccurrence(input, 1));
    }
}

