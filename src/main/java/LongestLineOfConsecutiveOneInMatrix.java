import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shuaiwang on 4/25/17.
 */
public class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0)
            return 0;
        int result = 0;

        int[][] f = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            f[i][0] = M[i][0];
            result = Math.max(result, f[i][0]);
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                if (M[i][j] != 0) {
                    f[i][j] = f[i][j - 1] + 1;
                    result = Math.max(result, f[i][j]);
                }
            }
        }
        f = new int[M.length][M[0].length];

        for (int i = 0; i < M[0].length; i++) {
            f[0][i] = M[0][i];
            result = Math.max(result, f[0][i]);
        }

        for (int i = 0; i < M[0].length; i++) {
            for (int j = 1; j < M.length; j++) {
                if (M[j][i] != 0) {
                    f[j][i] = f[j - 1][i] + 1;
                    result = Math.max(result, f[j][i]);
                }
            }
        }
        f = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = M[i][j];
                } else {
                    if (M[i][j] != 0) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                        result = Math.max(result, f[i][j]);
                    }
                }
            }
        }

        f = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = M[0].length - 1; j >= 0; j--) {
                if (i == 0 || j == M[0].length - 1) {
                    f[i][j] = M[i][j];
                } else {
                    if (M[i][j] != 0) {
                        f[i][j] = f[i - 1][j + 1] + 1;
                        result = Math.max(result, f[i][j]);
                    }
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
////        int[][] a = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
//        int[][] a = {
//                {1,1,0,0,1,0,0,1,1,0},
//                {1,0,0,1,0,1,1,1,1,1},
//                {1,1,1,0,0,1,1,1,1,0},
//                {0,1,1,1,0,1,1,1,1,1},
//                {0,0,1,1,1,1,1,1,1,0},
//                {1,1,1,1,1,1,0,1,1,1},
//                {0,1,1,1,1,1,1,0,0,1},
//                {1,1,1,1,1,0,0,1,1,1},
//                {0,1,0,1,1,0,1,1,1,1},
//                {1,1,1,0,1,0,1,1,1,1}};
//        int[][] a = {{1,1,1,1},{0,1,1,0},{0,0,0,1}};
        int[][] a = {{1,1,1,1}, {1,1,1,1}, {0,0,0,1}};
        LongestLineOfConsecutiveOneInMatrix test = new LongestLineOfConsecutiveOneInMatrix();
        System.out.print(test.longestLine(a));
    }

}
