/**
 * Created by shuaiwang on 5/20/17.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        long start = max, end = sum;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            int cut = getCut(nums, mid);
            if (cut > m) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getCut(nums, start) <= m) {
            return (int)start;
        } else {
            return (int)end;
        }
    }

    private int getCut(int[] nums, long len) {
        int count = 0, cut = 1;
        for (int i = 0; i < nums.length; i++) {
            long next = count + nums[i];
            if (next > len) {
                cut++;
                count = nums[i];
            } else {
                count += nums[i];
            }
        }
        return cut;
    }
}
