import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 9/12/16.
 */
public class kSumII {
//    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
//        // write your code here
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if (A == null || A.length == 0 || k == 0) {
//            return result;
//        }
//
//        ArrayList<Integer> eachResult = new ArrayList<>();
//        helper(A, k, 0, target, eachResult, result);
//        return result;
//    }
//
//    private void helper(int[] A, int k, int index, int target, ArrayList<Integer> eachResult, ArrayList<ArrayList<Integer>> result) {
//
//        if (target == 0 && k == 0) {
//            result.add(new ArrayList<Integer>(eachResult));
//            return;
//        }
//
//        if (k == 0 || target == 0) {
//            return;
//        }
//
//        for (int i = index; i < A.length; i++) {
//            eachResult.add(A[i]);
//            helper(A, k - 1, i + 1, target - A[i], eachResult, result);
//            eachResult.remove(eachResult.size() - 1);
//        }
//        return;
//    }


    // 记忆化搜索的dfs
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        Map<String, List<List<Integer>>> map = new HashMap<>();

        return dfs(A, k, 0, target, map);
    }

    private List<List<Integer>> dfs(int[] A, int k, int index, int target, Map<String, List<List<Integer>>> map) {
        List<List<Integer>> result = new ArrayList<>();

        String key = k + "#" + index + "#" + target;
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>());
            map.getOrDefault(key, new ArrayList<>());
            return result;
        }

        if (k == 0 || target == 0 || index == A.length) {
            map.put(key, null);
            return null;
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = index; i < A.length; i++) {
            List<List<Integer>> next = dfs(A, k - 1, i + 1, target - A[i], map);
            if (next != null) {
                for (List<Integer> l : next) {
                    List<Integer> newL = new ArrayList<>(l);
                    newL.add(0, A[i]);
                    result.add(newL);
                }
            }
        }
        map.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        kSumII test = new kSumII();
        test.kSumII(a, 2, 3);
    }
}
