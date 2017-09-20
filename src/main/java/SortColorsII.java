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
        int start = 0, end = colors.length - 1;
        while (count < k) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = start; i <= end; i++) {
                minVal = Math.min(minVal, colors[i]);
                maxVal = Math.max(maxVal, colors[i]);
            }

            int left = start, cur = start, right = end;
            while (cur <= right) {
                if (colors[cur] == minVal) {
                    swap(colors, cur, left);
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
            count += 2;
        }
    }

    private void swap(int[] colors, int m, int n) {
        int tmp = colors[m];
        colors[m] = colors[n];
        colors[n] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2,1,1,2,2};
        int k = 2;
        SortColorsII test = new SortColorsII();
        test.sortColors2(a,k);

    }
}
