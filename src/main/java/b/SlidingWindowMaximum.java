package b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by bohan on 7/16/17.
 */
public class SlidingWindowMaximum {
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            addToDeque(nums, i, deque);
        }
        result.add(nums[deque.peekFirst()]);
        for (int i = k; i < nums.length; i++) {
            if (i - k == deque.peekFirst()) {
                deque.pollFirst();
            }
            addToDeque(nums, i, deque);
            result.add(nums[deque.peekFirst()]);
        }
        return result;
    }

    private void addToDeque(int[] nums, int i, Deque<Integer> deque) {
        int h = nums[i];
        while (!deque.isEmpty() && nums[deque.peekLast()] <= h) {
            deque.pollLast();
        }
        deque.offerLast(i);
    }
}
