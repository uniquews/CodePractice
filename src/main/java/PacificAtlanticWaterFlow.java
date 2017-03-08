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

        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return result;
        }

        int[][] map = new int[matrix.length][matrix[0].length];

        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        boolean[][] pacificVisited = new boolean[map.length][map[0].length];
        boolean[][] atlanticVisited = new boolean[map.length][map[0].length];

        for (int i = 0; i < matrix.length; i++) {
            pacificVisited[i][0] = true;
            pacific.add(new int[]{i, 0});

            atlantic.add(new int[]{i, matrix[0].length - 1});
            atlanticVisited[i][matrix[0].length - 1] = true;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            pacific.add(new int[]{0, j});
            pacificVisited[0][j] = true;

            atlantic.add(new int[]{matrix.length - 1, j});
            atlanticVisited[matrix.length - 1][j] = true;
        }


        bfs(pacific, matrix, pacificVisited);

        bfs(atlantic, matrix, atlanticVisited);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void bfs(Queue<int[]> sea, int[][] matrix, boolean[][] visited) {
        while (!sea.isEmpty()) {
            int size = sea.size();
            while (size != 0) {
                int[] current = sea.poll();
                int row = current[0];
                int col = current[1];

                if (row - 1 >= 0 && matrix[row][col] <= matrix[row - 1][col] && !visited[row - 1][col]) {
                    sea.add(new int[]{row - 1, col});
                    visited[row - 1][col] = true;
                }

                if (row + 1 < matrix.length && matrix[row][col] <= matrix[row + 1][col] && !visited[row + 1][col]) {
                    sea.add(new int[]{row + 1, col});
                    visited[row + 1][col] = true;
                }

                if (col - 1 >= 0 && matrix[row][col] <= matrix[row][col - 1] && !visited[row][col - 1]) {
                    sea.add(new int[]{row, col - 1});
                    visited[row][col - 1] = true;
                }

                if (col + 1 < matrix[0].length && matrix[row][col] <= matrix[row][col + 1] && !visited[row][col + 1]) {
                    sea.add(new int[]{row, col + 1});
                    visited[row][col + 1] = true;
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
