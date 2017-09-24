/**
 * Created by shuaiwang on 5/25/17.
 */
public class Pow {
    public double myPow(double x, int n) {
        return helper(x, (long)n);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n == 1) {
            return x;
        }

        if (n > 0) {
            double res = helper(x, n / 2);
            if (n % 2 == 0) {
                return res * res;
            } else {
                return res * res * x;
            }
        } else {
            long m = Math.abs(n);
            double res = helper(x, m / 2);
            if (m % 2 == 0) {
                return 1.0 / (res * res);
            } else {
                return 1.0 / (res * res * x);
            }
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -3;
        Pow p = new Pow();
        System.out.println(p.myPow(x, n));
    }
}
