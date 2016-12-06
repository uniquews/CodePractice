/**
 * Created by shuaiwang on 7/23/16.
 */
public class TopOccurrenceOfTarget {
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int left = 0, right = 0;

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] == target) {
            left = start;
        } else if (A[end] == target) {
            left = end;
        } else {
            return 0;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[end] == target) {
            right = end;
        } else {
            right = start;
        }

        return right - left + 1;
    }
}
