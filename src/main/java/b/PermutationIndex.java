package b;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bohan on 7/8/17.
 */
public class PermutationIndex {
    public long permutationIndex(int[] A) {
        long fact = 1;
        long index = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            index += getRankInArray(i, A) * fact;
            fact *= A.length - i;
        }
        return index;
    }

    public long permutationIndexII(int[] A) {
        Map<Integer, Integer> dup = new HashMap<>();
        long fact = 1;
        long dupFact = 1;
        long index = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            dupFact = getDupFact(A[i], dup, dupFact);
            index += getRankInArray(i, A) * fact / dupFact;
            fact *= A.length - i;
        }
        return index;
    }

    private int getRankInArray(int i, int[] A) {
        int rank = 0;
        for (int j = i + 1; j < A.length; j++) {
            if (A[i] > A[j]) {
                rank++;
            }
        }
        return rank;
    }

    private long getDupFact(int key, Map<Integer, Integer> dup, long dupFact) {
        if (dup.containsKey(key)) {
            dup.put(key, dup.get(key) + 1);
            dupFact *= dup.get(key);
        } else {
            dup.put(key, 1);
        }
        return dupFact;
    }
}
