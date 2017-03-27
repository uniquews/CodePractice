/**
 * Created by shuaiwang on 3/27/17.
 */
public class SqrtXII {
    public double sqrt(double x) {
        // Write your code here
        double start = 0.0;
        double end = x * 1.0;
        double delta = 1e-12; //10 11, 12都可以。。。

        // 当x = 0.01时， result 应该是0.1， 但是如果end = 0.01, 就永远都不可能二分搜索到0.1
        if (end < 1.0) {
            end = 1.0;
        }

        while (end - start > delta) {
            double mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start; // 返回start因为结果的平方要小于等于 x
    }

    public static void main(String[] args) {
        SqrtXII test = new SqrtXII();
        test.sqrt(1);
    }
}
