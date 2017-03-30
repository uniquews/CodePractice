/**
 * Created by shuaiwang on 3/29/17.
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] current, int[] destination, boolean[][] visited) {
        if (current[0] == destination[0] && current[1] == destination[1]) {
            return true;
        }

        if (visited[current[0]][current[1]]) {
            return false;
        }

        visited[current[0]][current[1]] = true;

        // move to left
        int[] nextLeft = moveHelper(maze, current[0], current[1], "left");
        if (dfs(maze, nextLeft, destination, visited)) {
            return true;
        }

        // move to right
        int[] nextRight = moveHelper(maze, current[0], current[1], "right");
        if (dfs(maze, nextRight, destination, visited)) {
            return true;
        }

        // move to up
        int[] nextUp = moveHelper(maze, current[0], current[1], "up");
        if (dfs(maze, nextUp, destination, visited)) {
            return true;
        }

        // move to below
        int[] nextBelow = moveHelper(maze, current[0], current[1], "down");
        return dfs(maze, nextBelow, destination, visited);
    }

    private int[] moveHelper(int[][] maze, int r, int c, String dir) {
        int[] result = new int[2];
        switch (dir) {
            case "left":
                int i = c - 1;
                while (i >= 0 && maze[r][i] != 1) {
                    i--;
                }
                result[0] = r;
                result[1] = i + 1;
                break;
            case "right":
                i = c + 1;
                while (i < maze[0].length && maze[r][i] != 1) {
                    i++;
                }
                result[0] = r;
                result[1] = i - 1;
                break;
            case "up":
                i = r - 1;
                while (i >= 0 && maze[i][c] != 1) {
                    i--;
                }
                result[0] = i + 1;
                result[1] = c;
                break;
            case "down":
                i = r + 1;
                while (i < maze.length && maze[i][c] != 1) {
                    i++;
                }
                result[0] = i - 1;
                result[1] = c;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        //[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] des = {4, 4};
        TheMaze test = new TheMaze();
        System.out.println(test.hasPath(maze, start, des));
    }
}
