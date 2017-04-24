import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class SlidingWindowMedian {
    private int balance = 0;
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        HashMap<Integer, Integer> deleteTable = new HashMap<>(); // key : nums[i], value: nums[i]出现了多少次

        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addElement(minHeap, maxHeap, nums[i]);
        }
        getMedian(minHeap, maxHeap, k, result, 0);

        int left = 0, right = k, index = 1;
        while (right < nums.length) {
            if (!deleteTable.containsKey(nums[left])) {
                deleteTable.put(nums[left], 1);
            } else {
                deleteTable.put(nums[left], deleteTable.get(nums[left]) + 1);
            }

            lazyRemove(minHeap, maxHeap, deleteTable, nums[left]);
            addElement(minHeap, maxHeap, nums[right]);
            left++;
            right++;
            getMedian(minHeap, maxHeap, k, result, index);
            index++;
        }
        return result;
    }

    private void getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int k, double[] result, int index) {
        if (k % 2 == 0) {
            long tmp = (long)minHeap.peek() + (long)maxHeap.peek(); // {Integer.MAX_VALUE,Integer.MAX_VALUE}; window size = 2
            result[index] = tmp / 2.0;
        } else {
            if (balance == 1) {
                result[index] = minHeap.peek() * 1.0;
            } else {
                result[index] = maxHeap.peek() * 1.0;
            }
        }
    }

    private void addElement(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int number) {
        if (balance == 1) {
            if (minHeap.peek() <= number) {
                int current = minHeap.poll();
                maxHeap.add(current);
                minHeap.add(number);
            } else {
                maxHeap.add(number);
            }
            balance--;
        } else if (balance == 0) {
            if (minHeap.isEmpty()) {
                minHeap.add(number);
                balance++;
            } else if (number >= minHeap.peek()) {
                minHeap.add(number);
                balance++;
            } else {
                maxHeap.add(number);
                balance--;
            }
        } else { // balance == -1
            if (maxHeap.peek() >= number) {
                int current = maxHeap.poll();
                minHeap.add(current);
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }
            balance++;
        }
    }

    private void lazyRemove(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, HashMap<Integer, Integer> deleteTable, int deleteNum) {
        if (minHeap.peek() <= deleteNum) {
            updateDeleteTable(minHeap, deleteTable, deleteNum);
            balance--;
            if (balance == -2) {
                int current = maxHeap.poll();
                minHeap.add(current);
                balance = 0;
            }
        } else {
            if (maxHeap.peek() == deleteNum) {
                maxHeap.poll();
                updateDeleteTable(maxHeap, deleteTable, deleteNum);
            }
            balance++;
            if (balance == 2) {
                int current = minHeap.poll();
                maxHeap.add(current);
                balance = 0;
            }
        }
    }

    private void updateDeleteTable(PriorityQueue<Integer> heap, HashMap<Integer, Integer> deleteTable, int deleteNum) {
        if (heap.peek() == deleteNum && deleteTable.containsKey(deleteNum)) {
            heap.poll();
            deleteTable.put(deleteNum, deleteTable.get(deleteNum) - 1);
            if (deleteTable.get(deleteNum) == 0) {
                deleteTable.remove(deleteNum);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        int k = 3;
//        int[] a = {Integer.MAX_VALUE,Integer.MAX_VALUE};
//        int k = 2;
        SlidingWindowMedian test = new SlidingWindowMedian();
        double[] result = test.medianSlidingWindow(a, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
