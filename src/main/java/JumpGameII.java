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

    // greedy
//    public int jump(int[] A) {
//        // write your code here
//        int curMax = 0, i = 0, jump = 0;
//        while (curMax < A.length - 1) {
//            int lastMax = curMax;
//            for (; i <=lastMax; i++) {
//                curMax = Math.max(curMax, i + A[i]);
//            }
//            jump++;
//            if (lastMax == curMax)
//                return -1;
//        }
//        return jump;
//    }
}
