/**
 * Created by shuaiwang on 5/20/17.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        long max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }

        long start = max, end = sum;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            int cuts = getCuts(nums, mid);
            if (cuts > m) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getCuts(nums, start) <= m) {
            return (int)start;
        } else {
            return (int)end;
        }
    }

    private int getCuts(int[] nums, long eachCut) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= eachCut) {
                sum += nums[i];
            } else {
                count++;
                sum = 0;
                i--;
            }
        }
        return count;
    }
}
