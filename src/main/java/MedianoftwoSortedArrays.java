/**
 * Created by shuaiwang on 10/6/16.
 */
public class MedianoftwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;

        if (len % 2 == 0) {
            return (findKthNumber(A, 0, B, 0, len / 2) +
                    findKthNumber(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKthNumber(A, 0, B, 0, len / 2 + 1) * 1.0;
        }

    }

    private int findKthNumber(int[] A, int aStart, int[] B, int bStart, int k) {
        if (A.length - aStart > B.length - bStart) {
            return findKthNumber(B, bStart, A, aStart, k);
        }

        if (A.length - aStart == 0) {
            return B[k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }


        int posInA = Math.min(A.length - aStart, k / 2); // 1
        int posInB = k - posInA; // 1

        if (A[aStart + posInA - 1] < B[bStart + posInB - 1]) {
            return findKthNumber(A, aStart + posInA, B, bStart, k - posInA);
        } else if (A[aStart + posInA - 1] > B[bStart + posInB - 1]) {
            return findKthNumber(A, aStart, B, bStart + posInB, k - posInB);
        } else {
            return A[aStart + posInA - 1];
        }
    }

    public static void main(String[] args) {
        int[] A = {3};
        int[] B = {4};

        MedianoftwoSortedArrays test = new MedianoftwoSortedArrays();
        System.out.print(test.findKthNumber(A, 0, B, 0, 2));
    }
}
