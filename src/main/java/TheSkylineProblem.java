import java.util.*;

/**
 * Created by shuaiwang on 3/6/17.
 */
public class TheSkylineProblem {
    class Edge {
        public int x;
        public int h;
        public boolean left;

        public Edge(int xIndex, int height, boolean isLeft) {
            x = xIndex;
            h = height;
            left = isLeft;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            Edge leftEdge = new Edge(buildings[i][0], buildings[i][2], true);
            edges.add(leftEdge);
            Edge rightEdge = new Edge(buildings[i][1], buildings[i][2], false);
            edges.add(rightEdge);
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.x < o2.x) {
                    return Integer.compare(o1.x, o2.x);
                }
                if (o1.left && o2.left) {
                    return Integer.compare(o2.h, o1.h);
                }

                if (!o1.left && !o2.left) {
                    return Integer.compare(o1.h, o2.h);
                }
                return o1.left ? -1 : 1;
            }
        });


        List<int[]> result = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { // needs to be the max heap
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (Edge edge :  edges) {
            if (edge.left) { // if current edge is scanned and it is the left boundary
                if (pq.isEmpty() || (edge.h > pq.peek())) { // if the height of the outline is going to be changed
                    int[] current = {edge.x, edge.h};
                    result.add(current);
                }
                pq.add(edge.h); // either way we need to add current line into pq
            } else {
                pq.remove(edge.h);

                if (pq.isEmpty() || (edge.h > pq.peek())) { // if the height of the outline is going to be changed
                    if (pq.isEmpty()) {
                        int[] current = {edge.x, 0};
                        result.add(current);
                    } else {
                        int[] current = {edge.x, pq.peek()};
                        result.add(current);
                    }
                }
            }
        }
        return result;
    }


}
