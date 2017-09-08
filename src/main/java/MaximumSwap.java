import java.util.Arrays;

/**
 * Created by shuaiwang on 9/7/17.
 *
 * // 记录每个数 右边最大的数
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] rightMax = new int[digits.length];

        Arrays.fill(rightMax, -1);
        int max = digits.length - 1;
        rightMax[digits.length - 1] = digits.length - 1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[max] > digits[i]) {
                rightMax[i] = max;
            } else if (digits[max] == digits[i]) {
                continue;
            } else {
                max = i;
            }
        }

        for (int i = 0; i < rightMax.length; i++) {
            if (rightMax[i] != -1) {
                int index1 = i;
                int index2 = rightMax[i];

                char tmp = digits[index1];
                digits[index1] = digits[index2];
                digits[index2] = tmp;
                break;
            }
        }
        return Integer.valueOf(new String(digits));
    }

    public static void main(String[] args) {
        MaximumSwap test = new MaximumSwap();
        System.out.print(test.maximumSwap(2736));
    }
}
