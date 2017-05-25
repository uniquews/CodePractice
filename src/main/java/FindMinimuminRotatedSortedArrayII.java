/**
 * Created by shuaiwang on 5/24/17.
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] num) {
        // write your code here
        int start = 0, end = num.length - 1;
        while (start + 1 < end) {
            if (num[start] < num[end]) {
                return num[start];
            }

            if (num[start] == num[end]) {
                start++;
            } else {
                int mid = start + (end - start) / 2;
                if (num[start] < num[mid]) {
                    start = mid;
                } else if (num[start] == num[mid]) {
                    start++;
                } else if (num[mid] < num[end]) {
                    end = mid;
                } else if (num[mid] == num[end]) {
                    end--;
                }
            }
        }

        if (num[start] <= num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
}
