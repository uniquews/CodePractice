import java.util.*;

/**
 * Created by shuaiwang on 3/6/17.
 */
public class TheSkylineProblem {
//    class Edge {
//        public int x;
//        public int h;
//        public boolean left;
//
//        public Edge(int xIndex, int height, boolean isLeft) {
//            x = xIndex;
//            h = height;
//            left = isLeft;
//        }
//    }
//    public List<int[]> getSkyline(int[][] buildings) {
//        List<Edge> edges = new ArrayList<>();
//        for (int i = 0; i < buildings.length; i++) {
//            Edge leftEdge = new Edge(buildings[i][0], buildings[i][2], true);
//            edges.add(leftEdge);
//            Edge rightEdge = new Edge(buildings[i][1], buildings[i][2], false);
//            edges.add(rightEdge);
//        }
//
//        Collections.sort(edges, new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                if (o1.x < o2.x) {
//                    return Integer.compare(o1.x, o2.x);
//                }
//                if (o1.left && o2.left) {
//                    return Integer.compare(o2.h, o1.h);
//                }
//
//                if (!o1.left && !o2.left) {
//                    return Integer.compare(o1.h, o2.h);
//                }
//                return o1.left ? -1 : 1;
//            }
//        });
//
//
//        List<int[]> result = new ArrayList<>();
//        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { // needs to be the max heap
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o2, o1);
//            }
//        });
//        for (Edge edge :  edges) {
//            if (edge.left) { // if current edge is scanned and it is the left boundary
//                if (pq.isEmpty() || (edge.h > pq.peek())) { // if the height of the outline is going to be changed
//                    int[] current = {edge.x, edge.h};
//                    result.add(current);
//                }
//                pq.add(edge.h); // either way we need to add current line into pq
//            } else {
//                pq.remove(edge.h);
//
//                if (pq.isEmpty() || (edge.h > pq.peek())) { // if the height of the outline is going to be changed
//                    if (pq.isEmpty()) {
//                        int[] current = {edge.x, 0};
//                        result.add(current);
//                    } else {
//                        int[] current = {edge.x, pq.peek()};
//                        result.add(current);
//                    }
//                }
//            }
//        }
//        return result;
//    }
class Node {
    public int x;
    public int h;
    public boolean isLeft;

    public Node(int index, int height, boolean left) {
        x = index;
        h = height;
        isLeft = left;
    }
}
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            int[] cur = buildings[i];
            Node left = new Node(cur[0], cur[2], true);
            Node right = new Node(cur[1], cur[2], false);
            list.add(left);
            list.add(right);
        }

        Collections.sort(list, (a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            } else {
                if (a.isLeft && b.isLeft) {
                    return b.h - a.h;
                } else if (!a.isLeft && !b.isLeft) {
                    return a.h - b.h;
                } else {
                    return a.isLeft ? -1 : 1;
                }
            }
        });

        // 注意这个地方是integer 不是node  因为同样的高度只想放进queue一次  如果放node  add 左边之后  删除的是右边，其实什么也没删除成
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);
            if (cur.isLeft) {
                if (heap.isEmpty() || heap.peek() < cur.h) {
                    int[] outline = {cur.x, cur.h};
                    result.add(outline);
                }
                heap.add(cur.h);
            } else {
                heap.remove(cur.h);
                if (heap.isEmpty()) {
                    int[] outline = {cur.x, 0};
                    result.add(outline);
                } else {
                    if (heap.peek() < cur.h) {
                        int[] outline = {cur.x, heap.peek()};
                        result.add(outline);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] build  = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};

        TheSkylineProblem test = new TheSkylineProblem();
        test.getSkyline(build);
    }
}
