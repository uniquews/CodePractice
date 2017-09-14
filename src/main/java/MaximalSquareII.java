public class MaximalSquareII {
    /***
     * 记录i - 1, j 和 i, j - 1目前有多少0
     * f[i][j] 如果是一个边长为len的valid的sqaure，i行和j列必有len个0，并且f[i - 1][j - 1] = len - 1. (f[i - 1][j - 1]已经
     * 保证了只有对角线是1)
     *
     */

    public int maxSquare2(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if (n == 0)
            return 0;

        int m = matrix[0].length;
        if (m == 0)
            return 0;

        int[][] f = new int[n][m];
        int[][] u = new int[n][m];
        int[][] l = new int[n][m];

        int length = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    f[i][j] = 0;
                    u[i][j] = l[i][j] = 1;
                    if (i > 0)
                        u[i][j] = u[i - 1][j] + 1;
                    if (j > 0)
                        l[i][j] = l[i][j - 1] + 1;
                } else {
                    u[i][j] = l[i][j] = 0;
                    if (i > 0 && j > 0)
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(u[i - 1][j], l[i][j - 1])) + 1;
                    else
                        f[i][j] = 1;
                }
                length = Math.max(length, f[i][j]);
            }
        return length * length;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        MaximalSquareII test = new MaximalSquareII();
        test.maxSquare2(a);
    }
}
