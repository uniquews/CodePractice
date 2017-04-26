/**
 * Created by shuaiwang on 4/25/17.
 */
public class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        int result = 0;
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0)
            return result;

        int[][] f = new int[M.length][M[0].length]; //左对角线
        int[][] r = new int[M.length][M[0].length]; //前一行
        int[][] c = new int[M.length][M[0].length]; //前一列
        int[][] d = new int[M.length][M[0].length]; //右对角线

        for (int i = 0; i < M.length; i++) {
            if (M[i][0] == 0)
                continue;
            f[i][0] = 1;
            r[i][0] = i == 0 ? 1 : r[i - 1][0] + 1;
            c[i][0] = 1;
            result = Math.max(result, Math.max(Math.max(f[i][0], r[i][0]), c[i][0]));
        }

        for (int i = 0; i < M[0].length; i++) {
            if (M[0][i] == 0)
                continue;
            f[0][i] = 1;
            r[0][i] = 1;
            c[0][i] = i == 0 ? 1 : c[0][i - 1] + 1;
            if (M[i][M[0].length - 1] == 1)
                d[i][M[0].length - 1] = 1;
            result = Math.max(result, Math.max(Math.max(f[0][i], r[0][i]), c[0][i]));
        }

        for (int i = 0; i < M.length; i++) {
            if (M[i][M[0].length - 1] == 0)
                continue;
            d[i][M[0].length - 1] = 1;
        }

        for (int i = 1; i < M.length; i++) {
            for (int j = M[0].length - 2; j >= 0; j--) {
                if (M[i][j] == 0)
                    continue;
                d[i][j] = d[i - 1][j + 1] + 1;
                result = Math.max(result, d[i][j]);
            }
        }

        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                f[i][j] = f[i - 1][j - 1] + 1;
                r[i][j] = r[i - 1][j] + 1;
                c[i][j] = c[i][j  -1] + 1;
                result = Math.max(result, Math.max(Math.max(f[i][j], r[i][j]), c[i][j]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] a = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
        int[][] a = {
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}};
//        int[][] a = {{1,1,1,1},{0,1,1,0},{0,0,0,1}};
        LongestLineOfConsecutiveOneInMatrix test = new LongestLineOfConsecutiveOneInMatrix();
        System.out.print(test.longestLine(a));
    }

}
