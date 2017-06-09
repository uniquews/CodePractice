/**
 * Created by shuaiwang on 6/8/17.
 */
public class PartitionArrayII {
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        int p = 0;
        int q = nums.length - 1;
        int cur = 0;

        while (cur <= q) { // q 指向的是 不是大于high的数字，q的右边才是  所以cur == q的时候还是有可能交换的
            if (nums[cur] < low) {
                swap(nums, cur, p);
                cur++;
                p++;
            } else if (nums[cur] >= low && nums[cur] <= high) {
                cur++;
            } else {
                swap(nums, cur, q);
                q--;
            }
        }
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,4,1,2,3,1,2};
        int l = 2, h = 2;
        PartitionArrayII test = new PartitionArrayII();
        test.partition2(nums, l, h);
    }
}
