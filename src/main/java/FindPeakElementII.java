import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 3/27/17.
 */
public class FindPeakElementII {
    public List<Integer> findPeakII(int[][] A) {
        boolean isCol = true;
        return helper(A, isCol, 0, 0, A.length - 1, A[0].length - 1, (0 + A.length - 1) / 2);
    }

    private List<Integer> helper(int[][] A, boolean isCol, int r1, int c1, int r2, int c2, int index) {
        if (isCol) {
            List<Integer> peakIn1D = findPeak(A, isCol, r1, c1, r2, c2, index);
            int upper = index - 1;
            int lower = index + 1;
            if (A[upper][peakIn1D.get(1)] < A[peakIn1D.get(0)][peakIn1D.get(1)] && A[lower][peakIn1D.get(1)] < A[peakIn1D.get(0)][peakIn1D.get(1)]) {
                return new ArrayList<>(Arrays.asList(peakIn1D.get(0), peakIn1D.get(1)));
            } else if (A[upper][peakIn1D.get(1)] > A[peakIn1D.get(0)][peakIn1D.get(1)]) {
                return helper(A, !isCol, r1, c1, index, c2, peakIn1D.get(1));
            } else {
                return helper(A, !isCol, index, c1, r2, c2, peakIn1D.get(1));
            }
        } else {
            List<Integer> peakIn1D = findPeak(A, isCol, r1, c1, r2, c2, index);
            int left = index - 1;
            int right = index + 1;
            if (A[peakIn1D.get(0)][left] < A[peakIn1D.get(0)][peakIn1D.get(1)] && A[peakIn1D.get(0)][right] < A[peakIn1D.get(0)][peakIn1D.get(1)]) {
                return new ArrayList<>(Arrays.asList(peakIn1D.get(0), peakIn1D.get(1)));
            } else if (A[peakIn1D.get(0)][left] > A[peakIn1D.get(0)][peakIn1D.get(1)]) {
                return helper(A, !isCol, r1, c1, r2,  index, peakIn1D.get(0));
            } else {
                return helper(A, !isCol, r1, index, r2, c2, peakIn1D.get(0));
            }
        }
    }

    private List<Integer> findPeak(int[][] A, boolean isCol, int r1, int c1, int r2, int c2, int index) {
        if (isCol) {
            while (c1 + 1 < c2) {
                int mid = c1 + (c2 - c1) / 2;
                if (A[index][mid] > A[index][mid - 1] && A[index][mid] > A[index][mid + 1]) {
                    return new ArrayList<>(Arrays.asList(index, mid));
                } else if (A[index][mid] < A[index][mid - 1]) {
                    c2 = mid;
                } else {
                    c1 = mid;
                }
            }
        } else {
            while (r1 + 1 < r2) {
                int mid = r1 + (r2 - r1) / 2;
                if (A[mid][index] > A[mid + 1][index] && A[mid][index] > A[mid - 1][index]) {
                    return new ArrayList<>(Arrays.asList(mid, index));
                } else if (A[mid][index] < A[mid - 1][index]) {
                    r2 = mid;
                } else {
                    r1 = mid;
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        //[[1,5,3],[4,10,9],[2,8,7]]
        //[[1,3,2],[4,6,5],[7,9,8],[13,15,14],[10,12,11]]
        int[][] A = {{1,3,2}, {4,6,5}, {7,9,8},{13,15,14},{10,12,11}};
        FindPeakElementII test = new FindPeakElementII();
        test.findPeakII(A);
    }

}
