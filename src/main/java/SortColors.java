/**
 * Created by shuaiwang on 10/1/16.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        int nextToLast0 = 0; // could only point to 0 or 1;
        int cur = 0;
        int prevToFirst2 = nums.length - 1;

        while (cur <= prevToFirst2) { // == is because that the prevToFirst2 needs to be checked
            if (nums[cur] == 0) {
                swap(nums, cur, nextToLast0);
                cur++;
                nextToLast0++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, prevToFirst2);
                prevToFirst2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
