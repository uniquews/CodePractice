/**
 * Created by shuaiwang on 2/4/17.
 */
public class Sqrtx {
    public int sqrt(int x) {
        // write your code here
        if (x == 0) {
            return 0;
        }

        int start = 1, end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
