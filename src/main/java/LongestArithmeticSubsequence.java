import java.util.Arrays;

/**
 * Created by shuaiwang on 9/10/17.
 */
public class LongestArithmeticSubsequence {
    public int lenghtOfLongestAP(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        Arrays.sort(nums);
        int[][] f = new int[nums.length - 1][nums.length];
        int llap = 2;

        // 以最后两个数字开头的最长llap是2
        for (int i = 0; i < f.length; i++) {
            for (int j = i + 1; j < f[0].length; j++) {
                f[i][j] = 2;
            }
        }

        for (int j = nums.length - 2; j >= 1; j--) {
            int i = j - 1, k = j + 1;

            while (i >= 0 && k < nums.length) {
                long sum = (long)nums[i] + (long)nums[k];
                long target = 2 * (long)nums[j];

                if (sum < target) {
                    k++;
                } else if (sum > target) {
                    i--;
                } else {
                    f[i][j] = f[j][k] + 1;
                    llap = Math.max(llap, f[i][j]);
                    i--;
                    k++;
                }
            }
        }
        return llap;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence test = new LongestArithmeticSubsequence();
        int[] nums = {5, 10, 15, 20, 25, 30};
        System.out.println(test.lenghtOfLongestAP(nums));
    }
}
