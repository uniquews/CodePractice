import java.util.Arrays;

/**
 * Created by shuaiwang on 8/28/16.
 */
public class JumpGameII {
    public int jump(int[] A) {
        // write your code here
        if (A.length == 0) {
            return 0;
        }

        int[] f = new int[A.length];
        Arrays.fill(f, Integer.MAX_VALUE);

        f[0] = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }

        return f[A.length - 1];
    }
}
