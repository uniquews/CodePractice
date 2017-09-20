import java.util.*;

public class _24Game {
    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        List<List<Integer>> input = permutation(nums);

        for (List<Integer> list : input) {
            Set<Double> res = divideAndConquer(list, 0, list.size() - 1);
            for (Double num : res) {
                if (Math.abs(num - 24.0) <= 0.001) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Double> divideAndConquer(List<Integer> l, int start, int end) {
        if (start == end) {
            return new HashSet<>(Arrays.asList(l.get(start) * 1.0));
        }

        Set<Double> result = new HashSet<>();
        for (int mid = start; mid < end; mid++) {
            Set<Double> left = divideAndConquer(l, start, mid);
            Set<Double> right = divideAndConquer(l, mid + 1, end);
            for (double i : left) {
                for (double j : right) {
                    result.add(i * j);
                    result.add(i / j);
                    result.add(i + j);
                    result.add(i - j);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> eachResult = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, result, eachResult, visited);
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> eachResult,
                     boolean[] visited) {

        if (index == nums.length) {
            result.add(new ArrayList<>(eachResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            eachResult.add(nums[i]);
            dfs(nums, index + 1, result, eachResult, visited);
            eachResult.remove(eachResult.size() - 1);
            visited[i] = false;

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
//        _24Game test = new _24Game();
//        int[] a = {4,1,8,7};
//
//        System.out.println(test.judgePoint24(a));
    }
}
