/**
 * Created by shuaiwang on 4/17/17.
 */

// 激情小视频： https://www.youtube.com/watch?v=yCQN096CwWM

public class MaxSumOfRectangle {
    public int maxSumOfRectangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null ||
                matrix[0].length == 0) {
            return 0;
        }

        int maxResult = Integer.MIN_VALUE;
        for (int top = 0; top < matrix.length; top++) {
            int[] row = new int[matrix[0].length];
            for (int bot = top; bot < matrix.length; bot++) {
                for (int col = 0; col < matrix[bot].length; col++) {
                    row[col] += matrix[bot][col];
                }
                maxResult = Math.max(new MaximumSubarray().maxSubArray(row), maxResult);
            }
        }
        return maxResult;
    }

}
