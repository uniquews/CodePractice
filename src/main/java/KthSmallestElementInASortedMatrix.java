import java.util.PriorityQueue;

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
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = findTargetPosition(matrix, mid);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }


    // matrix中有多少个数字小于等于target
    public int findTargetPosition(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        int count = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] <= target) {
                row++;
                count += col + 1;
            } else {
                col--;
            }
        }
        return count;
    }
}
