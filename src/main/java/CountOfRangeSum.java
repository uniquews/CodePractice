/**
 * Created by shuaiwang on 4/4/17.
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        return  divideAndConquer(sum, 0, nums.length, lower, upper);
    }

    private int divideAndConquer(long[] sum, int left, int right, int lower, int upper) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int i = left, j = mid + 1;
        int countFromLeft = divideAndConquer(sum, i, mid, lower, upper);
        int countFromRight = divideAndConquer(sum, j, right, lower, upper);

        int count = 0;
        long[] merge = new long[right - left + 1];

        int j1 = mid + 1, j2 = mid + 1;
        while (i <= mid) {
            while (j1 <= right && sum[j1] - sum[i] < lower) {
                j1++;
            }

            while (j2 <= right && sum[j2] - sum[i] <= upper) {
                j2++;
            }

            count += j2 - j1;
            i++;
        }

        i = left;
        int index = 0;
        while (i <= mid && j <= right) {
            if (sum[i] < sum[j]) {
                merge[index++] = sum[i++];
            } else {
                merge[index++] = sum[j++];
            }
        }

        while (i <= mid) {
            merge[index++] = sum[i++];
        }

        while (j <= right) {
            merge[index++] = sum[j++];
        }

        System.arraycopy(merge, 0, sum, left, right - left + 1);
        return count + countFromLeft + countFromRight;
    }
}
