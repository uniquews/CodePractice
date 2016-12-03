import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 11/23/16.
 */
public class KthSmallestSumInTwoSortedArrays {
    class Node {
        public int val;
        public int indexA;
        public int indexB;

        public Node(int v, int a, int b) {
            val = v;
            indexA = a;
            indexB = b;
        }
    }

    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        Queue<Node> heap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Node start = new Node(A[0] + B[0], 0, 0);
        heap.add(start);
        boolean[][] visited = new boolean[A.length][B.length];

        for (int i = 0; i < k; i++) {
            Node current = heap.poll();
            int posA = current.indexA;
            int posB = current.indexB;

            if (i == k - 1) {
                return current.val;
            }

            if (posA + 1 < A.length) {
                if (!visited[posA + 1][posB]) {
                    Node nextA = new Node(A[posA + 1] + B[posB], posA + 1, posB);
                    heap.add(nextA);
                    visited[posA + 1][posB] = true;
                }
            }

            if (posB + 1 < B.length) {
                if (!visited[posA][posB + 1]) {
                    Node nextB = new Node(A[posA] + B[posB + 1], posA, posB + 1);
                    heap.add(nextB);
                    visited[posA][posB + 1] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestSumInTwoSortedArrays test = new KthSmallestSumInTwoSortedArrays();
        int[] A = {1, 7, 11};
        int[] B = {2, 4, 6};
        System.out.print(test.kthSmallestSum(A, B, 3));
    }
}
