import java.util.Arrays;

/**
 * Created by shuaiwang on 9/10/17.
 */
public class LongestArithmeticSubsequence {
    //nums必须是sorted
//    public int lenghtOfLongestAP(int[] nums) {
//        if (nums == null) {
//            return 0;
//        }
//
//        if (nums.length <= 2) {
//            return nums.length;
//        }
//
//        Arrays.sort(nums);
//        int[][] f = new int[nums.length - 1][nums.length];
//        int llap = 2;
//
//        // 以最后两个数字开头的最长llap是2
//        for (int i = 0; i < f.length; i++) {
//            for (int j = i + 1; j < f[0].length; j++) {
//                f[i][j] = 2;
//            }
//        }
//
//        for (int j = nums.length - 2; j >= 1; j--) {
//            int i = j - 1, k = j + 1;
//
//            while (i >= 0 && k < nums.length) {
//                long sum = (long)nums[i] + (long)nums[k];
//                long target = 2 * (long)nums[j];
//
//                if (sum < target) {
//                    k++;
//                } else if (sum > target) {
//                    i--;
//                } else {
//                    f[i][j] = f[j][k] + 1;
//                    llap = Math.max(llap, f[i][j]);
//                    i--;
//                    k++;
//                }
//            }
//        }
//        return llap;
//    }

    /**
     * f[i][j] = f[k][i] + 1 nums[j] - nums[i] == nums[i] - nums[k]
     * 可以不排序
     * */
//    public int lenghtOfLongestAP(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int count = 0;
//        int[][] f = new int[nums.length][nums.length];
//        for (int i = 0; i < f.length - 1; i++) {
//            for (int j = i + 1; j < f.length; j++) {
//                f[i][j] = 2;
//            }
//        }
//
//        for (int j = 2; j < nums.length; j++) {
//            for (int i = j - 1; i >= 1; i--) {
//                for (int k = i - 1; k >=0; k--) {
//                    if (nums[j] - nums[i] == nums[i] - nums[k]) {
//                        f[i][j] = Math.max(f[i][j], f[k][i] + 1);
//                    }
//                }
//                count = Math.max(count, f[i][j]);
//            }
//        }
//        return count;
//    }

//    public int lenghtOfLongestAP(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int[][] f = new int[nums.length][nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                f[i][j] = 2;
//            }
//        }
//
//        int result = 2;
//        for (int i = 2; i < nums.length; i++) {
//            for (int j = 1; j < i; j++) {
//                for (int k = 0; k < j; k++) {
//                    if (nums[i] - nums[j] == nums[j] - nums[k]) {
//                        f[i][j] = Math.max(f[i][j], f[j][k] + 1);
//                    }
//                }
//                result = Math.max(result, f[i][j]);
//            }
//        }
//        return result;
//
//    }
    public int lenghtOfLongestAP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] f = new int[nums.length][nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                f[j][i] = 2;
            }
        }

        int result = 2;
        for (int j = 1; j < nums.length - 1; j++) {
            int i = j - 1;
            int k = j + 1;

            while (i >= 0 && k < nums.length) {
                int tmp1 = nums[j] - nums[i];
                int tmp2 = nums[k] - nums[j];

                if (tmp1 == tmp2) {
                    f[j][k] = Math.max(f[j][k], f[i][j] + 1);
                    result = Math.max(result, f[j][k]);
                    i--;
                    k++;
                } else if (tmp1 < tmp2) {
                    i--;
                } else {
                    k++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence test = new LongestArithmeticSubsequence();
//        int[] nums = {2, 4, 6, 8, 10};
//        int[] nums = {1, 7, 10, 13, 14, 19};
        int[] nums = {1, 7, 10, 15, 27, 29};
//        int[] nums = {1,3,5};
        System.out.println(test.lenghtOfLongestAP(nums));
    }
}
