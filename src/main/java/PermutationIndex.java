/**
 * Created by shuaiwang on 7/8/17.
 */

/**
 *
 * http://www.cnblogs.com/EdwardLiu/p/5104310.html
 *
 * */
public class PermutationIndex {
    public long permutationIndex(int[] A) {
        // Write your code here
        long factor = 1;
        for (int i = 1; i < A.length; i++) {
            factor *= i;
        }

        long result = 0;
        long init = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            long count = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            result += count * factor;
            if (init != 0) {
                factor /= init;
                init--;
            }
        }
        return result + 1;
    }
}
