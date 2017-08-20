import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by shuaiwang on 4/30/17.
 */
public class NextGreaterElementI {
//    public int[] nextGreaterElement(int[] findNums, int[] nums) {
//        Stack<Integer> stk = new Stack<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        int i = 0;
//        while (i < nums.length) {
//            if (stk.isEmpty() || nums[stk.peek()] > nums[i]) {
//                stk.push(i);
//                i++;
//            } else {
//                int smallIndex = stk.pop();
//                map.put(nums[smallIndex], nums[i]);
//            }
//        }
//
//        int[] result = new int[findNums.length];
//        int index = 0;
//        for (int n : findNums) {
//            if (map.containsKey(n)) {
//                result[index++] = map.get(n);
//            } else {
//                result[index++] = -1;
//            }
//        }
//        return result;
//    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            if (i < nums.length) {
                if (stk.isEmpty() || nums[stk.peek()] > nums[i]) {
                    stk.push(i);
                } else {
                    while (nums[stk.peek()] < nums[i]) {
                        int index = stk.pop();
                        result[index] = nums[i];
                    }
                    stk.push(i);
                }
            } else {
                while (nums[stk.peek()] < nums[i % nums.length]) {
                    result[stk.pop()] = nums[i % nums.length];
                }
            }
        }
        return result;
    }
}
