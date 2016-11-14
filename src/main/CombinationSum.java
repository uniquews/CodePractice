package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 11/14/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> eachResult = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, eachResult, result, target, 0);
        return result;
    }

    private void dfs(int[] candidates, List<Integer> eachResult, List<List<Integer>> result, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(eachResult));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            eachResult.add(candidates[i]);
            dfs(candidates, eachResult, result, target - candidates[i], i);
            eachResult.remove(eachResult.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
        return;
    }
    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] a = {1,2};
        test.combinationSum(a, 2);
    }
}
