import java.util.*;

/**
 * Created by shuaiwang on 3/30/17.
 */

// Dijkstra's
public class TheMazeII {
//    class Node {
//        public int r;
//        public int c;
//        public int dist;
//
//        public Node(int i, int j, int d) {
//            r = i;
//            c = j;
//            dist = d;
//        }
//    }
//    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//        Node source = new Node(start[0], start[1], 0);
//        int[][] length = new int[maze.length][maze[0].length];
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[0].length; j++) {
//                length[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.dist - o2.dist;
//            }
//        });
//        queue.add(source);
//
//        while (!queue.isEmpty()) {
//            Node current = queue.poll();
//            if (current.r == destination[0] && current.c == destination[1]) { //遇到destination 就返回
//                return current.dist == Integer.MAX_VALUE ? -1 : current.dist;
//            }
//            if (length[current.r][current.c] <= current.dist) { // 可能有重复但是没关系，如果value比最小值大就忽略
//                continue;
//            }
//            length[current.r][current.c] = current.dist;
//
//            List<Node> neighbors = getAllNeighbor(maze, current);
//            for (int i = 0; i < neighbors.size(); i++) {
//                neighbors.get(i).dist += length[current.r][current.c];
//                queue.add(neighbors.get(i));
//            }
//        }
//        return -1;
//    }
//
//    private List<Node> getAllNeighbor(int[][] maze, Node source) {
//        List<Node> result = new ArrayList<>();
//        int rIndex = source.r;
//        int cIndex = source.c;
//
//        int i = rIndex;
//        int distance = -1;
//        while (i < maze.length && maze[i][cIndex] != 1) {
//            i++;
//            distance++;
//        }
//        Node lowNeighbor = new Node(--i, cIndex, distance);
//        result.add(lowNeighbor);
//
//        i = rIndex;
//        distance = -1;
//        while (i >= 0 && maze[i][cIndex] != 1) {
//            i--;
//            distance++;
//        }
//        Node upNeighbor = new Node(++i, cIndex, distance);
//        result.add(upNeighbor);
//
//        i = cIndex;
//        distance = -1;
//        while (i < maze[0].length && maze[rIndex][i] != 1) {
//            i++;
//            distance++;
//        }
//        Node rightNeighbor = new Node(rIndex, --i, distance);
//        result.add(rightNeighbor);
//
//        i = cIndex;
//        distance = -1;
//        while (i >= 0 && maze[rIndex][i] != 1) {
//            i--;
//            distance++;
//        }
//        Node leftNeighbor = new Node(rIndex, ++i, distance);
//        result.add(leftNeighbor);
//        return result;
//    }

//    class Node {
//        public int x;
//        public int y;
//        public int dist;
//
//        public Node(int xx, int yy, int dd) {
//            x = xx;
//            y = yy;
//            dist = dd;
//        }
//    }
//
//    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//        int[][] length = new int[maze.length][maze[0].length];
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[0].length; j++) {
//                length[i][j] = Integer.MAX_VALUE;
//            }
//        }
//
//        Node s = new Node(start[0], start[1], 0);
//        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
//        q.add(s);
//
//        while (!q.isEmpty()) {
//            Node current = q.poll(); // 每个坐标被第一次poll出来的时候  是到它的最短路径
//            int r = current.x;
//            int c = current.y;
//            if (r == destination[0] && c == destination[1]) {
//                return current.dist;
//            }
//
//            if (length[r][c] <= current.dist) // current这个点的dist曾经被poll过
//                continue;
//
//            length[r][c] = current.dist;
//            if (r - 1 >= 0 && maze[r - 1][c] == 0 ) {
//                Node up = getNeighbor(maze, r, c, 1);
//                up.dist += current.dist;
//                if (up.dist < length[up.x][up.y]);
//                    q.add(up);
//            }
//            if (r + 1 < maze.length && maze[r + 1][c] == 0) {
//                Node down = getNeighbor(maze, r, c, 2);
//                down.dist += current.dist;
//                if (down.dist < length[down.x][down.y])
//                    q.add(down);
//            }
//            if (c - 1 >= 0 && maze[r][c - 1] == 0) {
//                Node left = getNeighbor(maze, r, c, 3);
//                left.dist += current.dist;
//                if (left.dist < length[left.x][left.y])
//                    q.add(left);
//            }
//            if (c + 1 < maze[0].length && maze[r][c + 1] == 0) {
//                Node right = getNeighbor(maze, r, c, 4);
//                right.dist += current.dist;
//                if (right.dist < length[right.x][right.y])
//                    q.add(right);
//            }
//        }
//        return -1;
//    }
//
//    private Node getNeighbor(int[][] maze, int r, int c, int dir) {
//        Node next;
//        if (dir == 1) {
//            int newR = r - 1;
//            int step = 0;
//            while (newR >= 0 && maze[newR][c] == 0) {
//                newR--;
//                step++;
//            }
//            next = new Node(newR + 1, c, step);
//        } else if (dir == 2) {
//            int newR = r + 1;
//            int step = 0;
//            while (newR < maze.length && maze[newR][c] == 0) {
//                newR++;
//                step++;
//            }
//            next = new Node(newR - 1, c, step);
//        } else if (dir == 3) {
//            int newC = c - 1;
//            int step = 0;
//            while (newC >= 0 && maze[r][newC] == 0) {
//                newC--;
//                step++;
//            }
//            next = new Node(r, newC + 1, step);
//        } else {
//            int newC = c + 1;
//            int step = 0;
//            while (newC < maze[0].length && maze[r][newC] == 0) {
//                newC++;
//                step++;
//            }
//            next = new Node(r, newC - 1, step);
//        }
//        return next;
//    }

    class Node {
        int x;
        int y;
        int d;
        public Node(int xx, int yy, int dd) {
            x = xx;
            y = yy;
            d = dd;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.d - b.d);
        int[][] dist = new int[maze.length][maze[0].length];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Node source = new Node(start[0], start[1], 0);
        dist[start[0]][start[1]] = 0;
        q.add(source);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return dist[cur.x][cur.y];
            }

            for (int i = 0; i < direct.length; i ++) {
                Node move = helper(maze, cur, direct[i]);
                if (move.d < dist[move.x][move.y]) {
                    dist[move.x][move.y] = move.d;
                    q.add(move);
                }
            }
        }
        return -1;
    }

    private Node helper(int[][] maze, Node cur, int[] dir) {
        int x = cur.x;
        int y = cur.y;
        int d = cur.d;

        while (x + dir[0] >= 0 && x + dir[0] < maze.length && y + dir[1] >= 0
                && y + dir[1] < maze[0].length && maze[x + dir[0]][y + dir[1]] == 0) {
            x += dir[0];
            y += dir[1];
            d += 1;
        }
        return new Node(x, y, d);
    }

    public static void main(String[] args) {
        //[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] des = {4, 4};
        TheMazeII test = new TheMazeII();
        System.out.println(test.shortestDistance(maze, start, des));
    }
}

