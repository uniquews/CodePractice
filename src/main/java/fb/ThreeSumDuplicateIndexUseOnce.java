package fb;

import java.util.*;


/**
 *
 * 要是问index并且允许重复使用，要在call two sum的时候传i  在two sum里要先放number 在判断target - nums[i]
 *  也不需要 i < nums.lewngth - 2
 * */
public class ThreeSumDuplicateIndexUseOnce {
    // 如果有重复值，要求输出所有值一样但是index不一样
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            List<List<Integer>> fromTwoSum = twoSum(nums, i + 1, target - first);

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
            if (map.containsKey(target - nums[i])) {
                List<Integer> allIndex = map.get(target - nums[i]);
                for (Integer idx : allIndex) {
                    result.add(new ArrayList<>(Arrays.asList(idx, i)));
                }
            }

            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a = {1,1,1,1};
        int target = 3;
        ThreeSumDuplicateIndexUseOnce test = new ThreeSumDuplicateIndexUseOnce();
        List<List<Integer>> result = test.threeSum(a, target);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}
