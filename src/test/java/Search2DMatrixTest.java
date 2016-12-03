import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shuaiwang on 7/18/16.
 */
public class Search2DMatrixTest {
    @Test
    public void test() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        assertEquals(true, test.searchMatrix(matrix, 7));
    }
}
