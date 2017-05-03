/**
 * Created by shuaiwang on 5/2/17.
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        /***
         * f[i][j][k] = Math.max(f[i - 1][j][k], f[i - 1][j - p][k - q] + 1), p, q 分别是
         * strs[i]中0， 1的数量
         *
        */
        int[][][] f = new int[strs.length][m + 1][n + 1];
        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                if (getNumOfOnesOrZeros(strs[0], true) <= k &&
                    getNumOfOnesOrZeros(strs[0], false) <= j) {
                    f[0][j][k] = 1;
                }
            }
        }

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    f[i][j][k] = f[i - 1][j][k];

                    int numOfOne = getNumOfOnesOrZeros(strs[i], true);
                    int numOfZero = getNumOfOnesOrZeros(strs[i], false);
                    if (numOfZero <= j && numOfOne <= k) {
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - numOfOne][k - numOfZero] + 1);
                    }
                }
            }
        }

        return f[strs.length - 1][m][n];
    }

    private int getNumOfOnesOrZeros(String s, boolean isOne) {
        int result = 0;
        for (char c : s.toCharArray()) {
            if (isOne) {
                result = c == '1' ? result + 1 : result;
            } else {
                result = c == '0' ? result + 1 : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] a = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        OnesAndZeroes test = new OnesAndZeroes();
        test.findMaxForm(a, m, n);

    }
}
