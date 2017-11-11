import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shuaiwang on 8/5/17.
 */
public class ShortestDistanceFromAllBuildings {
//    public int shortestDistance(int[][] grid) {
//        int[][] dis = new int[grid.length][grid[0].length];
//        int[][] numOfReach = new int[grid.length][grid[0].length];
//
//        int numdOfOne = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] != 0)
//                    dis[i][j] = Integer.MAX_VALUE;
//                if (grid[i][j] == 1)
//                    numdOfOne++;
//            }
//        }
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    bfs(grid, dis, i, j, numOfReach);
//                }
//            }
//        }
//
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (numOfReach[i][j] == numdOfOne)
//                    result = Math.min(result, dis[i][j]);
//            }
//        }
//        return result == Integer.MAX_VALUE ? -1 : result;
//    }
//
//    private void bfs(int[][] grid, int dis[][], int i, int j, int[][] numOfReach) {
//        Queue<int[]> q = new LinkedList<>();
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        q.add(new int[]{i, j});
//        visited[i][j] = true;
//        int distance = 0;
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size != 0){
//                int[] current = q.poll();
//                int r = current[0];
//                int c = current[1];
//                if (r - 1 >= 0 && grid[r - 1][c] == 0 && !visited[r - 1][c]) {
//                    dis[r - 1][c] += distance + 1;
//                    q.add(new int[]{r - 1, c});
//                    visited[r - 1][c] = true;
//                    numOfReach[r - 1][c]++;
//                }
//
//                if (r + 1 < grid.length && grid[r + 1][c] == 0 && !visited[r + 1][c]) {
//                    dis[r + 1][c] += distance + 1;
//                    q.add(new int[]{r + 1, c});
//                    visited[r + 1][c] = true;
//                    numOfReach[r + 1][c]++;
//                }
//
//                if (c + 1 < grid[0].length && grid[r][c + 1] == 0 && !visited[r][c + 1]){
//                    dis[r][c + 1] += distance + 1;
//                    q.add(new int[]{r, c + 1});
//                    visited[r][c + 1] = true;
//                    numOfReach[r][c + 1]++;
//                }
//
//                if (c - 1 >= 0 && grid[r][c - 1] == 0 && !visited[r][c - 1]) {
//                    dis[r][c - 1] += distance + 1;
//                    q.add(new int[]{r, c - 1});
//                    visited[r][c - 1] = true;
//                    numOfReach[r][c - 1]++;
//                }
//                size--;
//            }
//
//            distance++;
//        }
//    }

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public int shortestDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        int[][] num = new int[grid.length][grid[0].length];
        int numOfBuilding = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numOfBuilding++;
                    bfs(grid, i, j, dist, num);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (num[i][j] == numOfBuilding) {
                    result = Math.min(result, dist[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void bfs(int[][] grid, int r, int c, int[][] dist, int[][] num) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int step = 1;

        q.offer(new int[]{r, c});
        visited.add(r * grid[0].length + c);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nextR = cur[0] + dx[i];
                    int nextC = cur[1] + dy[i];

                    if (nextR >= 0 && nextC >= 0 && nextR < grid.length && nextC < grid[0].length && !visited.contains(nextR * grid[0].length + nextC) && grid[nextR][nextC] == 0) {
                        dist[nextR][nextC] += step;
                        num[nextR][nextC]++;
                        visited.add(nextR * grid[0].length + nextC);
                        q.offer(new int[]{nextR, nextC});
                    }
                }
            }

            step++;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
        ShortestDistanceFromAllBuildings test = new ShortestDistanceFromAllBuildings();
        System.out.print(test.shortestDistance(grid));

    }
}
