package b;

/**
 * Created by bohan on 7/15/17.
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianHeap heap = new MedianHeap();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        double[] result = new double[nums.length - k + 1];
        result[0] = heap.getMedian();
        for (int i = k; i < nums.length; i++) {
            heap.remove(nums[i - k]);
            heap.add(nums[i]);
            result[i - k + 1] = heap.getMedian();
        }
        return result;
    }
}
