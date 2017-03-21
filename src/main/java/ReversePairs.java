import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by shuaiwang on 3/20/17.
 */
public class ReversePairs {

    //方法一，和count smaller number after itself一样，不用线段数但是会超时, 比如input是{1,2,3,4,5}
    // 每次往list最开始插入一个数组，要一直shift 里面的元素
//    public int reversePairs(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        List<Integer> list = new ArrayList<>();
//        int sum = 0;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (list.isEmpty()) {
//                if (nums[i] <= Integer.MAX_VALUE / 2)
//                    list.add(nums[i] * 2);  //第一个数不需要判断
//                else
//                    list.add(Integer.MAX_VALUE);
//            } else {
//                int pos = findLowerBound(list, nums[i]);
//                sum += pos;
//                if (nums[i] <= Integer.MAX_VALUE / 2) {
//                    int afterDouble = findLowerBound(list, 2 * nums[i]);
//                    list.add(afterDouble, 2 * nums[i]);
//                } else {
//                    list.add(Integer.MAX_VALUE);
//                }
//            }
//        }
//        return sum;
//    }
//
//    private int findLowerBound(List<Integer> list, int num) {
//        int start = 0, end = list.size() - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (list.get(mid) >= num) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//        if (list.get(start) >= num) {
//            return start;
//        }
//
//        if (list.get(start) < num && num <= list.get(end)) {
//            return end;
//        }
//
//        if (list.get(end) < num) {
//            return end + 1;
//        }
//
//        return end;
//    }

    public int reversePairs(int[] nums) {

    }

    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        test.reversePairs(nums);
    }
}
