/**
 * Created by shuaiwang on 4/23/17.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        return n > 0 && n % 3 == 0 && isPowerOfThree(n / 3);
    }
}
