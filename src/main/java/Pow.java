/**
 * Created by shuaiwang on 5/25/17.
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return power(x, n);
        } else {
            return 1 / power(x, n);
        }
    }

    private double power(double x, int n) {
        if (n == 0)
            return 1.0;

        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static void main(String[] args) {
        double x = 8.0;
        int n = 3;
        Pow p = new Pow();
        p.myPow(x, n);
    }
}
