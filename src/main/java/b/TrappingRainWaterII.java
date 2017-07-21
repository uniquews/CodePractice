package b;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by bohan on 7/15/17.
 */
public class TrappingRainWaterII {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Queue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.h));
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Cell left = new Cell(i, 0, heights[i][0]);
            visited[i][0] = true;
            queue.offer(left);
            Cell right = new Cell(i, n - 1, heights[i][n - 1]);
            visited[i][n - 1] = true;
            queue.offer(right);
        }
        for (int j = 1; j < n - 1; j++) {
            Cell up = new Cell(0, j, heights[0][j]);
            visited[0][j] = true;
            queue.offer(up);
            Cell bot = new Cell(m - 1, j, heights[m - 1][j]);
            visited[m - 1][j] = true;
            queue.offer(bot);
        }
        int water = 0;
        while (!queue.isEmpty()) {
            Cell lowest = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = lowest.x + dx[i];
                int y = lowest.y + dy[i];
                if (withinBoundary(m, n, x, y) && !visited[x][y]) {
                    water += Math.max(0, lowest.h - heights[x][y]);
                    Cell newCell = new Cell(x, y, Math.max(lowest.h, heights[x][y]));
                    queue.offer(newCell);
                    visited[x][y] = true;
                }
            }
        }
        return water;
    }

    private boolean withinBoundary(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private class Cell {
        private int x;
        private int y;
        private int h;

        private Cell(int row, int column, int height) {
            x = row;
            y = column;
            h = height;
        }
    }
}
