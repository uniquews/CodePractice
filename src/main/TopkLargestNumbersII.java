package main;

import java.util.*;

/**
 * Created by shuaiwang on 10/26/16.
 */
public class TopkLargestNumbersII {
    private Queue<Integer> heap;
    private int size = 0;
    public TopkLargestNumbersII(int k) {
        // initialize your data structure here.
        size = k;
        heap = new PriorityQueue<>();
    }

    public void add(int num) {
        // Write your code here
        if (heap.size() < size) {
            heap.add(num);
        } else if (heap.peek() < num) {
            heap.poll();
            heap.add(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Iterator it = heap.iterator();
        while (it.hasNext()) {
            result.add((Integer)it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        TopkLargestNumbersII test = new TopkLargestNumbersII(3);
        test.add(3);
        test.add(10);
    }
}
