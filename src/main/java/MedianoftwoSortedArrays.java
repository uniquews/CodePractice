/**
 * Created by shuaiwang on 10/6/16.
 */
public class MedianoftwoSortedArrays {
//    public double findMedianSortedArrays(int[] A, int[] B) {
//        // write your code here
//        int len = A.length + B.length;
//
//        if (len % 2 == 0) {
//            return (findKthNumber(A, 0, B, 0, len / 2) +
//                    findKthNumber(A, 0, B, 0, len / 2 + 1)) / 2.0;
//        } else {
//            return findKthNumber(A, 0, B, 0, len / 2 + 1) * 1.0;
//        }
//
//    }
//
//    private int findKthNumber(int[] A, int aStart, int[] B, int bStart, int k) {
//        if (A.length - aStart > B.length - bStart) {
//            return findKthNumber(B, bStart, A, aStart, k);
//        }
//
//        if (A.length - aStart == 0) {
//            return B[k - 1];
//        }
//
//        if (k == 1) {
//            return Math.min(A[aStart], B[bStart]);
//        }
//
//
//        int posInA = Math.min(A.length - aStart, k / 2); // 1
//        int posInB = k - posInA; // 1
//
//        if (A[aStart + posInA - 1] < B[bStart + posInB - 1]) {
//            return findKthNumber(A, aStart + posInA, B, bStart, k - posInA);
//        } else if (A[aStart + posInA - 1] > B[bStart + posInB - 1]) {
//            return findKthNumber(A, aStart, B, bStart + posInB, k - posInB);
//        } else {
//            return A[aStart + posInA - 1];
//        }
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if (size % 2 == 0) {
            return 1.0 * (helper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, size / 2) + helper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, size / 2 + 1)) / 2;
        } else {
            return 1.0 * helper(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, size / 2 + 1);
        }
    }

    private int helper(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        if (s1 > e1) {
            return nums2[s2 + k - 1];
        }

        if (e1 - s1 + 1 > e2 - s2 + 1) {
            return helper(nums2, s2, e2, nums1, s1, e1, k);
        }

        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int pos = Math.min(k / 2, e1 - s1 + 1);
        int posInB = k - pos;
        if (nums1[s1 + pos - 1] == nums2[s2 + posInB - 1]) {
            return nums1[s1 + pos - 1];
        } else if (nums1[s1 + pos - 1] < nums2[s2 + posInB - 1]) {
            return helper(nums1, s1 + pos, e1, nums2, s2, e2, k - pos);
        } else {
            return helper(nums1, s1, e1, nums2, s2 + posInB, e2, k - posInB);
        }
    }

    public static void main(String[] args) {
        int[] A = {2,3};
        int[] B = {1,4};

        MedianoftwoSortedArrays test = new MedianoftwoSortedArrays();
        System.out.print(test.findMedianSortedArrays(A, B));
    }
}
