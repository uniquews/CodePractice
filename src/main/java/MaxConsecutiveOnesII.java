import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 4/26/17.
 */
public class MaxConsecutiveOnesII {
    // 方法一
//    public int findMaxConsecutiveOnes(int[] nums) {
//        // zeroLeft 0 的左边且包含0本身有多少个连续的1
//        // zeroRight 0 的右边且不包含0本身有多少连续的1  所以zeroRight一定只包含真正的1
//        int zeroLeft = 0, zeroRight = 0, result = 0;
//        for (int n : nums) {
//            if (n == 1) {
//                zeroRight++;
//            } else {
//                zeroLeft = zeroRight + 1; // 加上被flip成1的0
//                zeroRight = 0;
//            }
//            result = Math.max(result, zeroLeft + zeroRight);
//        }
//        return result;
//    }

    //方法二
    // 控制一个窗口[left, right] 使得这个窗口里最多只有一个0，当right滑到第二个0的时候，移动left直到把0移出窗口
//    public int findMaxConsecutiveOnes(int[] nums) {
//        int left = 0, right = 0, numOfZero = 1, result = 0;
//        for (; right < nums.length; right++) {
//            if (nums[right] == 0) {
//                numOfZero--;
//            }
//
//            if (numOfZero < 0) {
//                while (nums[left] != 0) {
//                    left++;
//                }
//                numOfZero++;
//                left++;
//            }
//            result = Math.max(result, right - left + 1);
//        }
//        return result;
//    }

    //方法三，如果变成data stream，就要从按照index顺序记录0所在的位置
//    public int findMaxConsecutiveOnes(int[] nums) {
//        int k = 1, left = 0, result = 0; // 允许flip 1个0
//        Queue<Integer> zeros = new LinkedList<>();
//        for (int right = 0; right < nums.length; right++) {
//            if (nums[right] == 0) {
//                zeros.add(right);
//            }
//
//            if (zeros.size() > k) {
//                left = zeros.poll() + 1;
//            }
//            result = Math.max(result, right - left + 1);
//        }
//        return result;
//    }

    public int findMaxConsecutiveOnes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int left = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                q.add(i);
            }
            if (q.size() > 1) {
                left = q.poll() + 1;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
