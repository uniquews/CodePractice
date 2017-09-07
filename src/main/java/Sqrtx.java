/**
 * Created by shuaiwang on 2/4/17.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }

        int start = 1, end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) { // 这里一定要写成x / mid  mid * mid == x会溢出
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
