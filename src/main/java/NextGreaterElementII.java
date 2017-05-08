import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by shuaiwang on 4/30/17.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int i = 0;
        while (i < 2 * nums.length) {
            if (stk.isEmpty() || nums[stk.peek()] >= nums[i % nums.length]) {
                stk.push(i % nums.length);
                i++;
            } else {
                int smallIndex = stk.pop();
                result[smallIndex % nums.length] = nums[i % nums.length];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {100,1,11,1,120,111,123,1,-1,-100};
        NextGreaterElementII test = new NextGreaterElementII();
        test.nextGreaterElements(a);
    }
}
