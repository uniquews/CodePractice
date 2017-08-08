import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class WallsAndGates {
//    public void wallsAndGates(int[][] rooms) {
//        Queue<int[]> q = new LinkedList<>();
//
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[0].length; j++) {
//                if (rooms[i][j] == 0) {
//                    q.add(new int[]{i, j});
//                    bfs(rooms, q);
//                }
//            }
//        }
//    }
//
//    private void bfs(int[][] rooms, Queue<int[]> q) {
//        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
//        int dis = 0;
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size != 0) {
//                int[] current = q.poll();
//                int r = current[0];
//                int c = current[1];
//
//                visited[r][c] = true;
//                rooms[r][c] = Math.min(rooms[r][c], dis);
//
//                if (r + 1 < rooms.length && rooms[r + 1][c] != 0 && rooms[r + 1][c] != -1 && !visited[r + 1][c]) {
//                    q.add(new int[]{r + 1, c});
//                }
//
//                if (r - 1 >= 0 && rooms[r - 1][c] != 0 && rooms[r - 1][c] != -1 && !visited[r - 1][c]) {
//                    q.add(new int[]{r - 1, c});
//                }
//
//                if (c + 1 < rooms[0].length && rooms[r][c + 1] != 0 && rooms[r][c + 1] != -1 && !visited[r][c + 1]) {
//                    q.add(new int[]{r, c + 1});
//                }
//
//                if (c - 1 >= 0 && rooms[r][c - 1] != 0 && rooms[r][c - 1] != -1 && !visited[r][c - 1]) {
//                    q.add(new int[]{r, c - 1});
//                }
//                size--;
//            }
//            dis++;
//        }
//    }

//    public void wallsAndGates(int[][] rooms) {
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[0].length; j++) {
//                if (rooms[i][j] == 0)
//                    bfs(rooms, i, j);
//            }
//        }
//    }
//
//    private void bfs(int[][] rooms, int i, int j) {
//        Queue<int[]> q = new LinkedList<>();
//        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
//        int distance = 0;
//        q.add(new int[]{i, j});
//        visited[i][j] = true;
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//
//            while (size != 0) {
//                int r = q.poll()[0];
//                int c = q.poll()[1];
//
//                if (r - 1 >= 0 && (rooms[r - 1][c] != -1 || rooms[r - 1][c] != 0) && !visited[r - 1][c]) {
//                    rooms[r - 1][c] = Math.min(distance + 1, rooms[r - 1][c]);
//                    visited[r - 1][c] = true;
//                    q.add(new int[]{r - 1, c});
//                }
//
//                if (r + 1 < rooms.length && (rooms[r + 1][c] != -1 || rooms[r + 1][c] != 0) && !visited[r + 1][c]) {
//                    rooms[r + 1][c] = Math.min(distance + 1, rooms[r + 1][c]);
//                    visited[r + 1][c] = true;
//                    q.add(new int[]{r + 1, c});
//                }
//
//                if (c - 1 >= 0 && (rooms[r][c - 1] != -1 || rooms[r][c - 1] != 0) && !visited[r][c - 1]) {
//                    rooms[r][c - 1] = Math.min(distance + 1, rooms[r][c - 1]);
//                    visited[r][c - 1] = true;
//                    q.add(new int[]{r, c - 1});
//                }
//
//                if (c + 1 < rooms[0].length && (rooms[r][c + 1] != -1 || rooms[r][c + 1] != 0) && !visited[r][c + 1]) {
//                    rooms[r][c + 1] = Math.min(distance + 1, rooms[r][c + 1]);
//                    visited[r][c + 1] = true;
//                    q.add(new int[]{r, c + 1});
//                }
//
//                size--;
//            }
//        }
//    }

    //答案更巧妙的方法：
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }


    public static void main(String[] args) {
        int[][] rooms = {{3,-1,0,2},{2,4,1,-1},{1,-1,3,-1},{0,-1,5,7}};
        WallsAndGates test = new WallsAndGates();
        test.wallsAndGates(rooms);
    }
}
