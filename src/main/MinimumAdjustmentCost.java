package main;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 9/8/16.
 */
public class MinimumAdjustmentCost {

     /*
        version 1: memory search
        M[index][value] means the if we assign value to index th number,
        the min conversion starting from the index th number to the end

        Noted the memory search way could reduce the duplicate search
        like M[2][0] will be used firstly by M[1][0] and be used by
        M[1][1]. We can store the value of M[2][0] when we get it first
        time. So next time when we calculate M[1][0], we can directly look
        up value of M[2][0]

        The minimum value will happen at any search path. Thus we need to compare
        from M[0][0] to M[0][99] to see which one is smallest.
      */


    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }

        int[][] M = new int[A.size()][100];

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < 100; j++) {
                M[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i ++) {
            result = Math.min(result, helper(A, target, 0, i, M));
        }
        return result;

    }

    private int helper(ArrayList<Integer> A, int target, int index, int value, int[][] M) {
        if (index == A.size()) {
            return 0;
        }

        if (M[index][value - 1] != Integer.MAX_VALUE) {
            return M[index][value - 1];
        }

        int diff = Math.abs(value - A.get(index));

        for (int i = 1; i <= 100; i++) {
            if (Math.abs(i - value) > target) {
                continue;
            }

            int tmp = helper(A, target, index + 1, i, M);
            M[index][value - 1] = Math.min(M[index][value - 1], diff + tmp);
        }

        return M[index][value - 1];

    }



}
