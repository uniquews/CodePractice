import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 2/9/17.
 */
public class TwoSumVIIDifferenceEqualsToTarget {
    // Method 1 HashMap
//    public int[] twoSum7(int[] nums, int target) {
//        // write your code here
//
//        HashMap<Integer, List<Integer>> hs = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (hs.containsKey(nums[i])) {
//                hs.get(nums[i]).add(i);
//            } else {
//                hs.put(nums[i], new ArrayList<>(Arrays.asList(i)));
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int tmp1 = target + nums[i];
//            int tmp2 = nums[i] - target;
//            if (!hs.containsKey(tmp1) && !hs.containsKey(tmp2)) {
//                continue;
//            }
//
//            if (hs.containsKey(tmp1)) {
//                if (tmp1 == nums[i]) {
//                    if (hs.get(tmp1).size() > 1) {
//                        return new int[]{hs.get(tmp1).get(0) + 1, hs.get(tmp1).get(1) + 1};
//                    }
//                } else {
//                        return new int[]{i + 1, hs.get(tmp1).get(0) + 1};
//                }
//            }
//
//            if (hs.containsKey(tmp2)) {
//                if (tmp2 == nums[i]) {
//                    if (hs.get(tmp2).size() > 1) {
//                        return new int[]{hs.get(tmp2).get(0) + 1, hs.get(tmp2).get(1) + 1};
//                    }
//                } else {
//                    return new int[]{i + 1, hs.get(tmp2).get(0) + 1};
//                }
//            }
//        }
//        return new int[]{};
//    }

    // Two pointers
    // Only if this array is sort
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int left = 0, right = 0;
        while (left < nums.length || right < nums.length) {
            int current = nums[left] - nums[right];
            if (current == target) {
                if (left < right) {
                    return new int[]{left + 1, right + 1};
                } else if (left > right) {
                    return new int[]{right + 1, left + 1};
                } else {
                    left++;
                }
            }

            if (current < target) {
                if (left < nums.length) {
                    left++;
                } else {
                    return new int[]{};
                }
            }

            if (current > target) {
                if (right < nums.length) {
                    right++;
                } else {
                    return new int[]{};
                }
            }
        }
        return new int[]{};
    }
}
