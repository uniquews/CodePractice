import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/19/17.
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        List<Integer> result = new ArrayList<>();
        // i = Math.max(0, k - m) 如果k > m 那么 至少要从num1里取 k - m 这些个数
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            List<Integer> l1 = maxArray(nums1, i);
            List<Integer> l2 = maxArray(nums2, k - i);
            List<Integer> candidate = mergeTwoSortedList(l1, l2);
            if (compareTwoList(candidate, result)) result = candidate;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public boolean compareTwoList(List<Integer> l1, List<Integer> l2) {
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) == l2.get(j)) {
                i++;
                j++;
            } else if (l1.get(i) > l2.get(j)) {
                return true;
            } else {
                return false;
            }
        }
        return i != l1.size();
    }


    // {6,7} {6,0,4}
    public List<Integer> mergeTwoSortedList(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            List<Integer> tmp1 = l1.subList(i, l1.size());
            List<Integer> tmp2 = l2.subList(j, l2.size());
            if (compareTwoList(tmp1, tmp2)) {
                result.add(l1.get(i++));
            } else {
                result.add(l2.get(j++));
            }
        }

        while (i < l1.size()) {
            result.add(l1.get(i++));
        }

        while (j < l2.size()) {
            result.add(l2.get(j++));
        }
        return result;
    }

    public List<Integer> maxArray(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int drop = arr.length - k;
        for (int i = 0; i < arr.length; i++) {
            while (drop > 0 && result.size() > 0 && result.get(result.size() - 1) < arr[i]) {
                result.remove(result.size() - 1);
                drop--;
            }
            result.add(arr[i]);
        }
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        CreateMaximumNumber test = new CreateMaximumNumber();
//        int[] a = {4, 9, 3, 2, 1, 8, 7, 6};
        int[] a = {1,2,3,4};
        int k = 4;
        List<Integer> result = test.maxArray(a, k);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
}
