/**
 * Created by shuaiwang on 12/18/16.
 */
public class CoinsInALineII {
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }

        if (values.length == 1) {
            return true;
        }

        int[] remainSum = new int[values.length + 1];
        int[] f = new int[values.length + 1];

        for (int i = 1; i <= values.length; i++) {
            remainSum[i] = remainSum[i - 1] + values[values.length - i];
        }

        f[1] = values[values.length - 1];
        f[2] = values[values.length - 1] + values[values.length - 2];

        for (int i = 3; i <= values.length; i++) {
            f[i] = Math.max(remainSum[i] - f[i - 1], remainSum[i] - f[i - 2]);
        }
        return f[values.length] > remainSum[values.length] / 2;
    }
}
