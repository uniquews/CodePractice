import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class SlidingWindowMedian {
//    private int balance = 0;
//
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Long> minHeap = new PriorityQueue<>();
//        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        HashMap<Long, Integer> deleteTable = new HashMap<>(); // key : nums[i], value: nums[i]出现了多少次
//
//        double[] result = new double[nums.length - k + 1];
//        for (int i = 0; i < k; i++) {
//            addElement(minHeap, maxHeap, nums[i]);
//        }
//        getMedian(minHeap, maxHeap, k, result, 0);
//
//        int left = 0, right = k, index = 1;
//        while (right < nums.length) {
//            if (!deleteTable.containsKey(nums[left])) {
//                deleteTable.put((long) nums[left], 1);
//            } else {
//                deleteTable.put((long) nums[left], deleteTable.get(nums[left]) + 1);
//            }
//
//            addElement(minHeap, maxHeap, nums[right]);
//            lazyRemove(minHeap, maxHeap, deleteTable, nums[left]);
//            left++;
//            right++;
//            getMedian(minHeap, maxHeap, k, result, index);
//            index++;
//        }
//        return result;
//    }
//
//    private void getMedian(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, int k, double[] result, int index) {
//        if (k % 2 == 0) {
//            long tmp = minHeap.peek() + maxHeap.peek(); // {Integer.MAX_VALUE,Integer.MAX_VALUE}; window size = 2
//            result[index] = tmp / 2.0;
//        } else {
//            if (balance == 1) {
//                result[index] = minHeap.peek() * 1.0;
//            } else {
//                result[index] = maxHeap.peek() * 1.0;
//            }
//        }
//    }
//
//    private void addElement(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, long number) {
//        if (balance == 1) {
//            if (minHeap.peek() <= number) {
//                long current = minHeap.poll();
//                maxHeap.add(current);
//                minHeap.add(number);
//            } else {
//                maxHeap.add(number);
//            }
//            balance--;
//        } else if (balance == 0) {
//            if (minHeap.isEmpty()) {
//                minHeap.add(number);
//                balance++;
//            } else if (number >= minHeap.peek()) {
//                minHeap.add(number);
//                balance++;
//            } else {
//                maxHeap.add(number);
//                balance--;
//            }
//        } else { // balance == -1
//            if (maxHeap.peek() >= number) {
//                long current = maxHeap.poll();
//                minHeap.add(current);
//                maxHeap.add(number);
//            } else {
//                minHeap.add(number);
//            }
//            balance++;
//        }
//    }
//
//    private void lazyRemove(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, HashMap<Long, Integer> deleteTable, long deleteNum) {
//        if (minHeap.peek() <= deleteNum) {
//            balance--;
//            if (balance == -2) {
//                long current = maxHeap.poll();
//                minHeap.add(current);
//                balance = 0;
//            }
//        } else {
//            balance++;
//            if (balance == 2) {
//                long current = minHeap.poll();
//                maxHeap.add(current);
//                balance = 0;
//            }
//        }
//        updateDeleteTable(minHeap, deleteTable);
//        updateDeleteTable(maxHeap, deleteTable);
//    }
//
//    private void updateDeleteTable(PriorityQueue<Long> heap, HashMap<Long, Integer> deleteTable) {
//        while (deleteTable.containsKey(heap.peek())) {
//            long deleteNum = heap.poll();
//            deleteTable.put(deleteNum, deleteTable.get(deleteNum) - 1);
//            if (deleteTable.get(deleteNum) == 0) {
//                deleteTable.remove(deleteNum);
//            }
//        }
//    }

    class MedianHeap {
        public PriorityQueue<Integer> minHeap;
        public PriorityQueue<Integer> maxHeap;
        public int count;

        public MedianHeap() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            count = 0;
        }

        public void add(int n) {
            if (maxHeap.isEmpty() || maxHeap.peek() < n) {
                /**
                 * [9,7,0,3,9,8,6,5,7,6] 2
                 * */
                minHeap.add(n); // 如果直接往maxHeap里放  假设maxHeap现在为空，来了一个最大数，会被直接放进maxHeap
                count--;
            } else {
                maxHeap.add(n);
                count++;

            }
            rebalance();
        }

        private void rebalance() {
            if (count == 2) {
                minHeap.add(maxHeap.poll());
                count = 0; // 容易错
            } else if (count == -2) {
                maxHeap.add(minHeap.poll());
                count = 0;
            }
        }

        public double getMedian() {
            if (count == 0) {
                return (((long)maxHeap.peek() + (long)minHeap.peek())) / 2.0; // 要用 long
            } else if (count == 1) {
                return maxHeap.peek() * 1.0;
            } else {
                return minHeap.peek() * 1.0;
            }
        }

        public void remove(int n) {
            if (minHeap.peek() <= n) { // 等于
                minHeap.remove(n);
                count++;
            } else {
                maxHeap.remove(n);
                count--;
            }
            rebalance();
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        MedianHeap mh = new MedianHeap();

        for (int i = 0; i < k; i++) {
            mh.add(nums[i]);
        }
        result[0] = mh.getMedian();
        int index = 1;

        for (int i = k; i < nums.length; i++) {
            mh.remove(nums[i - k]);
            mh.add(nums[i]);
            result[index++] = mh.getMedian();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
//        int[] a = {-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
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
