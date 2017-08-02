import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shuaiwang on 3/7/17.
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return result;

        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();

        boolean[][] allPointsInPac = new boolean[matrix.length][matrix[0].length];
        boolean[][] allPointsInAtl = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            pac.add(new int[]{i, 0});
            allPointsInPac[i][0] = true;

            atl.add(new int[]{i, matrix[0].length - 1});
            allPointsInAtl[i][matrix[0].length - 1] = true;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            pac.add(new int[]{0, i});
            allPointsInPac[0][i] = true;

            atl.add(new int[]{matrix.length - 1, i});
            allPointsInAtl[matrix.length - 1][i] = true;
        }


        bfs(matrix, pac, allPointsInPac);
        bfs(matrix, atl, allPointsInAtl);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (allPointsInPac[i][j] && allPointsInAtl[i][j])
                    result.add(new int[]{i, j});
            }
        }
        return result;
    }

    private void bfs(int[][] matrix, Queue<int[]> q, boolean[][] points) {

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] current = q.poll();
                points[current[0]][current[1]] = true;
                for (int i = 0; i < 4; i++) {
                    if (current[0] + dx[i] >= 0 && current[0] + dx[i] < matrix.length && current[1] + dy[i] >= 0
                            && current[1] + dy[i] < matrix[0].length && matrix[current[0]][current[1]] <= matrix[current[0] + dx[i]][current[1] + dy[i]] && !points[current[0] + dx[i]][current[1] + dy[i]]) {
                        q.add(new int[]{current[0] + dx[i], current[1] + dy[i]});
                    }
                }
                size--;
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow test = new PacificAtlanticWaterFlow();
        int[][] matrix = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.print(test.pacificAtlantic(matrix));
    }
}
