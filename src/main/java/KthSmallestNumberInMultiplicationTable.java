import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthSmallestNumberInMultiplicationTable {

    // 会TLE
//    class Node {
//        public int x;
//        public int y;
//        public int val;
//
//        public Node(int a, int b, int c) {
//            x = a;
//            y = b;
//            val = c;
//        }
//    }
//    public int findKthNumber(int m, int n, int k) {
//        Queue<Node> q = new PriorityQueue<>((a, b) -> a.val - b.val);
//        Set<Integer> visited = new HashSet<>();
//
//        q.add(new Node(1,1,1));
//        visited.add(0);
//        int result = -1;
//        for (int i = 0; i < k; i++) {
//            Node smallest = q.poll();
//            result = smallest.val;
//            if (smallest.x + 1 <= m && !visited.contains(smallest.x * n + smallest.y - 1)) {
//                Node below = new Node(smallest.x + 1, smallest.y, (smallest.x + 1) * smallest.y);
//                q.add(below);
//                visited.add(smallest.x * n + smallest.y - 1);
//            }
//
//            if (smallest.y + 1 <= n && !visited.contains((smallest.x - 1) * n + smallest.y)) {
//                Node right = new Node(smallest.x, smallest.y + 1, smallest.x * (smallest.y + 1));
//                q.add(right);
//                visited.add((smallest.x - 1) * n + smallest.y);
//            }
//        }
//        return result;
//    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countSmallerOrEqual(m, n, mid);
            if (count < k) {
                low = mid + 1; // So when f(X) returns a value too small, you know X must be larger by at least 1, so low=mid+1 is correct
            } else {
                high = mid; // But when f(X) returns a value too large, X might be perfect (might be an element appearing several times in the table). Conversely, when f(X) returns exactly the right number, X might still be too big (X might be a value that appears zero times in the table).
            }
        }

        /**
         假设此时的low不在table中，那么table中有k个小于low的数，小于low且在table中的那个数一定也有k个小于等于自己的数，
         但是小于low的仅仅可能是count < k的数，矛盾。因此low一定是一个在table中的数。

         */
        return high; // low == high == answer
    }

    //You are looking for the smallest number that has k elements less than or equal to it. And your function f(X) returns the count of elements less than or equal to X.
    private int countSmallerOrEqual(int m, int n, int num) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, num / i); // 5 / 1那么第一列应该有5个数小于等于5  但是行数可能不够5行所以取min
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 2, n = 3, k = 6;
        KthSmallestNumberInMultiplicationTable test = new KthSmallestNumberInMultiplicationTable();
        test.findKthNumber(m, n, k);
    }
}
