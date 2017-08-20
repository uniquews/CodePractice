import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 8/15/17.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int pos = findNum(arr, x);

        List<Integer> result = new ArrayList<>();
        result.add(arr.get(pos));
        k--;

        int left = pos - 1, right = pos + 1;
        while (k > 0) {
            int gap1 = left < 0 ? Integer.MAX_VALUE : x - arr.get(left);
            int gap2 = right == arr.size() ? Integer.MAX_VALUE : arr.get(right) - x;

            if (gap1 <= gap2) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        return arr.subList(left + 1, right);
    }

    private int findNum(List<Integer> arr, int x) {
        int start = 0, end = arr.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == x) {
                return mid;
            } else if (arr.get(mid) < x){
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr.get(start) >= x) {
            return start;
        }

        if (arr.get(start) < x && arr.get(end) >= x) {
            if (Math.abs(arr.get(start) - x) <= Math.abs(arr.get(end) - x)) {
                return start;
            } else {
                return end;
            }
        }

        // arr.get(end) < x
        return end;
    }
}
