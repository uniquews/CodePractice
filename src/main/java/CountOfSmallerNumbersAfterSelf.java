import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuaiwang on 3/18/17.
 */

/**
 *
 * The java.util.ArrayList.add(int index, E elemen) method inserts the
 * specified element E at the specified position in this list.It shifts the
 * element currently at that position (if any) and any subsequent elements to
 * the right (will add one to their indices).
 * */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, binarySearchInsert(list, nums[i]));
        }
        return result;
    }

    private int binarySearchInsert(List<Integer> list, int num) {
        if (list.size() == 0) {
            list.add(num);
            return 0;
        }
        int start = 0, end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= num) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (list.get(start) >= num) { // input is smaller than any numbers in array
            list.add(start, num);
            return start;
        }

        if (list.get(end) < num) {
            list.add(num);
            return end + 1;
        }

        list.add(end, num);
        return end;
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf test = new CountOfSmallerNumbersAfterSelf();
        int[] nums = {5,7,2,1,2,6,1};
        test.countSmaller(nums);
    }

}
