import java.util.*;

/**
 * Created by shuaiwang on 2/6/17.
 */
public class BuildPostOffice {
    public int shortestDistance(int[][] grid) {
        // Write your code here

        // Find xMedian and yMedian
        List<Integer> indexX = new ArrayList<>();
        List<Integer> indexY = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    indexX.add(i);
                    indexY.add(j);
                }
            }
        }

        List<Integer> originIndexY = new ArrayList<>(indexY);
        Collections.sort(indexY);
        int medianX = getMedian(indexX);
        int medianY = getMedian(indexY);

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {medianX, medianY});
        while (!queue.isEmpty()) {
            int size = queue.size();
            int result = Integer.MAX_VALUE;

            while (size != 0) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (grid[x][y] == 0) {
                    int distance = getTotalDistance(current[0], current[1], indexX, originIndexY);
                    result = Math.min(distance, result);
                }

                for (int i = 0; i < dx.length; i++) {
                    queue.add(new int[]{x + dx[i], y + dy[i]});
                }
                size--;
            }
            if (result != Integer.MAX_VALUE) {
                return result;
            }
        }
        return -1;
    }

    private int getTotalDistance(int x, int y, List<Integer> indexX, List<Integer> indexY) {
        int result = 0;
        for (int i = 0; i < indexX.size(); i++) {
            result += Math.abs(x - indexX.get(i)) + Math.abs(y - indexY.get(i));
        }
        return result;
    }

    private int getMedian(List<Integer> list) {
        int median = list.get(list.size() / 2);
        if (list.size() % 2 == 0) {
            return (median + list.get(list.size() / 2 - 1)) / 2;
        } else {
            return median;
        }
    }


    public static void main(String[] args) {
//        int[][] input = {{0, 1, 0, 0}, {1, 0, 1, 1}, {1, 0, 1, 1}};
        int[][] input = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        BuildPostOffice test = new BuildPostOffice();
        test.shortestDistance(input);
    }
}
