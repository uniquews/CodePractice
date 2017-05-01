import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by shuaiwang on 4/30/17.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            if (stk.isEmpty() || nums[stk.peek()] > nums[i]) {
                stk.push(i);
                i++;
            } else {
                int smallIndex = stk.pop();
                map.put(nums[smallIndex], nums[i]);
            }
        }

        int[] result = new int[findNums.length];
        int index = 0;
        for (int n : findNums) {
            if (map.containsKey(n)) {
                result[index++] = map.get(n);
            } else {
                result[index++] = -1;
            }
        }
        return result;
    }
}
