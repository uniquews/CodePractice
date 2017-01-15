/**
 * Created by shuaiwang on 1/15/17.
 */


// f[i] means the number of arithemtic slices ended with index i
// the result would be sum of f[i], where 2 <= i <= A.length - 1
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int[] f = new int[A.length];
        for (int i = 2; i <= A.length - 1; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                f[i] = f[i - 1] + 1;
                sum += f[i];
            }
        }
        return sum;
    }
}
