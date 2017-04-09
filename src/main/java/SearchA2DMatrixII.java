/**
 * Created by shuaiwang on 4/8/17.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) { // 扫描过的右上角和比当前值小的左上角都不要
                row++;
            } else {
                col--; //扫描过的右上角和比当前值都打的右下角都不要
            }
        }
        return false;
    }
}
