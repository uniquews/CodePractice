package b;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by bohan on 4/30/17.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> nextGreaterElementMap = getNextGreaterElementMap(nums);
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            res[i] = nextGreaterElementMap.getOrDefault(findNums[i], -1);
        }
        return res;
    }

    private Map<Integer, Integer> getNextGreaterElementMap(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>(nums.length);
        int i = 0;
        while (i < nums.length) {
            if (stack.isEmpty() || stack.peek() > nums[i]) {
                stack.push(nums[i]);
                i++;
            } else {
                result.put(stack.pop(), nums[i]);
            }
        }
        return result;
    }
}
