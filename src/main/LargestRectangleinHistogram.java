package main;

import java.util.Stack;

/**
 * Created by shuaiwang on 10/24/16.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        // write your code here
        Stack<Integer> stk = new Stack<>();
        int max = 0;

        for (int i = 0; i <= height.length; i++) {
            int curHeight = i == height.length ? -1 : height[i];
            while (!stk.isEmpty() && curHeight < height[stk.peek()]) {
                int heightindex = stk.pop();
                int width = stk.isEmpty() ? i : i - stk.peek() - 1; // error prone!
                max = Math.max(max, height[heightindex] * width);
            }
            stk.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram test = new LargestRectangleinHistogram();
//        int[] height = {3,5,5,2,5,5,6,6,4,4};
        int[] height = {2,7,6};
        test.largestRectangleArea(height);
    }
}
