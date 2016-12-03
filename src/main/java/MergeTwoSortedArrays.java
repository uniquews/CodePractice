/**
 * Created by shuaiwang on 10/11/16.
 */
public class MergeTwoSortedArrays {
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int[] result = new int[A.length + B.length];
        int m = A.length - 1;
        int n = B.length - 1;
        int index = A.length + B.length - 1;

        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                result[index--] = A[m--];
            } else {
                result[index--] = B[n--];
            }
        }

        while (m >= 0) {
            result[index--] = A[m--];
        }

        while (n >= 0) {
            result[index--] = B[n--];
        }

        return result;
    }
}
