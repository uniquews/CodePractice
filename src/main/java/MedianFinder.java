import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 3/15/17.
 */
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> smallNumberHeap;
    PriorityQueue<Integer> largeNumberHeap;

    public MedianFinder() {
        smallNumberHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        largeNumberHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smallNumberHeap.size() == 0) {
            smallNumberHeap.add(num);
        } else if (num < smallNumberHeap.peek()) {
            smallNumberHeap.add(num);
            if (smallNumberHeap.size() == largeNumberHeap.size() + 2) {
                largeNumberHeap.add(smallNumberHeap.poll());
            }
        } else if (!largeNumberHeap.isEmpty() && num > largeNumberHeap.peek()) {
            largeNumberHeap.add(num);
            if (largeNumberHeap.size() == smallNumberHeap.size() + 2) {
                smallNumberHeap.add(largeNumberHeap.poll());
            }
        } else {
            smallNumberHeap.add(num);
            if (smallNumberHeap.size() == largeNumberHeap.size() + 2) {
                largeNumberHeap.add(smallNumberHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (largeNumberHeap.size() == 0) {
            return smallNumberHeap.peek() * 1.0;
        }
        if (smallNumberHeap.size() == largeNumberHeap.size()) {
            return 1.0 * (smallNumberHeap.peek() + largeNumberHeap.peek()) / 2;
        } else {
            return smallNumberHeap.size() > largeNumberHeap.size() ? 1.0 * smallNumberHeap.peek() : 1.0 * largeNumberHeap.peek();
        }
    }
}
