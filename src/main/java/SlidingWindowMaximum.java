import java.util.*;

/**
 * Created by shuaiwang on 12/11/16.
 *
 *
 * Input = {8,1,6,4,5,10,5,4}
 *
 * Idea: Keep a descending order deque, remain the correct window size by using two pointers
 */

public class SlidingWindowMaximum {
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<Integer>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            // This is for remain the correct sliding window size
            if (i - start == k) {
                if (nums[start] == deque.peekFirst())
                    deque.removeFirst();
                start++;
            }

            // keep numbers in deque as descending order
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }

            deque.add(nums[i]); // keeping adding number every iteration
            if (i >= k - 1) {
                result.add(deque.peekFirst());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] input = {1,2,7,7,2};
        int k = 1;
        System.out.print(test.maxSlidingWindow(input, k));
    }
}
