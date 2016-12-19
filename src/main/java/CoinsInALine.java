/**
 * Created by shuaiwang on 12/18/16.
 */
public class CoinsInALine {

    // Method 1.
//    public boolean firstWillWin(int n) {
//        // write your code here
//        boolean[] dp = new boolean[n + 1];
//        boolean[] flag = new boolean[n + 1];
//        return search(n, dp, flag);
//    }
//
//    public boolean search(int n, boolean[] dp,  boolean[] flag) {
//        if (n == 0 || n == 3) {
//            return false;
//        }
//
//        if (n == 1 || n == 2) {
//            return true;
//        }
//
//        if (flag[n])
//            return dp[n];
//        dp[n] = (search(n - 2, dp, flag) && search(n - 3, dp, flag)) || (search(n - 3, dp, flag) && search(n - 4, dp, flag));
//        flag[n] = true;
//        return dp[n];
//    }


    //Method 2
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        boolean[] f = new boolean[n + 1];
        f[0] = false;
        f[1] = true;
        f[2] = true;

        for (int i = 3; i <= n; i++) {
            f[i] = !f[i - 1] || !f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        CoinsInALine test = new CoinsInALine();
        System.out.print(test.firstWillWin(9));
    }

}
