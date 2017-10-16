package fb;


// http://www.geeksforgeeks.org/split-array-two-equal-sum-subarrays/
public class SplitAnArrayIntoTwoEqualSumSubarrays {
    public int split(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum += nums[i];
            leftSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1 , 2 , 3 , 4 , 5 , 5 };
        SplitAnArrayIntoTwoEqualSumSubarrays test = new SplitAnArrayIntoTwoEqualSumSubarrays();
        System.out.println(test.split(a));
    }
}
