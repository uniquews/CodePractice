package main;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 9/12/16.
 */
public class kSumII {
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.length == 0 || k == 0) {
            return result;
        }

        ArrayList<Integer> eachResult = new ArrayList<>();
        helper(A, k, 0, target, eachResult, result);
        return result;
    }

    private void helper(int[] A, int k, int index, int target, ArrayList<Integer> eachResult, ArrayList<ArrayList<Integer>> result) {

        if (target == 0 && k == 0) {
            result.add(new ArrayList<Integer>(eachResult));
            return;
        }

        if (k == 0 || target == 0) {
            return;
        }

        for (int i = index; i < A.length; i++) {
            eachResult.add(A[i]);
            helper(A, k - 1, i + 1, target - A[i], eachResult, result);
            eachResult.remove(eachResult.size() - 1);
        }
        return;
    }
}
