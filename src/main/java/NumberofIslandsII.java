import utils.Point;

import java.util.*;

/**
 * Created by shuaiwang on 12/4/16.
 */
public class NumberofIslandsII {
//    private HashMap<Integer, Integer> parentMap = new HashMap<>();
//
//    public boolean union(int a, int b) {
//        int aParent = find(a);
//        int bParent = find(b);
//
//        if (aParent != bParent) {
//            parentMap.put(aParent, bParent);
//            return true;
//        }
//        return false;
//    }
//
//    public int find(int a) {
//        if (parentMap.get(a) == a) {
//            return a;
//        }
//
//        int parent = parentMap.get(a);
//        int rootParent = find(parent);
//        parentMap.put(a, rootParent);
//        return rootParent;
//    }
//
//    public List<Integer> numIslands2(int m, int n, int[][] positions) {
//        // Write your code here
//        List<Integer> result = new ArrayList<>();
//        if (positions == null)
//            return result;
//
//        HashSet<Integer> points = new HashSet<>();
//        int count = 0;
//
//        for (int i = 0; i < positions.length; i++) {
//            int row = positions[i][0];
//            int column = positions[i][1];
//            int position = row * n + column;
//            points.add(position);
//            parentMap.put(position, position);
//            count++;
//
//            int upper = (row - 1) * n + column;
//            if (row - 1 >= 0 && points.contains(upper)) {
//                if (union(position, upper))
//                    count--;
//            }
//
//            int left = row * n + (column - 1);
//            if (column - 1 >= 0 && points.contains(left)) {
//                if (union(position, left))
//                    count--;
//            }
//
//            int right = row * n + (column + 1);
//            if (column + 1 < n && points.contains(right)) {
//                if (union(position, right))
//                    count--;
//            }
//
//            int lower = (row + 1) * n + column;
//            if (row + 1 < m && points.contains(lower)) {
//                if (union(position, lower))
//                    count--;
//            }
//            result.add(count);
//        }
//        return result;
//    }

    class UnionFind {
        public Map<Integer, Integer> parentMap = new HashMap<>();

        public int find(int a) {
            int parent = parentMap.get(a);
            if (parent == a)
                return parent;

            int ancestor = find(parent);
            parentMap.put(a, ancestor);
            return ancestor;
        }

        public boolean union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);
            if (parentOfA == parentOfB) {
                return false;
            }
            parentMap.put(parentOfA, parentOfB);
            return true;
        }
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        UnionFind uf = new UnionFind();
        int count = 0;
        List<Integer> result = new ArrayList<>();
        if (operators == null || operators.length == 0)
            return result;
        for (int i = 0; i < operators.length; i++) {
            Point cur = operators[i];
            int r = cur.x;
            int c = cur.y;
            int num = r * m + c;
            if (!uf.parentMap.containsKey(num))
                count++;
            uf.parentMap.put(num, num);

            if (r + 1 < n && uf.parentMap.containsKey((r + 1) * m + c)) {
                if (uf.union(num, (r + 1) * m + c))
                    count--;
            }

            if (r - 1 >= 0 && uf.parentMap.containsKey((r - 1) * m + c)) {
                if (uf.union(num, (r - 1) * m + c))
                    count--;
            }

            if (c + 1 < m && uf.parentMap.containsKey(r * m + c + 1)) {
                if (uf.union(num, (r * m + c + 1)))
                    count--;
            }

            if (c - 1 >= 0 && uf.parentMap.containsKey(r * m + c - 1)) {
                if (uf.union(num, (r * m + c - 1)))
                    count--;
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
//        2, 2, [[0,0],[1,1],[1,0],[0,1]]
        // 8, 14, [[0,9],[5,4],[0,12],[6,9],[6,5]
        // [[1,1],[1,2],[1,3],[1,4]]
        int n = 4;
        int m = 5;
        Point a = new Point(1, 1);
        Point b = new Point(1, 2);
        Point c = new Point(1, 3);
        Point d = new Point(1, 4);
//        Point e = new Point(6,5);
//
//        Point[] points = {a, b, c, d};
//        NumberofIslandsII test = new NumberofIslandsII();
//        System.out.print(test.numIslands2(n, m, points));
    }
}
