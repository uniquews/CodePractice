/**
 * Created by shuaiwang on 12/13/16.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        // write your code here
        int result = 0;
        if (heights == null || heights.length == 0) {
            return result;
        }

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            if (heights[left] < heights[right]) {
                result = Math.max(result, heights[left] * (right - left));
                left++;
            } else {
                result = Math.max(result, heights[right] * (right - left));
                right--;
            }
        }
        return result;
    }
}
