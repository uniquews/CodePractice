import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 4/20/17.
 */
public class KthSmallestElementInASortedMatrix {
    // 思路1， 用大顶堆
//    public int kthSmallest(int[][] matrix, int k) {
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
//            return 0;
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (heap.size() < k || heap.peek() > matrix[i][j]) {
//                    if (heap.size() == k) {
//                        heap.poll();
//                    }
//                    heap.add(matrix[i][j]);
//                }
//            }
//        }
//        return heap.peek();
//    }

    // 二分

    //时间复杂度：O((row + col) * log(max - min)) max是matrix 中最大的数， min是matrix中最小数
//    public int kthSmallest(int[][] matrix, int k) {
//        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1];
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            int count = findTargetPosition(matrix, mid);
//            if (count < k) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return start;
//    }
//
//
//    // matrix中有多少个数字小于等于target
//    public int findTargetPosition(int[][] matrix, int target) {
//        int row = 0, col = matrix[0].length - 1;
//
//        int count = 0;
//        while (row < matrix.length && col >= 0) {
//            if (matrix[row][col] <= target) {
//                row++;
//                count += col + 1;
//            } else {
//                col--;
//            }
//        }
//        return count;
//    }

    class Node {
        public int x;
        public int y;
        public int val;
        public Node(int xx, int yy, int vv) {
            x = xx;
            y = yy;
            val = vv;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        Node start = new Node(0, 0, matrix[0][0]);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        q.add(start);
        visited[0][0] = true;
        int result = 0;

        while (k != 0) {
            Node current = q.poll();
            result = current.val;
            if (current.x + 1 < matrix.length && !visited[current.x + 1][current.y]) {
                visited[current.x + 1][current.y] = true;
                Node next = new Node(current.x + 1, current.y, matrix[current.x + 1][current.y]);
                q.add(next);
            }
            if (current.y + 1 < matrix[0].length && !visited[current.x][current.y + 1]) {
                visited[current.x][current.y + 1] = true;
                Node next = new Node(current.x, current.y + 1, matrix[current.x][current.y + 1]);
                q.add(next);
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{1,3,5}, {6,7,12}, {11,14,14}};
        System.out.println(test.kthSmallest(matrix, 6));
    }
}
