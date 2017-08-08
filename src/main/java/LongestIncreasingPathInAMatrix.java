/**
 * Created by shuaiwang on 3/14/17.
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;

        int[][] visited = new int[matrix.length][matrix[0].length];

        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, i, j, visited));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] visited) {
        if (visited[i][j] != 0) {
            return visited[i][j];
        }

        int current = 1;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        for (int k = 0; k < 4; k++) {
            if (i + dx[k] >= 0 && i + dx[k] < matrix.length && j + dy[k] >= 0 && j + dy[k] < matrix[0].length
                    && matrix[i][j] < matrix[i + dx[k]][j + dy[k]]) {
                current = Math.max(current, 1 + dfs(matrix, i + dx[k], j + dy[k], visited));
            }
        }
        visited[i][j] = current;
        return current;
    }
}
