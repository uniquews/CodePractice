/**
 * Created by shuaiwang on 12/5/16.
 */

//比较首尾两根柱子，矮柱子旁边的那根柱子的最终高度是可以被确定的。 移动矮柱子的指针， 问题规模变为n - 1
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left + 1 < right) {
            if (height[left] <= height[right]) {
                result += height[left] > height[left + 1] ? height[left] - height[left + 1] : 0;
                height[left + 1] = height[left] > height[left + 1] ? height[left] : height[left + 1];
                left++;
            } else {
                result += height[right] > height[right - 1] ? height[right] - height[right - 1] : 0;
                height[right - 1] = height[right] > height[right - 1] ? height[right] : height[right - 1];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] f = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater test = new TrappingRainWater();
        System.out.print(test.trap(f));
    }
}
