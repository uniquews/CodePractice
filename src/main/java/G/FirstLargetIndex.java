package G;

import java.util.Stack;

public class FirstLargetIndex {
    public int[] firstLargeIndex(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 0; i <= nums.length; i++) {
            int cur = i == nums.length ? Integer.MAX_VALUE : nums[i];

            while (!stk.isEmpty() && nums[stk.peek()] < cur) {
                int small = stk.pop();
                if (i == nums.length) {
                    result[small] = -1;
                } else {
                    result[small] = i;
                }
            }
            stk.push(i);
        }

        return result;

    }
}
