import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by shuaiwang on 1/7/17.
 */
public class CountOfSmallerNumber {
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>(queries.length);

        if (A == null || A.length == 0) {
            return new ArrayList<Integer>(Collections.nCopies(queries.length, 0));
        }

        int[] sorted = Arrays.copyOf(A, A.length);

        Arrays.sort(sorted);

        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(sorted, queries[i]);
            result.add(i, index);
        }

        return result;
    }

    private int binarySearch(int[] A, int num) {
        int start = 0;
        int end = A.length - 1;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == num) {
                end = mid;
            } else if (A[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= num) {
            return start;
        }

        if (A[end] >= num) {
            return end;
        }

        return end + 1;
    }

    public static void main(String[] args) {
        int[] A = {39,49,13,22,25,57,92,92,94,56,54,70,9,52,63,75,55,33,79,13,52,35,11,17,99,65,86,22,31,53,91,51,18,71,70,23,73,50,35,51,38,13,80,81,54,58,40,1,80,70,1,53,63,74,48,18,52,80,6,42};
        int[] queries = {83};
        CountOfSmallerNumber test = new CountOfSmallerNumber();
        System.out.print(test.countOfSmallerNumber(A, queries));
    }
}
