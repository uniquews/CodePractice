import java.util.Arrays;

/**
 * Created by shuaiwang on 2/21/17.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        // write your code here
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k * k <= i; k++) {
                int j = i - k * k;
                if (f[j] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        PerfectSquares test = new PerfectSquares();
        System.out.print(test.numSquares(12));
    }
}
