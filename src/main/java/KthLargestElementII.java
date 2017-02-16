import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 2/15/17.
 */
public class KthLargestElementII {
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else {
                if (heap.peek() < nums[i]) {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
        }
        return heap.peek();
    }
}
