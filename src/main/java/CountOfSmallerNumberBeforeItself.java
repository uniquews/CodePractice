import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shuaiwang on 1/7/17.
 */
public class CountOfSmallerNumberBeforeItself {
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        int[] sorted = Arrays.copyOf(A, A.length);
        ArrayList<Integer> result = new ArrayList<>(A.length);

        Arrays.sort(sorted);

        for (int i = 0; i < A.length; i++) {
            int index = Arrays.binarySearch(sorted, A[i]);
            result.add(i, index);
        }
        return result;
    }
}
