import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 2/7/17.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<Integer> eachResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        dfs(num, target, 0, result, eachResult);
        return result;
    }

    void dfs(int[] num, int target, int index, List<List<Integer>> result, List<Integer> eachResult) {
        if (target == 0) {
            result.add(new ArrayList<>(eachResult));
            return;
        }

        if (index == num.length || target < 0) {
            return;
        }

        for (int i = index; i < num.length; i++) {
            eachResult.add(num[i]);
            dfs(num, target - num[i], i + 1, result, eachResult);
            eachResult.remove(eachResult.size() - 1);

            while (i + 1 < num.length && num[i] == num[i + 1]) {
                i++;
            }
        }
    }


    public static void main(String[] args) {
        int[] num = {7,1,2,5,1,6,10};
        int target = 8;
        CombinationSumII test = new CombinationSumII();
        test.combinationSum2(num, target);
    }
}
