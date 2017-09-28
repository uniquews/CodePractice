import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 6/5/17.
 */
public class MaximumSubarrayV {
    // 会TLE
//    public int maxSubarray5(int[] nums, int k1, int k2) {
//        // write your code here
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int[] sum = new int[nums.length + 1];
//        int result = Integer.MIN_VALUE;
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//            for (int j = i - k1; j >= 0 && j >= i - k2; j--) {
//                result = Math.max(result, sum[i] - sum[j]);
//            }
//        }
//        return result;
//    }

    // 维护一个sliding window中的minSum   维护一个递减序列
    public int maxSubarray5(int[] nums, int k1, int k2) {
        // Write your code here
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }


        int result = Integer.MIN_VALUE;

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 1; i <= nums.length; i++) {
            if (i - k1 >= 0) {
                result = Math.max(result, sum[i] - list.peek());
                while (!list.isEmpty() && list.peekLast() > sum[i - k1 + 1]) {
                    list.pollLast();
                }
                list.add(sum[i - k1 + 1]);
            }

            if (i - k2 >= 0 && list.peekFirst() == sum[i - k2]) {
                list.removeFirst();
            }
        }
        return result;
    }
}
