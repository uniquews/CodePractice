package main;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 9/8/16.
 */
public class MinimumAdjustmentCost {
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

        // 首个数字可以取1-100
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            min = Math.min(min, rec3(A, target, 0, i, M));
        }

        return min;
    }

    private int rec3(ArrayList<Integer> A, int target, int index, int x,
                     int[][] M) {
        int len = A.size();
        if (index >= len) {
            // The index is out of range.
            return 0;
        }

        if (M[index][x - 1] != Integer.MAX_VALUE) {
            return M[index][x - 1];
        }

        int bas = Math.abs(x - A.get(index));
        int min = Integer.MAX_VALUE;

        // 对下一个值尝试取1-100
        for (int i = 1; i <= 100; i++) {
            // 下一个值的取值不可以超过abs
            if (index != len - 1 && Math.abs(i - x) > target) {
                continue;
            }

            // 计算dif
            int dif = bas + rec3(A, target, index + 1, i, M);
            min = Math.min(min, dif);
        }

        // Record the result.
        M[index][x - 1] = min;
        return min;
    }

}
