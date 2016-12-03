import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 11/22/16.
 */
public class KthSmallestNumberinSortedMatrix {
    class Node {
        public int val;
        public int row;
        public int column;

        public Node(int v, int r, int c) {
            val = v;
            row = r;
            column = c;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Node> heap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val > o2.val)
                    return 1;
                else
                    return 0;
            }
        });

        Node start = new Node(matrix[0][0], 0, 0);
        heap.add(start);
        visited[0][0] = true;

        for (int i = 0; i < k; i++) {
            Node current = heap.poll();
            int val = current.val;
            int row = current.row;
            int column = current.column;

            if (i == k - 1) {
                return val;
            }

            if (row < matrix.length - 1) {
                if (!visited[row + 1][column]) {
                    Node nextBelow = new Node(matrix[row + 1][column], row + 1, column);
                    heap.add(nextBelow);
                    visited[row + 1][column] = true;
                }

            }

            if (column < matrix[row].length - 1) {
                if (!visited[row][column + 1]) {
                    Node nextRight = new Node(matrix[row][column + 1], row, column + 1);
                    heap.add(nextRight);
                    visited[row][column + 1] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestNumberinSortedMatrix test = new KthSmallestNumberinSortedMatrix();
        int[][] matrix = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}};
        System.out.print(test.kthSmallest(matrix, 19));
    }
}
