import java.util.*;

/**
 * Created by shuaiwang on 3/30/17.
 */

// Dijkstra's
public class TheMazeII {
    class Node {
        public int r;
        public int c;
        public int dist;

        public Node(int i, int j, int d) {
            r = i;
            c = j;
            dist = d;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Node source = new Node(start[0], start[1], 0);
        int[][] length = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                length[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist - o2.dist;
            }
        });
        queue.add(source);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.r == destination[0] && current.c == destination[1]) { //遇到destination 就返回
                return current.dist == Integer.MAX_VALUE ? -1 : current.dist;
            }
            if (length[current.r][current.c] <= current.dist) { // 可能有重复但是没关系，如果value比最小值大就忽略
                continue;
            }
            length[current.r][current.c] = current.dist;

            List<Node> neighbors = getAllNeighbor(maze, current);
            for (int i = 0; i < neighbors.size(); i++) {
                neighbors.get(i).dist += length[current.r][current.c];
                queue.add(neighbors.get(i));
            }
        }
        return -1;
    }

    private List<Node> getAllNeighbor(int[][] maze, Node source) {
        List<Node> result = new ArrayList<>();
        int rIndex = source.r;
        int cIndex = source.c;

        int i = rIndex;
        int distance = -1;
        while (i < maze.length && maze[i][cIndex] != 1) {
            i++;
            distance++;
        }
        Node lowNeighbor = new Node(--i, cIndex, distance);
        result.add(lowNeighbor);

        i = rIndex;
        distance = -1;
        while (i >= 0 && maze[i][cIndex] != 1) {
            i--;
            distance++;
        }
        Node upNeighbor = new Node(++i, cIndex, distance);
        result.add(upNeighbor);

        i = cIndex;
        distance = -1;
        while (i < maze[0].length && maze[rIndex][i] != 1) {
            i++;
            distance++;
        }
        Node rightNeighbor = new Node(rIndex, --i, distance);
        result.add(rightNeighbor);

        i = cIndex;
        distance = -1;
        while (i >= 0 && maze[rIndex][i] != 1) {
            i--;
            distance++;
        }
        Node leftNeighbor = new Node(rIndex, ++i, distance);
        result.add(leftNeighbor);
        return result;
    }
}
