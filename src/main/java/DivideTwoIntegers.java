/**
 * Created by shuaiwang on 3/27/17.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // Write your code here
        // check if divisor is valid
        if (divisor == 0)
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        // Given the fact that we use long below, if we dont check it here, the result would be
        // ABS(long() Integer.MIN_VALUE).
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        long shift = 1;
        while (a >= b) {
            shift = shift << 1;
            b = b << 1;
        }

        int result = 0;
        while (a >= Math.abs((long)divisor)) {
            if (a >= b) {
                result += shift;
                a -= b;
            }
            b = b >> 1;
            shift = shift >> 1;
        }
        return result * (sign);
    }

    public static void main(String[] args) {
        int a = -1;
        int b = 1;
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(a, b));
    }
}
