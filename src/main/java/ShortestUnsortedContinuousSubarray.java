/**
 * Created by shuaiwang on 5/14/17.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] A) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int smallInMostRight = 0;
        int largeInMostLeft = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            maxVal = Math.max(maxVal, A[i]);
            if (A[i] < maxVal) {
                smallInMostRight = i;
            }
        }

        for (int i = A.length - 1; i >= 0; i--) {
            minVal = Math.min(minVal, A[i]);
            if (A[i] > minVal) {
                largeInMostLeft = i;
            }
        }

        if (smallInMostRight == 0 && largeInMostLeft == A.length - 1) {
            return 0;
        }

        return smallInMostRight - largeInMostLeft + 1;
    }
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
        int[] a = {2, 6, 4, 8, 10, 9, 15};
        test.findUnsortedSubarray(a);
    }
}


