package b;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by bohan on 4/30/17.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // This stack is storing the index for each element.
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int i = 0;
        while (i < 2 * nums.length) {
            int index = i % nums.length;
            if (stack.isEmpty() || nums[stack.peek()] >= nums[index]) {
                stack.push(index);
                i++;
            } else {
                res[stack.pop()] = nums[index];
            }
        }
        return res;
    }
}
