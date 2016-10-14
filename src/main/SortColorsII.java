package main;

/**
 * Created by shuaiwang on 10/13/16.
 */
public class SortColorsII {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }

        int count = 0;
        int left = 0;
        int right = colors.length - 1;

        while (count < k) {
            int start = left;
            int end  = right;
            int cur = left;

            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = start; i <= end; i++) {
                minVal = Math.min(colors[i], minVal);
                maxVal = Math.max(colors[i], maxVal);
            }

            while (cur <= right) {
                if (colors[cur] == minVal) {
                    swap(colors, cur, left);
                    cur++;
                    left++;
                } else if (colors[cur] > minVal && colors[cur] < maxVal) {
                    cur++;
                } else {
                    swap(colors, cur, right);
                    right--;
                }
            }

            count += 2;
        }
    }

    private void swap(int[] colors, int m, int n) {
        int tmp = colors[m];
        colors[m] = colors[n];
        colors[n] = tmp;
    }
}
