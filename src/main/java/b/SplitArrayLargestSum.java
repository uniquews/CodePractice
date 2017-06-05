package b;

/**
 * Created by bohan on 5/20/17.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = nums[0];
        long sum = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (m == 1) {
            return (int) sum;
        }
        long l = max;
        long r = sum;
        while (l < r) {
            long candidate = (l + r) / 2;
            if (isCandidateGreaterThanTarget(nums, candidate, m)) {
                r = candidate - 1;
            } else {
                l = candidate + 1;
            }
        }
        return (int) l;
    }

    private boolean isCandidateGreaterThanTarget(int[] nums, long candidate, int m) {
        long sum = 0;
        int count = 1;
        for (int n : nums) {
            sum += n;
            if (sum > candidate) {
                sum = n;
                count++;
            }
        }
        return count <= m;
    }
}
