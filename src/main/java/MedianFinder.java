import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 3/15/17.
 */
public class MedianFinder {
    /** initialize your data structure here. */
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }

        if (num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() == minHeap.size() + 2)  {
            minHeap.add(maxHeap.poll());
        }
    }


    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return 1.0 * minHeap.peek();
        } else
            return 1.0 * maxHeap.peek();
    }
}
