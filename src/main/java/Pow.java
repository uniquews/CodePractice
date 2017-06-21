/**
 * Created by shuaiwang on 5/25/17.
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }

        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            double tmp = myPow(x, (-1) * n / 2);
            if (n % 2 == 0) {
                return 1 / tmp * tmp;
            } else {
                System.out.println(x * tmp * tmp);
                return 1 / (x * tmp * tmp);
            }
        } else {
            double tmp = myPow(x, n / 2);
            if (n % 2 == 0) {
                return tmp * tmp;
            } else {
                return x * tmp * tmp;
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
