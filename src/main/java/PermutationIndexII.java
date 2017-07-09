import java.util.HashMap;

/**
 * Created by shuaiwang on 7/8/17.
 */
public class PermutationIndexII {
    public long permutationIndexII(int[] A) {
        // Write your code here
        long factor = 1, result = 0, duplicate = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int len = A.length;
        for (int i = len - 1; i >= 0; i--) {
            if (!hashMap.containsKey(A[i])) {
                hashMap.put(A[i], 1);
            } else {
                hashMap.put(A[i], hashMap.get(A[i]) + 1);
                duplicate *= hashMap.get(A[i]);
            }

            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }

            result += count * factor / duplicate;
            factor *= len - i;
        }

        return result + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,4,2,2};
        PermutationIndexII test = new PermutationIndexII();
        test.permutationIndexII(a);
    }
}
