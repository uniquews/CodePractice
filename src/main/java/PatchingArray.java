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
//    public int minPatches(int[] nums, int n) {
//        long sum = 0;
//        int patch = 0;
//        int i = 0;
//        while (sum < n) {
//            if (i < nums.length && nums[i] <= sum + 1) {
//                sum += nums[i++];
//            } else {
//                while ((i == nums.length || (i < nums.length && nums[i] > sum + 1))
//                        && sum < n) {
//                    sum += sum + 1;
//                    patch++;
//                }
//            }
//        }
//        return patch;
//    }

//    public int minPatches(int[] nums, int n) {
//        long sum = 0; // 当n时Integer.MAX 时， sum += sum + 1 sum有可能加完之后越界，当时sum变为负数，继续进入while 循环
//        int i = 0, result = 0;
//        while (sum < n) {
//            if (i < nums.length && nums[i] <= sum + 1) { //否则从sum到sum + 1这部分不能被cover到
//                sum += nums[i++];
//            } else {
//                if (i < nums.length) {
//                    while (sum + 1 < nums[i] && sum < n) { // 尽管sum 还没有当前的num[i] 但是可能已经reach到了n
//                        sum += sum + 1;
//                        result++;
//                    }
//                } else {
//                    sum += sum + 1;
//                    result++;
//                }
//            }
//        }
//        return result;
//    }

    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length || sum < n; i++) {
            if (sum >= n) {
                return count;
            }

            if (i == nums.length || nums[i] > sum + 1) {
                count++;
                sum += sum + 1;
                i--; // 因为没有用到当前的i
            } else {
                sum += nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {};
        int n = 7;
        PatchingArray test = new PatchingArray();
        System.out.print(test.minPatches(a, n));
    }
}
