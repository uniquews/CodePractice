/**
 * Created by shuaiwang on 11/15/16.
 */
public class ClimbingStairsII {
    public int climbStairs2(int n) {
        // Write your code here
        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;

        for (int i = 4; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        return f[n];
    }

    public static void main(String[] args) {
        ClimbingStairsII test = new ClimbingStairsII();
        test.climbStairs2(5);
    }
}
