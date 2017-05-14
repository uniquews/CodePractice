/**
 * Created by shuaiwang on 5/11/17.
 */
public class SlidingWindowMatrixMaximum {
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // Write your code here
        int row = matrix.length;
        int col = matrix[0].length;
        int result = Integer.MIN_VALUE;
        int[][] sum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            sum[i][1] = sum[i - 1][1] + matrix[i - 1][0];
        }

        for (int i = 1; i <= col; i++) {
            sum[1][i] = sum[1][i - 1] + matrix[0][i - 1];
        }

        for (int i = 2; i <= row; i++) {
            for (int j = 2; j <= col; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = k; i <= row; i++) {
            for (int j = k; j <= col; j++) {
                int squareSum = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                result = Math.max(result, squareSum);
            }
        }
        return result;
    }
}
