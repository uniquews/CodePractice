package main;

/**
 * Created by shuaiwang on 11/20/16.
 *
 *
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 *
 *
 */

// recursion TLE
//public class NumberofWaystoRepresentNCents {
//    int result = 0;
//    public int waysNCents(int n) {
//        // Write your code here
//        int[] input = {25, 10, 5, 1};
//
//        helper(input, 0, n);
//        return result;
//    }
//
//    private void helper(int[] input, int start, int n) {
//        if (n == 0) {
//            result++;
//            return;
//        }
//
//        if (n < 0) {
//            return;
//        }
//
//        for (int i = start; i < input.length; i++) {
//            helper(input, i, n - input[i]);
//        }
//        return;
//    }
//}

    // Backpack
public class NumberofWaystoRepresentNCents {
    public int waysNCents(int n) {
        // Write your code here
        int[] f = new int[n + 1];
        int[] input = {1, 5, 10, 25};

        f[0] = 1;
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= input[i]) {
                    f[j] += f[j - input[i]];
                }
            }
        }
        return f[n];
    }
}

