/**
 * Created by shuaiwang on 11/14/16.
 */
public class NQueensII {
    int sum;

    public int totalNQueens(int n) {
        //write your code here
        int[] map = new int[n];

        dfs(map, n, 0);
        return sum;
    }

    private void dfs(int[] map, int row, int level) {
        if (level == row) {
            sum++;
            return;
        }

        for (int i = 0; i < row; i++) {
            map[level] = i;
            if (isValid(map, level, i)) {
                dfs(map, row, level + 1);
            }
        }
    }

    private boolean isValid(int[] map, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (map[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(map[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
