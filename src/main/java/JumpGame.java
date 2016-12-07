/**
 * Created by shuaiwang on 8/28/16.
 */
public class JumpGame {
    //{2,1,0,2,3,2,8,5,7,10,9,9,6,6,3,4,2,9,9,0};
    // dp
//    public boolean canJump(int[] A) {
//        // wirte your code here
//        if (A.length == 0)
//        {
//            return false;
//        }
//
//        boolean[] f = new boolean[A.length];
//
//        f[0] = true;
//        for (int i = 1; i < A.length; i++)
//        {
//            for (int j = 0; j < i; j++)
//            {
//                if (f[j] && j + A[j] >= i)
//                {
//                    f[i] = true;
//                }
//            }
//        }
//        return f[A.length - 1];
//    }

    // greedy
    public boolean canJump(int[] A) {
        // write your code here
        if (A.length == 0) {
            return false;
        }

        int maxJump = A[0];

        for (int i = 1; i < A.length; i++) {
            if (maxJump >= i) {
                maxJump = Math.max(maxJump, i + A[i]);
            }
        }

        return maxJump >= A.length - 1;
    }
}
