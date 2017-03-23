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

    //随着窗口向右滑动，保持deque是一个单调递减序列，每次的max in window就总是deque里的第一个值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] list = new int[nums.length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            Enqueue(deque, nums[i]);
        }

        int index = 0;
        for (int i = k - 1; i < nums.length; i++) {
            Enqueue(deque, nums[i]); // 把end移到当前被计算的window的末尾
            list[index] = deque.peekFirst();
            Dequeue(deque, nums[i - k + 1]); //把start移道下一个被计算window开始
            index++;
        }
        return list;
    }

    // delete number from beginning of the deque
    private void Dequeue(Deque<Integer> deque, int candidate) {
        if (candidate == deque.peekFirst()) {
            deque.removeFirst();
        }
    }

    // add number from end of the deque
    private void Enqueue(Deque<Integer> deque, int candidate) {
        while (!deque.isEmpty() && deque.peekLast() < candidate) {
            deque.removeLast();
        }
        deque.addLast(candidate);
    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] input = {7,2,4};
        int k = 2;
        System.out.print(test.maxSlidingWindow(input, k));
    }
}
