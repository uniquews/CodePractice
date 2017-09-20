import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 10/14/16.
 */
//public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            int n1 = nums[i];
//            twoSum(nums, i + 1, 0 - n1, result);
//            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
//                i++;
//            }
//        }
//        return result;
//    }
//
//    private void twoSum(int[] nums, int index, int target, List<List<Integer>> result) {
//        int i = index, j = nums.length - 1;
//        while (i < j) {
//            if (nums[i] + nums[j] == target) {
//                List<Integer> current = Arrays.asList(0 - target, nums[i], nums[j]);
//                result.add(current);
//                while (i + 1 < j && nums[i] == nums[i + 1]) {
//                    i++;
//                }
//
//                while (j - 1 > i && nums[j] == nums[j - 1]) {
//                    j--;
//                }
//                i++;
//                j--;
//            } else if (nums[i] + nums[j] < target) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//    }
//}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            List<List<Integer>> fromTwoSum = twoSum(nums, i + 1, 0 - first);

            for (int j = 0; j < fromTwoSum.size(); j++) {
                List<Integer> eachResult = fromTwoSum.get(j);
                eachResult.add(nums[i]);
                result.add(eachResult);
            }

            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[start], nums[end])));

                while (start + 1 < end && nums[start] == nums[start + 1]) {
                    start++;
                }

                while (end - 1 > start && nums[end] == nums[end - 1]) {
                    end--;
                }
                start++;
                end--;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] a = {-1,0,1,2,-1,-4};
        Solution s = new Solution();
        s.threeSum(a);
    }

}