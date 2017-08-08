/**
 * Created by shuaiwang on 7/26/17.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        for (int i = result.length - 1; i >= 1; i--) {
            result[i] = digits[i - 1];
        }
        result[0] = 1;
        return result;
    }
}
