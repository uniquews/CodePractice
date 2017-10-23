import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 4/3/17.
 */
public class FindKPairsWithSmallestSums {
//    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<int[]> result = new ArrayList<>();
//        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
//            return result;
//
//        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
//        for (int i = 0; i < nums1.length; i++) { //相当于初始化每一行的第一列
//            heap.add(new int[]{i, 0, nums1[i] + nums2[0]});
//        }
//
//        while (k > 0 && heap.size() > 0) {
//            int[] current = heap.poll();
//            result.add(new int[]{nums1[current[0]], nums2[current[1]]});
//            int nextColumn = current[1] + 1;
//            if (nextColumn != nums2.length) { //如果这行上面没有数字了，这次就不往heap里面添加，heap size变为k - 1
//                heap.add(new int[]{current[0], nextColumn, nums1[current[0]] + nums2[nextColumn]});
//            }
//            k--;
//        }
//        return result;
//    }

//    class Node {
//        public int i;
//        public int j;
//        public int value;
//        public Node(int ii, int jj, int vv) {
//            i = ii;
//            j = jj;
//            value = vv;
//        }
//    }
//    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<int[]> result = new ArrayList<>();
//        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
//            return result;
//        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
//        boolean[][] visited = new boolean[nums1.length][nums2.length];
//        Node start = new Node(0, 0, nums1[0] + nums2[0]);
//        q.add(start);
//        visited[0][0] = true;
//
//        while (k != 0 && !q.isEmpty()) {
//            Node current = q.poll();
//            result.add(new int[]{nums1[current.i], nums2[current.j]});
//            if (current.i + 1 < nums1.length && !visited[current.i + 1][current.j]) {
//                Node next1 = new Node(current.i + 1, current.j, nums1[current.i + 1] + nums2[current.j]);
//                visited[current.i + 1][current.j] = true;
//                q.add(next1);
//            }
//
//            if (current.j + 1 < nums2.length && !visited[current.i][current.j + 1]) {
//                Node next2 = new Node(current.i, current.j + 1, nums1[current.i] + nums2[current.j + 1]);
//                visited[current.i][current.j + 1] = true;
//                q.add(next2);
//            }
//            k--;
//        }
//        return result;
//    }

    //  高端做法
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> getValue(nums1, nums2, a[0], a[1]) - getValue(nums1, nums2, b[0], b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            q.offer(new int[]{i, 0});
        }

        while (k > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            result.add(new int[]{nums1[cur[0]], nums2[cur[1]]});
            k--;
            if (cur[1] + 1 == nums2.length) {
                continue;
            }
            q.offer(new int[]{cur[0], cur[1] + 1});
        }
        return result;
    }

    private int getValue(int[] nums1, int[] nums2, int i, int j) {
        return nums1[i] + nums2[j];
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums test = new FindKPairsWithSmallestSums();
        int[] nums1 = {1,1,1};
        int[] num2 = {1,2,3};
        int k = 10;
        test.kSmallestPairs(nums1, num2, k);
    }
}
