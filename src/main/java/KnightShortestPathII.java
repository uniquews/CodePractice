public class KnightShortestPathII {
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];

        if (grid[0][0] == true) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        f[0][0] = 0;

        int[][] op = {{-1, -2}, {1, -2}, {-2,  -1}, {2, -1}};

        for (int j = 0; j < n; j++) {
             for (int i = 0; i < m; i++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (grid[i][j] == true)
                    continue;

                for (int k = 0; k < op.length; k++) {
                    if (i + op[k][0] >= 0 && i + op[k][0] < m && j + op[k][1] >= 0 && j + op[k][1] < n
                            && f[i + op[k][0]][j + op[k][1]] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i + op[k][0]][j + op[k][1]] + 1, f[i][j]);
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        KnightShortestPathII test = new KnightShortestPathII();
        boolean[][] grid = {{false, false, false, false}, {false, false, false, false}, {false, false, false, false}};
        System.out.println(test.shortestPath2(grid));
    }
}
