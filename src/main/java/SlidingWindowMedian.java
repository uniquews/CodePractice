import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class SlidingWindowMedian {
    private int balance = 0;
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        });
        HashMap<Long, Integer> deleteTable = new HashMap<>(); // key : nums[i], value: nums[i]出现了多少次

        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addElement(minHeap, maxHeap, nums[i]);
        }
        getMedian(minHeap, maxHeap, k, result, 0);

        int left = 0, right = k, index = 1;
        while (right < nums.length) {
            if (!deleteTable.containsKey(nums[left])) {
                deleteTable.put((long)nums[left], 1);
            } else {
                deleteTable.put((long)nums[left], deleteTable.get(nums[left]) + 1);
            }

            addElement(minHeap, maxHeap, nums[right]);
            lazyRemove(minHeap, maxHeap, deleteTable, nums[left]);
            left++;
            right++;
            getMedian(minHeap, maxHeap, k, result, index);
            index++;
        }
        return result;
    }

    private void getMedian(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, int k, double[] result, int index) {
        if (k % 2 == 0) {
            long tmp = minHeap.peek() + maxHeap.peek(); // {Integer.MAX_VALUE,Integer.MAX_VALUE}; window size = 2
            result[index] = tmp / 2.0;
        } else {
            if (balance == 1) {
                result[index] = minHeap.peek() * 1.0;
            } else {
                result[index] = maxHeap.peek() * 1.0;
            }
        }
    }

    private void addElement(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, long number) {
        if (balance == 1) {
            if (minHeap.peek() <= number) {
                long current = minHeap.poll();
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
                long current = maxHeap.poll();
                minHeap.add(current);
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }
            balance++;
        }
    }

    private void lazyRemove(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, HashMap<Long, Integer> deleteTable, long deleteNum) {
        if (minHeap.peek() <= deleteNum) {
            balance--;
            if (balance == -2) {
                long current = maxHeap.poll();
                minHeap.add(current);
                balance = 0;
            }
        } else {
            balance++;
            if (balance == 2) {
                long current = minHeap.poll();
                maxHeap.add(current);
                balance = 0;
            }
        }
        updateDeleteTable(minHeap, deleteTable);
        updateDeleteTable(maxHeap, deleteTable);
    }

    private void updateDeleteTable(PriorityQueue<Long> heap, HashMap<Long, Integer> deleteTable) {
        while (deleteTable.containsKey(heap.peek())) {
            long deleteNum = heap.poll();
            deleteTable.put(deleteNum, deleteTable.get(deleteNum) - 1);
            if (deleteTable.get(deleteNum) == 0) {
                deleteTable.remove(deleteNum);
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
        int[] a = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 2;

//        int[] a = {Integer.MAX_VALUE,Integer.MAX_VALUE};
//        int k = 2;
        SlidingWindowMedian test = new SlidingWindowMedian();
        double[] result = test.medianSlidingWindow(a, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
