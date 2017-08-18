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

        if (n > 0) {
            double current = myPow(x, n / 2);
            if (n % 2 == 0) {
                return current * current;
            } else {
                return current * current * x;
            }
        } else {
            double current = myPow(x, (-1) * (n / 2)); //易错，一定要写成(-1) * (n / 2) 而不是(-1) * n / 2; 因为当n = Integer.Min 时，(-1) * n 会溢出 而n / 2肯定不会溢出
            if (n % 2 == 0) {
                return 1 / (current * current);
            } else {
                return 1 / (current * current * x);
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
