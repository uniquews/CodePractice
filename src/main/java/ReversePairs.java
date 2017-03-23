import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by shuaiwang on 3/20/17.
 */

// https://discuss.leetcode.com/topic/79227/general-principles-behind-problems-similar-to-reverse-pairs
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

    // 方法二： 分治
    public int reversePairs(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] num, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int numOfPairsLeft = divideAndConquer(num, left, mid);
        int numOfPairsRight = divideAndConquer(num, mid + 1, right);

        int result = 0;
        int i = left, j = mid + 1;
        while (i <= mid) {
            while (j <= right && num[i] > 2L * num[j]) {
                j++;
            }
            result += j - mid - 1;
            i++;
        }

        i = left;
        j = mid + 1;
        int index = 0;
        int[] merge = new int[right - left + 1];
        while (i <= mid || j <= right) {
            if (i > mid) {
                merge[index++] = num[j++];
            } else if (j > right) {
                merge[index++] = num[i++];
            } else {
                if (num[i] > num[j]) {
                    merge[index++] = num[j++];
                } else {
                    merge[index++] = num[i++];
                }
            }
        }

        System.arraycopy(merge, 0, num, left, merge.length);
        return numOfPairsLeft + numOfPairsRight + result;
    }


    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();
        int[] nums = {1,3,2,3,1};
        test.reversePairs(nums);
        int a = 6;
        a += a & -a;
        System.out.println(a);
    }
}
