import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by shuaiwang on 1/29/17.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (hashMap.containsKey(C[i] + D[j]))
                    hashMap.put(C[i] + D[j], hashMap.get(C[i] + D[j]) + 1);
                else
                    hashMap.put(C[i] + D[j], 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (hashMap.containsKey((-1) * (A[i] + B[j])))
                    result += hashMap.get((-1) * (A[i] + B[j]));
            }
        }
        return result;
    }
}
