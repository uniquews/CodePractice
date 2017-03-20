import java.util.*;

/**
 * Created by shuaiwang on 12/11/16.
 * <p>
 * <p>
 * Input = {8,1,6,4,5,10,5,4}
 * <p>
 * Idea: Keep a descending order deque, remain the correct window size by using two pointers
 */

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] list = new int[nums.length - k + 1];

        int start = 0, end = 0;
        while (end < k) {
            int current = nums[end];
            while (!deque.isEmpty() && deque.peekLast() < current) {
                deque.removeLast();
            }
            deque.addLast(current);
            end++;
        }

        int index = 0;
        while (end < nums.length) {
            list[index] = deque.peekFirst();
            if (nums[start] == deque.peekFirst()) {
                deque.removeFirst();
            }
            start++;

            while (!deque.isEmpty() && deque.peekLast() < nums[end]) {
                deque.removeLast();
            }
            deque.add(nums[end]);
            end++;
            index++;
        }
        list[index] = deque.peekFirst();
        return list;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] input = {7,2,4};
        int k = 2;
        System.out.print(test.maxSlidingWindow(input, k));
    }
}
