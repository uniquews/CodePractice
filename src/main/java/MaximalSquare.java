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

        for (int i = 0; i < matrix[0].length; i++) {
            f[0][i] = matrix[0][i] - '0';
            if (matrix[0][i] == '1')
                result = 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            f[i][0] = matrix[i][0] - '0';
            if (matrix[i][0] == '1')
                result = 1;
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    result = Math.max(result, f[i][j]);
                }
            }
        }
        return result * result;
    }
}
