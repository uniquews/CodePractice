import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 4/23/17.
 */
public class SlidingWindowMedian {
//    private int balance = 0;
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Long> minHeap = new PriorityQueue<>();
//        PriorityQueue<Long> maxHeap = new PriorityQueue<>((o1, o2) -> {
//            if (o1 < o2) {
//                return 1;
//            } else if (o1 > o2) {
//                return -1;
//            } else {
//                return 0;
//            }
//        });
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
//                deleteTable.put((long)nums[left], 1);
//            } else {
//                deleteTable.put((long)nums[left], deleteTable.get(nums[left]) + 1);
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

    class MedianQueue {
        public int balance = 0;
        public Queue<Long> minHeap = new PriorityQueue<>();
        public Queue<Long> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        });

        public HashMap<Long, Integer> deletedMap = new HashMap<>();

        public void add(long num) {
            if (maxHeap.isEmpty() || maxHeap.peek() < num) { //这里的peek一定是valid的值
                minHeap.add(num);
                balance--;
            } else {
                maxHeap.add(num);
                balance++;
            }
            rebalance();
        }

        public double getMedian() {
            if (balance == 0) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else if (balance == -1) {
                return minHeap.peek() * 1.0;
            } else
                return maxHeap.peek() * 1.0;
        }

        public void remove(long num) {
            int deleteTimes = deletedMap.getOrDefault(num, 0) + 1;
            deletedMap.put(num, deleteTimes);

            if (minHeap.peek() <= num) { // minheap peek可能是当前被删除的Num，所以这里的minHeap 有可能是要当前被删除的值或者其他valid的值，但不可能是之前被删除的值留在堆顶
                balance++;
                updateDeleteMap(minHeap); // 如果maxheap的peek和minHeap的 peek是同一个num 如果不updateDeleteMapTable 之后updateDeleteMap(maxHeap) 会重复delete num {7,8,8,3} k = 3
            } else {
                balance--;
                updateDeleteMap(maxHeap);
            }
            rebalance();
        }

        public void rebalance() {
            if (balance == -2) {
                updateDeleteMap(minHeap);
                maxHeap.add(minHeap.poll());
                balance = 0;
                updateDeleteMap(minHeap); // minHeap中poll出一个valid值扔到maxHeap之后，下一个在堆顶的值可能是invalid的值
            }

            if (balance == 2) {
                updateDeleteMap(maxHeap);
                minHeap.add(maxHeap.poll());
                balance = 0;
                updateDeleteMap(maxHeap);
            }
        }

        public void updateDeleteMap(Queue<Long> heap) {
            while (deletedMap.containsKey(heap.peek())) {
                Long cur = heap.poll();
                deletedMap.put(cur, deletedMap.get(cur) - 1);
                if (deletedMap.get(cur) == 0)
                    deletedMap.remove(cur);
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        MedianQueue mh = new MedianQueue();

        for (int i = 0; i < k; i++) {
            mh.add(nums[i]);
        }
        int index = 0;
        result[index++] = mh.getMedian();

        int right = k, left = 0;
        while (right < nums.length) {
            mh.remove((long)nums[left++]);
            mh.add((long)nums[right++]);
            result[index++] = mh.getMedian();
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
//        int[] a = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
//        int k = 2;

        int[] a = {7,8,8,3,8,1,5,3,5,4};
        int k = 3;

//        int[] a = {Integer.MAX_VALUE,Integer.MAX_VALUE};
//        int k = 2;
        SlidingWindowMedian test = new SlidingWindowMedian();
        double[] result = test.medianSlidingWindow(a, k);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + ", ");
//        }
    }
}
