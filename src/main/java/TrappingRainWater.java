/**
 * Created by shuaiwang on 12/5/16.
 */

//比较首尾两根柱子，矮柱子旁边的那根柱子的最终高度是可以被确定的。 移动矮柱子的指针， 问题规模变为n - 1
public class TrappingRainWater {
    public int trapRainWater(int[] heights) {
        // write your code here
        int start = 0, end = heights.length - 1, count = 0;

        while (start < end) {
            if (heights[start] < heights[end]) {
                if (start + 1 < end && heights[start + 1] < heights[start]) {
                    count += heights[start] - heights[start + 1];
                    heights[start + 1] = heights[start];
                }
                start++;
            } else if (heights[start] > heights[end]) {
                if (end - 1 > start && heights[end - 1] < heights[end]) {
                    count += heights[end] - heights[end - 1];
                    heights[end - 1] = heights[end];
                }
                end--;
            } else {
                if (start + 1 < end && heights[start + 1] < heights[start]) {
                    count += heights[start] - heights[start + 1];
                    heights[start + 1] = heights[start];
                }
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] f = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater test = new TrappingRainWater();
        System.out.print(test.trapRainWater(f));
    }
}
