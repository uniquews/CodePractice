import java.util.Arrays;

public class FindKthSmallestPairDistance {
//    public int smallestDistancePair(int[] nums, int k) {
//        Arrays.sort(nums);
//        int WIDTH = 2 * nums[nums.length - 1]; // size is from prefix[nums[i] + mid], mid can't exceed nums[nums.length - 1]
//
//        //multiplicity[i] = number of nums[j] == nums[i] (j < i)
//        int[] multiplicity = new int[nums.length];
//        for (int i = 1; i < nums.length; ++i) {
//            if (nums[i] == nums[i-1]) {
//                multiplicity[i] = 1 + multiplicity[i - 1];
//            }
//        }
//
//        //prefix[v] = number of values <= v
//        int[] prefix = new int[WIDTH];
//        int left = 0;
//        for (int i = 0; i < WIDTH; ++i) {
//            while (left < nums.length && nums[left] == i) {
//                left++;
//            }
//            prefix[i] = left;
//        }
//
//        int start = 0;
//        int end = nums[nums.length - 1] - nums[0];
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            int count = helper(prefix, multiplicity, nums, mid);
//            if (count >= k) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//        if (helper(prefix, multiplicity, nums, start) >= k) {
//            return start;
//        }
//
//        return end;
//    }
//
//    private int helper(int[] prefix, int[] multiplicity, int[] nums, int mid) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            count += prefix[nums[i] + mid] - prefix[nums[i]] + multiplicity[i];
//        }
//        return count;
//    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length - 1] - nums[0];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = helper(nums, mid);
            if (count >= k) {
                end = mid; // end 不一定存在
            } else {
                start = mid;
            }
        }

        // end 如果不存在  start 一定存在
        if (helper(nums, start) >= k) {
            return start;
        }
        return end;
    }

    private int helper(int[] nums, int dist) {
        int right = 0;
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] - nums[left] <= dist) {
                count += right - left;
                right++;
            }
            if (right < nums.length && nums[right] - nums[left] <= dist) {
                count += right - left;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] a = {1,1,2,3};
//        int k = 3;
//        int[] a = {1,6,1};
//        int k = 3;
        int[] a = {1,3,1};
        int k = 1;
        FindKthSmallestPairDistance test = new FindKthSmallestPairDistance();
        System.out.print(test.smallestDistancePair(a, k));
    }
}
