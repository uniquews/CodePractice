/**
 * Created by shuaiwang on 3/14/17.
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return 0;
        }

        int[][] result = new int[matrix.length][matrix[0].length];
        int len = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                len = Math.max(dfs(matrix, result, i ,j), len);
            }
        }
        return len;
    }

    private int dfs(int[][] matrix, int[][] result, int row, int col) {

        if (result[row][col] != 0) {
            return result[row][col];
        }

        int longestIncreasingLen = 1;
        if (row - 1 >= 0 && matrix[row][col] < matrix[row - 1][col]) {
            longestIncreasingLen = Math.max(longestIncreasingLen, dfs(matrix, result, row - 1, col) + 1);
        }

        if (row + 1 <= matrix.length - 1 && matrix[row][col] < matrix[row + 1][col]) {
            longestIncreasingLen = Math.max(longestIncreasingLen,  dfs(matrix, result, row + 1, col) + 1);
        }

        if (col - 1 >= 0 && matrix[row][col] < matrix[row][col - 1]) {
            longestIncreasingLen = Math.max(longestIncreasingLen, dfs(matrix, result, row, col - 1) + 1);
        }

        if (col + 1 <= matrix[0].length - 1 && matrix[row][col] < matrix[row][col + 1]) {
            longestIncreasingLen = Math.max(longestIncreasingLen, dfs(matrix, result, row, col + 1) + 1);
        }

        result[row][col] = longestIncreasingLen;
        return longestIncreasingLen;
    }
}
