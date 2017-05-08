import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 5/6/17.
 */
public class ZeroOneMatrix {

    /***
     *
     * 思路：当{i, j}的最短距离被更新的时候，才把{i,j}放进queue
     * 因为所有和{i, j}相连的的点的最短距离都有可能更新
     */
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = cur[0] + x[i];
                int c = cur[1] + y[i];
                if (r < 0 || c < 0 || r == matrix.length || c == matrix[0].length ||
                        result[r][c] <= result[cur[0]][cur[1]] + 1) {
                    continue;
                }
                queue.add(new int[]{r,c});
                result[r][c] = result[cur[0]][cur[1]] + 1;
            }
        }
        return result;
    }
}
