package fb;

/**
 *
 * 给定一个排好序的int set 和 一个值k 计算# of subset 满足 min(s)+max(s) < k
 样例 [2 3 4 7] 7
 答案 5
 解释 [2] [3] [2 3] [2 4] [2 3 4]
 *
 * */


public class MinMaxSubsetSumLessThanK {
    public int numOfSubsetLessthanK(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        int result = 0;

        while (i <= j) {
            if (nums[i] + nums[j] < k) {
                result += Math.pow(2,  j - i);
                i++;
            } else {
                j--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,4,7};
        int k = 7;
        MinMaxSubsetSumLessThanK test = new MinMaxSubsetSumLessThanK();
        System.out.println(test.numOfSubsetLessthanK(nums, k));
    }
}
