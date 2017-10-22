package G;

public class ChangeOneNumberToInceasingArray {
    public int oneNumberChangeToIncreasingArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (helper(nums, i - 2, i)  ) {
                    return i - 1;
                }
                if (helper(nums, i - 1, i + 1)) {
                    return i;
                }
                return -1;
            }
        }
        return 0; // 返回任意一个
    }

    private boolean helper(int[] nums, int prev, int cur) {
        if (prev < 0) {
            prev = cur;
            cur = cur + 1;
        }

        while (cur < nums.length) {
            if (nums[cur] < nums[prev]) {
                return false;
            }
            prev = cur;
            cur++;
        }
        return true;
    }
}
