package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumDuplicateReused {
    public List<List<Integer>> threeSumDuplicateReused(int[] nums, int m) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = m - nums[i];
            List<List<Integer>> resultFromTwoSum = helper(nums, i, target);
            for (List<Integer> l : resultFromTwoSum) {
                l.add(0, nums[i]);
                result.add(l);
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> helper(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;

        List<List<Integer>> result = new ArrayList<>();
        while (left <= right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                List<Integer> eachResult = new LinkedList<>();
                eachResult.add(nums[left]);
                eachResult.add(nums[right]);
                result.add(eachResult);

                while (left + 1 <= right && nums[left] == nums[left + 1]) {
                    left++;
                }

                while (left <= right - 1 && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ThreeSumDuplicateReused test = new ThreeSumDuplicateReused();
        int[] a = {1,1,2,3};
        int target = 4;
        List<List<Integer>> result = test.threeSumDuplicateReused(a, target);
        return;
    }
}
