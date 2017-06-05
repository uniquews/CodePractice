package b;

/**
 * Created by bohan on 5/14/17.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] A) {
        int startIndex = findStartIndex(A);
        int endIndex = findEndIndex(A);
        return endIndex - startIndex <= 0 ? 0 : endIndex - startIndex + 1;
    }

    private int findEndIndex(int[] A) {
        int preMax = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            preMax = Math.max(preMax, A[i]);
            if (A[i] < preMax) {
                index = i;
            }
        }
        return index;
    }

    private int findStartIndex(int[] A) {
        int postMin = Integer.MAX_VALUE;
        int index = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            postMin = Math.min(postMin, A[i]);
            if (A[i] > postMin) {
                index = i;
            }
        }
        return index;
    }
}
