import java.util.Arrays;

/**
 * Created by shuaiwang on 12/20/16.
 */
public class LongestIncreasingContinuoussubsequenceII {
    private boolean[][] visited;
    private int[][] dp;

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int row = A.length;
        int column = A[0].length;

        visited = new boolean[row][column];
        dp = new int[row][column];

        for (int[] eachRow : dp) {
            Arrays.fill(eachRow, 1);
        }

        int result = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result = Math.max(result, helper(i, j, A));
            }
        }
        return result;
    }

    private int helper(int row, int col, int[][] A) {
        if (visited[row][col]) {
            return dp[row][col];
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            if (row + dx[i] < 0 || row + dx[i] == A.length || col + dy[i] < 0 || col + dy[i] == A[0].length) {
                continue;
            }
            if (A[row][col] > A[row + dx[i]][col + dy[i]]) {
                dp[row][col] = Math.max(dp[row][col], helper(row + dx[i], col + dy[i], A) + 1);
            }
        }
        visited[row][col] = true;
        return dp[row][col];
    }
}
