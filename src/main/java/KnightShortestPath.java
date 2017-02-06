import utils.Point;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class KnightShortestPath {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        int[][] move = {{-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(source.x * grid[0].length + source.y);

        int index = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            index++;
            while (size != 0) {
                Point current = queue.poll();
                for (int i = 0; i < move.length; i++) {
                    int row = current.x + move[i][0];
                    int column = current.y + move[i][1];

                    if (row == destination.x && column == destination.y) {
                        return index;
                    }

                    if (row >= 0 && row < grid.length &&
                            column >= 0 && column < grid[0].length &&
                            !grid[row][column] && !visited.contains(row * grid[0].length + column)) {
                        visited.add(row * grid[0].length + column);
                        queue.add(new Point(row, column));
                    }
                }
                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean[][] grid = {{false, false, false}, {false ,false ,false}, {false, false ,false}};
        Point source = new Point(2, 0);
        Point destination = new Point(2,2);

        KnightShortestPath test = new KnightShortestPath();
        test.shortestPath(grid, source, destination);

    }
}
