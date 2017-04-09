/**
 * Created by shuaiwang on 4/9/17.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int countOfOne = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                if (countOfOne == 0) {
                    countOfOne++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int m = Integer.MIN_VALUE;
        int n = Integer.MAX_VALUE;
        int x = -2;
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(x));

    }
}
