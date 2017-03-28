import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by bohan on 3/27/17.
 */
public class FindPeakElementIITest {
    @Test
    public void test() {
        FindPeakElementII test = new FindPeakElementII();
        int[][] board = {{1, 1, 1, 1, 1}, {1, 2, 3, 2, 1}, {1, 1, 1, 1, 1}};
        assertArrayEquals(new int[]{1, 2}, test.findPeak(board));
    }

    @Test
    public void test2() {
        FindPeakElementII test = new FindPeakElementII();
        int[][] board = {{1, 1, 1, 1, 1}, {1, 2, 5, 2, 1}, {1, 2, 4, 2, 1}, {1, 2, 3, 2, 1}, {1, 1, 1, 1, 1}};
        assertArrayEquals(new int[]{1, 2}, test.findPeak(board));
    }

    @Test
    public void test3() {
        FindPeakElementII test = new FindPeakElementII();
        int[][] board = {{1, 1, 1, 1, 1}, {1, 2, 3, 2, 1}, {1, 3, 4, 3, 1}, {1, 2, 5, 6, 1}, {1, 1, 1, 1, 1}};
        assertArrayEquals(new int[]{3, 3}, test.findPeak(board));
    }
}
