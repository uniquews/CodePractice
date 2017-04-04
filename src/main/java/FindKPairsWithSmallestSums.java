import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 4/3/17.
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return result;

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        for (int i = 0; i < nums1.length; i++) { //相当于初始化每一行的第一列
            heap.add(new int[]{i, 0, nums1[i] + nums2[0]});
        }

        while (k > 0 && heap.size() > 0) {
            int[] current = heap.poll();
            result.add(new int[]{nums1[current[0]], nums2[current[1]]});
            int nextColumn = current[1] + 1;
            if (nextColumn != nums2.length) { //如果这行上面没有数字了，这次就不往heap里面添加，heap size变为k - 1
                heap.add(new int[]{current[0], nextColumn, nums1[current[0]] + nums2[nextColumn]});
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums test = new FindKPairsWithSmallestSums();
        int[] nums1 = {1,7,11};
        int[] num2 = {2,4,6};
        int k = 3;
        test.kSmallestPairs(nums1, num2, k);
    }
}
