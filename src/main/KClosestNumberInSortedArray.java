package main;

/**
 * Created by shuaiwang on 7/24/16.
 */
public class KClosestNumberInSortedArray {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int []result = new int[k];
        if (A == null || A.length == 0)
        {
            return result;
        }

        int start = 0, end = A.length - 1, position = -1;
        while (start + 1 < end)
        {
            int mid = start + (end - start) / 2;

            if (A[mid] == target)
            {
                position = mid;
                break;
            }
            else if (A[mid] < target)
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
        }
        if (position == -1)
        {
            position = Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;
        }

        int p = position, q = position + 1;
        int i = 0;
        while (i < k)
        {
            if (p < 0)
            {
                result[i] = A[q];
                q++;
            }
            else if (q > A.length - 1)
            {
                result[i] = A[p];
                p--;
            }
            else
            {
                if (Math.abs(A[p] - target) <= Math.abs(A[q] - target))
                {
                    result[i] = A[p];
                    p--;
                }
                else
                {
                    result[i] = A[q];
                    q++;
                }
            }
            i++;
        }
        return result;
    }

}
