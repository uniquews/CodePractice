/**
 * Created by shuaiwang on 3/29/17.
 */
public class TheMaze {
//    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        boolean[][] visited = new boolean[maze.length][maze[0].length];
//        return dfs(maze, start, destination, visited);
//    }
//
//
//    // 不需要reset visited， 这样才不会TLE 原因是因为如果maze[i][j] 可以到destination，那么会一路popup返回结果为true
//    // 如果maze[i][j] 不能到destination，一直mark成visited，这样以后遍历到它的时候，就直接返回false
//    private boolean dfs(int[][] maze, int[] current, int[] destination, boolean[][] visited) {
//        if (current[0] == destination[0] && current[1] == destination[1]) {
//            return true;
//        }
//
//        if (visited[current[0]][current[1]]) {
//            return false;
//        }
//
//        visited[current[0]][current[1]] = true;
//
//        // move to left
//        int[] nextLeft = moveHelper(maze, current[0], current[1], true, false);
//        boolean isDesInLeft = dfs(maze, nextLeft, destination, visited);
//        if (isDesInLeft) {
//            return true;
//        }
//
//        // move to right
//        int[] nextRight = moveHelper(maze, current[0], current[1], true, true);
//        boolean isDesInRight = dfs(maze, nextRight, destination, visited);
//        if (isDesInRight) {
//            return true;
//        }
//
//        // move to up
//        int[] nextUp = moveHelper(maze, current[0], current[1], false, true);
//        boolean isDesInUp = dfs(maze, nextUp, destination, visited);
//        if (isDesInUp)
//            return true;
//
//        // move to below
//        int[] nextBelow = moveHelper(maze, current[0], current[1],  false, false);
//        boolean isDesInBelow = dfs(maze, nextBelow, destination, visited);
//        if (isDesInBelow) {
//            return true;
//        }
//
//        return false;
//    }
//
//    private int[] moveHelper(int[][] maze, int r, int c, boolean horizon, boolean increase) {
//        int[] result = new int[2];
//        if (horizon && increase) {
//            int i = c + 1;
//            while (i < maze[0].length && maze[r][i] != 1) {
//                i++;
//            }
//            result[0] = r;
//            result[1] = i - 1;
//        } else if (horizon && !increase) {
//            int i = c - 1;
//            while (i >= 0 && maze[r][i] != 1) {
//                i--;
//            }
//            result[0] = r;
//            result[1] = i + 1;
//        } else if (!horizon && increase) {
//            int i = r + 1;
//            while (i < maze.length && maze[i][c] != 1) {
//                i++;
//            }
//            result[0] = i - 1;
//            result[1] = c;
//        } else {
//            int i = r - 1;
//            while (i >= 0 && maze[i][c] != 1) {
//                i--;
//            }
//            result[0] = i + 1;
//            result[1] = c;
//        }
//        return result;
//    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] current, int[] destination, boolean[][] visited) {
        if (current[0] == destination[0] && current[1] == destination[1]) {
            return true;
        }

        if (visited[current[0]][current[1]])
            return false;

        int r = current[0];
        int c = current[1];
        visited[r][c] = true;

        if (r - 1 >= 0 && maze[r - 1][c] == 0) {
            int[] next = move(maze, r, c, 1);
            if (dfs(maze, next, destination, visited))
                return true;
        }
        if (r + 1 < maze.length && maze[r + 1][c] == 0) {
            int[] next = move(maze, r, c, 2);
            if (dfs(maze, next, destination, visited))
                return true;
        }
        if (c - 1 >= 0 && maze[r][c - 1] == 0) {
            int[] next = move(maze, r, c, 3);
            if (dfs(maze, next, destination, visited))
                return true;
        }
        if (c + 1 < maze[0].length && maze[r][c + 1] == 0) {
            int[] next = move(maze, r, c, 4);
            if (dfs(maze, next, destination, visited))
                return true;
        }
        return false;
    }

    private int[] move(int[][] maze, int r, int c, int dir) {
        int[] next = new int[2];
        if (dir == 1) {
            int newR = r - 1;
            while (newR >= 0 && maze[newR][c] == 0) {
                newR--;
            }
            next[0] = newR + 1;
            next[1] = c;
            return next;
        } else if (dir == 2) {
            int newR = r + 1;
            while (newR < maze.length && maze[newR][c] == 0) {
                newR++;
            }
            next[0] = newR - 1;
            next[1] = c;
        } else if (dir == 3) {
            int newC = c - 1;
            while (newC >= 0 && maze[r][newC] == 0) {
                newC--;
            }
            next[0] = r;
            next[1] = newC + 1;
        } else {
            int newC = c + 1;
            while (newC < maze[0].length && maze[r][newC] == 0) {
                newC++;
            }
            next[0] = r;
            next[1] = newC - 1;
        }
        return next;
    }

    public static void main(String[] args) {
        //[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] des = {4, 4};
        TheMaze test = new TheMaze();
        System.out.println(test.hasPath(maze, start, des));
    }
}
