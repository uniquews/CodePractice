package G;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestAbsoluteDifferenceOfTwoElementsInAnArray {
    class Node {
        int left;
        int right;
        int val;
        Node(int left, int right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    public Node kthSmallestAbsoluteDifferenceOfTwoElementsInAnArray(int[] nums, int k) {
        Arrays.sort(nums);

        Queue<Node> heap = new PriorityQueue<>((a, b) ->  a.val - b.val);

        for (int i = 0; i < nums.length - 1; i++) {
            Node cur = new Node(i, i + 1, nums[i + 1] - nums[i]);
            heap.offer(cur);
        }

        Node result = null;
        while (k > 0) {
            result = heap.poll();

            if (result.right + 1 < nums.length) {
                heap.offer(new Node(result.left, result.right + 1, nums[result.right + 1] - nums[result.left]));
            }
            k--;
        }
        return result;
    }
}
