import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int level = 1;

        while (!q.isEmpty()){
            int size = q.size();
            while (size > 0) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];

                    if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = level;
                        q.add(new int[]{x, y});
                    }
                }
                size--;
            }
            level++;
        }
    }


    public static void main(String[] args) {
        int[][] rooms = {{3,-1,0,2},{2,4,1,-1},{1,-1,3,-1},{0,-1,5,7}};
        WallsAndGates test = new WallsAndGates();
        test.wallsAndGates(rooms);
    }
}
