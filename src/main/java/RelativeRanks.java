/**
 * Created by shuaiwang on 4/30/17.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pos = partition(nums, i);
            if (pos == 0) {
                result[i] = "Gold Medal";
            } else if (pos == 1) {
                result[i] = "Silver Medal";
            } else if (pos == 2) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(pos + 1);
            }
        }
        return result;
    }

    private int partition(int[] nums, int index) {
        swap(nums, index, nums.length - 1);
        int leftTail = 0, end = nums.length - 1;
        for (int i = leftTail; i < end; i++) {
            if (nums[i] > nums[end]) {
                leftTail++;
            }
        }
        swap(nums, index, nums.length - 1);
        return leftTail;
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {10,3,8,9,4};
        RelativeRanks test = new RelativeRanks();
        test.findRelativeRanks(a);
    }
}
