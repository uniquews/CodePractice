/**
 * Created by shuaiwang on 9/7/17.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[index - 2]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII test = new RemoveDuplicatesFromSortedArrayII();
        int[] a = {1,1,1,2,2,3};
        test.removeDuplicates(a);
    }
}
