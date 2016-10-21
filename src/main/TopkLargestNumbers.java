package main;

import java.util.*;

/**
 * Created by shuaiwang on 10/19/16.
 */
public class TopkLargestNumbers {
    public int[] topk(int[] nums, int k) {
        // Write your code here
        Queue<Integer> minheap = new PriorityQueue<>();

        int cur = 0;
        while (cur != nums.length) {
            if (minheap.size() < k) {
                minheap.add(nums[cur]);
            } else {
                if (nums[cur] > minheap.peek()) {
                    minheap.poll();
                    minheap.add(nums[cur]);
                }
            }
            cur++;
        }

        cur = 0;
        int[] result = new int[k];
        Iterator it = minheap.iterator();
        while (it.hasNext()) {
            result[cur++] = (int)it.next();
        }
        Comparator<Integer> comp = Collections.reverseOrder();

        Arrays.sort(result);
        int start = 0;
        int end = result.length - 1;
        while (start <= end) {
            int tmp = result[start];
            result[start] = result[end];
            result[end] = tmp;
            start++;
            end--;
        }
        return result;
    }
}
