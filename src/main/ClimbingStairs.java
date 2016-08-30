package main;

/**
 * Created by shuaiwang on 8/25/16.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // write your code here
        if (n == 0)
        {
            return 1;

        }

        if (n == 1)
        {
            return 1;
        }

        int []f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i ++)
        {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }
}
