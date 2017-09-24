/**
 * Created by shuaiwang on 12/17/16.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int[][] f = new int[matrix.length][matrix[0].length];
        int result = 0;

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = matrix[i][j] - '0';
                    result = Math.max(result, f[i][j]);
                    continue;
                }
                if (matrix[i][j] == '0') {
                    continue;
                }

                f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                result = Math.max(result, f[i][j]);
            }
        }
        return result * result;
    }
}
