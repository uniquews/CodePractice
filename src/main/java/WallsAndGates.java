import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                    bfs(rooms, q);
                }
            }
        }
    }

    private void bfs(int[][] rooms, Queue<int[]> q) {
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int dis = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];

                visited[r][c] = true;
                rooms[r][c] = Math.min(rooms[r][c], dis);

                if (r + 1 < rooms.length && rooms[r + 1][c] != 0 && rooms[r + 1][c] != -1 && !visited[r + 1][c]) {
                    q.add(new int[]{r + 1, c});
                }

                if (r - 1 >= 0 && rooms[r - 1][c] != 0 && rooms[r - 1][c] != -1 && !visited[r - 1][c]) {
                    q.add(new int[]{r - 1, c});
                }

                if (c + 1 < rooms[0].length && rooms[r][c + 1] != 0 && rooms[r][c + 1] != -1 && !visited[r][c + 1]) {
                    q.add(new int[]{r, c + 1});
                }

                if (c - 1 >= 0 && rooms[r][c - 1] != 0 && rooms[r][c - 1] != -1 && !visited[r][c - 1]) {
                    q.add(new int[]{r, c - 1});
                }
                size--;
            }
            dis++;
        }
    }


    public static void main(String[] args) {
        int[][] rooms = {{3,-1,0,2},{2,4,1,-1},{1,-1,3,-1},{0,-1,5,7}};
        WallsAndGates test = new WallsAndGates();
        test.wallsAndGates(rooms);
    }
}
