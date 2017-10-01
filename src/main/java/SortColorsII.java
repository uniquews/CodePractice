/**
 * Created by shuaiwang on 10/13/16.
 */
public class SortColorsII {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }

        int start = 0;
        int end = colors.length - 1;
        while (start < end) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = start; i <= end; i++) {
                minVal = Math.min(minVal, colors[i]);
                maxVal = Math.max(maxVal, colors[i]);
            }

            int left = start;
            int cur = start;
            int right = end;
            while (cur <= right) {
                if (colors[cur] == minVal) {
                    swap(colors, left, cur);
                    left++;
                    cur++;
                } else if (colors[cur] > minVal && colors[cur] < maxVal) {
                    cur++;
                } else {
                    swap(colors, cur, right);
                    right--;
                }
            }
            start = left;
            end = right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
