import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/29/17.
 */

/***
 *
 * 思路： 假设数组是1，5，10，
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int patch = 0;
        int i = 0;
        while (sum < n) {
            if (i < nums.length && nums[i] <= sum + 1) {
                sum += nums[i++];
            } else {
                while ((i == nums.length || (i < nums.length && nums[i] > sum + 1))
                        && sum < n) {
                    sum += sum + 1;
                    patch++;
                }
            }
        }
        return patch;
    }

    public static void main(String[] args) {
        int[] a = {1,5,10};
        int n = 20;
        PatchingArray test = new PatchingArray();
        System.out.print(test.minPatches(a, n));
    }
}
