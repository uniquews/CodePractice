/**
 * Created by shuaiwang on 12/5/16.
 */

//比较首尾两根柱子，矮柱子旁边的那根柱子的最终高度是可以被确定的。 移动矮柱子的指针， 问题规模变为n - 1
public class TrappingRainWater {
    public int trapRainWater(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }

        int start = 0, end = height.length - 1, water = 0, shortest = 0;
        while (start + 1 < end) {
            if (height[start] <= height[end] && start + 1 < end) {
                if (height[start] - height[start + 1] > 0) {
                    water += height[start] - height[start + 1];
                    height[start + 1] = height[start];
                }
                start++;
            } else if (height[end] < height[start] && start + 1 < end) {
                if (height[end] - height[end - 1] > 0) {
                    water += height[end] - height[end - 1];
                    height[end - 1] = height[end];
                }
                end--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] f = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater test = new TrappingRainWater();
        System.out.print(test.trapRainWater(f));
    }
}
