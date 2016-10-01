package main;

/**
 * Created by shuaiwang on 9/30/16.
 */
public class MergeSortedArray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }

        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }
    }
}
