package fb;

import java.util.*;

public class ThreeSumDuplicateIndexReuse {
    // 如果有重复值，要求输出所有值一样但是index不一样, 一个数字可以用多次
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            List<List<Integer>> fromTwoSum = twoSum(nums, i, target - first);

            for (int j = 0; j < fromTwoSum.size(); j++) {
                List<Integer> eachResult = fromTwoSum.get(j);
                eachResult.add(0, i);
                result.add(eachResult);
            }

        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int end = nums.length - 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);

            if (map.containsKey(target - nums[i])) {
                List<Integer> allIndex = map.get(target - nums[i]);
                for (Integer idx : allIndex) {
                    result.add(new ArrayList<>(Arrays.asList(idx, i)));
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = {-1, 0, 1, 2, -1, -4};
//        int[] a = {1,1,1,1};
        int[] a = {1,1};
        int target = 3;
        ThreeSumDuplicateIndexReuse test = new ThreeSumDuplicateIndexReuse();
        List<List<Integer>> result = test.threeSum(a, target);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}
