import java.util.ArrayList;
import java.util.List;

public class Subsets {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> eachResult = new ArrayList<>();
//        helper(result, eachResult, nums, 0);
//        return result;
//    }
//
//    private void helper(List<List<Integer>> result, List<Integer> eachResult, int[] nums, int index) {
//        result.add(new ArrayList<>(eachResult));
//
//        for (int i = index; i < nums.length; i++) {
//            eachResult.add(nums[i]);
//            helper(result, eachResult, nums, i + 1);
//            eachResult.remove(eachResult.size() - 1);
//        }
//    }

//    public List<List<Integer>> subsets(int[] array) {
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(array, 0, res, new ArrayList<>());
//        return res;
//    }
//
//    private void dfs(int[] array, int i, List<List<Integer>> res, List<Integer> tmp) {
//        if (i == array.length) {
//            res.add(new ArrayList<>(tmp));
//        }
//        dfs(array, i + 1, res, tmp);
//        tmp.add(array[i]);
//        dfs(array, i + 1, res, tmp);
//        tmp.remove(tmp.size() - 1);
//    }

    /**
     1,2,3
     {}
     {} {1}
     {} {1} {2} {1,2}
     {} {1} {2} {1,2} {3} {1,3} {2,3} {1,2,3}
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> eachResult = new ArrayList<>();
        result.add(eachResult);

        for (int i : nums) {
            List<List<Integer>> q = new ArrayList<>(result);
            for (List<Integer> l : q) {
                List<Integer> tmp = new ArrayList<>(l);
                tmp.add(i);
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        Subsets test = new Subsets();
        test.subsets(a);
    }
}
