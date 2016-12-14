import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 12/6/16.
 */
public class TrappingRainWaterII {
    class Cell {
        public int x;
        public int y;
        public int h;

        public Cell(int row, int column, int height) {
            x = row;
            y = column;
            h = height;
        }
    }
    public int trapRainWater(int[][] heights) {
        // write your code here

        int count = 0;
        Queue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.h - o2.h;
            }
        });

        boolean[][] visited = new boolean[heights.length][heights[0].length];

        visited[0][0] = true;
        visited[0][heights[0].length - 1] = true;
        visited[heights.length - 1][0] = true;
        visited[heights.length - 1][heights[0].length - 1] = true;

        // top row
        for (int i = 1; i < heights[0].length - 1; i++) {
            Cell c = new Cell(0, i, heights[0][i]);
            queue.add(c);
            visited[0][i] = true;
        }

        // bottom row
        for (int i = 1; i < heights[0].length - 1; i++) {
            Cell c = new Cell(heights.length - 1, i, heights[heights.length - 1][i]);
            queue.add(c);
            visited[heights.length - 1][i] = true;
        }

        // left column
        for (int i = 1; i < heights.length - 1; i++) {
            Cell c = new Cell(i, 0, heights[i][0]);
            queue.add(c);
            visited[i][0] = true;
        }

        // right column
        for (int i = 1; i < heights.length - 1; i++) {
            Cell c = new Cell(i, heights[0].length - 1, heights[i][heights[0].length - 1]);
            queue.add(c);
            visited[i][heights[0].length - 1] = true;
        }

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            // top
            if (current.x - 1 > 0 && !visited[current.x - 1][current.y]) {
                Cell topNode = new Cell(current.x - 1, current.y, heights[current.x - 1][current.y]);
                queue.add(topNode);
                visited[current.x - 1][current.y] = true;
                if (topNode.h < current.h) {
                    count += current.h - topNode.h;
                    topNode.h = current.h;
                }
            }

            // bottom
            if (current.x + 1 < heights.length && !visited[current.x + 1][current.y]) {
                Cell bottomNode = new Cell(current.x + 1, current.y, heights[current.x + 1][current.y]);
                queue.add(bottomNode);
                visited[current.x + 1][current.y] = true;
                if (bottomNode.h < current.h) {
                    count += current.h - bottomNode.h;
                    bottomNode.h = current.h;
                }
            }

            // left
            if (current.y - 1 > 0 && !visited[current.x][current.y - 1]) {
                Cell leftNode = new Cell(current.x, current.y - 1, heights[current.x][current.y - 1]);
                queue.add(leftNode);
                visited[current.x][current.y - 1] = true;
                if (leftNode.h < current.h) {
                    count += current.h - leftNode.h;
                    leftNode.h = current.h;
                }
            }

            // right
            if (current.y + 1 < heights[0].length && !visited[current.x][current.y + 1]) {
                Cell rightNode = new Cell(current.x, current.y + 1, heights[current.x][current.y + 1]);
                queue.add(rightNode);
                visited[current.x][current.y + 1] = true;
                if (rightNode.h < current.h) {
                    count += current.h - rightNode.h;
                    rightNode.h = current.h;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        [[12,13,0,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]
        //[[19,13,63,93,76],[68,8,37,70,97],[80,38,98,10,52],[23,61,5,20,54],[79,88,51,40,26],[10,77,24,34,29],[87,59,50,3,37],[25,0,87,77,70],[72,47,98,41,48]]
//        int[][] heights = {{12,13,0,12}, {13,4,13,12}, {13,8,10,12}, {12,13,12,12}, {13,13,13,13}};
        int[][] heights = {{19,13,63,93,76}, {68,8,37,70,97}, {80,38,98,10,52}, {23,61,5,20,54}, {79,88,51,40,26}, {10,77,24,34,29}, {87,59,50,3,37}, {25,0,87,77,70}, {72,47,98,41,48}};
        TrappingRainWaterII test = new TrappingRainWaterII();
        System.out.print(test.trapRainWater(heights));
    }
}
