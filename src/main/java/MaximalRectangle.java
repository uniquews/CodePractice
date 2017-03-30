import java.util.Stack;

/**
 * Created by shuaiwang on 3/27/17.
 */
public class MaximalRectangle {

    /*
    * 思路：
    *   0 0 0 0
        1 1 1 1
        1 1 1 0
        0 1 0 0

        转换成

        0 0 0 0
        1 1 1 1
        2 2 2 0
        0 2 0 0  碰到0就归零，剩下的记录本行本列和前面所有行行本列的高度
    * */

    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0] == null)
            return 0;
        int[][] height = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    height[i][j] = matrix[i][j] ? 1 : 0;
                } else {
                    height[i][j] = matrix[i][j] ? height[i - 1][j] + 1 : 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, helper(height[i]));
        }
        return max;
    }

    // Largest Rectangle in Histogram
    private int helper(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = i == height.length ? -1 : height[i];
            while (!stk.isEmpty() && h < height[stk.peek()]) {
                int currentMinH = height[stk.pop()];
                int width = stk.isEmpty() ? i : i - stk.peek() - 1;
                max = Math.max(currentMinH * width, max);
            }
            stk.push(i);
        }
        return max;
    }
}
