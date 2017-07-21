package b;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by bohan on 7/15/17.
 */
public class MedianHeap {
    private final LazyRemoveHeap minHeap;
    private final LazyRemoveHeap maxHeap;
    private int balance;

    public MedianHeap() {
        minHeap = new LazyRemoveHeap(Comparator.naturalOrder());
        maxHeap = new LazyRemoveHeap(Comparator.reverseOrder());
        balance = 0;
    }

    public double getMedian() {
        if (balance == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (balance == -1) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    public void remove(long n) {
        if (n >= minHeap.peek()) {
            minHeap.delete(n);
            balance++;
        } else {
            maxHeap.delete(n);
            balance--;
        }
        rebalance();
    }

    public void add(long n) {
        if (maxHeap.isEmpty() || n >= maxHeap.peek()) {
            minHeap.add(n);
            balance--;
        } else {
            maxHeap.add(n);
            balance++;
        }
        rebalance();
    }

    private void rebalance() {
        if (balance == -2) {
            maxHeap.add(minHeap.poll());
            balance = 0;
        } else if (balance == 2) {
            minHeap.add(maxHeap.poll());
            balance = 0;
        }
    }

    private class LazyRemoveHeap {
        private final PriorityQueue<Long> heap;
        private final Map<Long, Integer> deleteMap;

        private LazyRemoveHeap(Comparator<Long> comparator) {
            heap = new PriorityQueue<>(comparator);
            deleteMap = new HashMap<>();
        }

        private void add(Long n) {
            heap.offer(n);
        }

        private void delete(Long n) {
            int count = deleteMap.getOrDefault(n, 0) + 1;
            deleteMap.put(n, count);
        }

        private long peek() {
            lazyRemove();
            return heap.peek();
        }

        private long poll() {
            lazyRemove();
            long n = heap.poll();
            return n;
        }

        private void lazyRemove() {
            while (deleteMap.containsKey(heap.peek())) {
                int count = deleteMap.get(heap.peek()) - 1;
                if (count == 0) {
                    deleteMap.remove(heap.peek());
                } else {
                    deleteMap.put(heap.peek(), count);
                }
                heap.poll();
            }
        }

        private boolean isEmpty() {
            lazyRemove();
            return heap.isEmpty();
        }
    }
}
