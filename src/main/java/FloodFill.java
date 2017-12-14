import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            image[current[0]][current[1]] = newColor;

            for (int i = 0; i < dx.length; i++) {
                int r = current[0] + dx[i];
                int c = current[1] + dy[i];
                if (r >= 0 && c >= 0 && r < image.length && c < image[0].length && !visited[r][c] && image[r][c] == oldColor) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return image;
    }
}
