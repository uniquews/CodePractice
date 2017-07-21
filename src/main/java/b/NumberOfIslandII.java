package b;

import utils.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfIslandII {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        int count = 0;
        Map<Integer, Point> sea = new HashMap<>();
        UnionSet unionSet = new UnionSet(n);
        for (Point p : operators) {
            if (sea.containsKey(getIndex(p.x, p.y, n))) {
                res.add(count);
                continue;
            }
            sea.put(getIndex(p.x, p.y, n), p);
            unionSet.add(p);
            count++;
            count = unionWith(sea, unionSet, p, 1, n, m, count);
            count = unionWith(sea, unionSet, p, 2, n, m, count);
            count = unionWith(sea, unionSet, p, 3, n, m, count);
            count = unionWith(sea, unionSet, p, 4, n, m, count);
            res.add(count);
        }
        return res;
    }

    private static int getIndex(int x, int y, int n) {
        return x + y * n;
    }

    private int unionWith(Map<Integer, Point> sea, UnionSet unionSet, Point p, int direction, int n, int m, int count) {
        int x;
        int y;
        switch (direction) {
            case 1:
                x = p.x - 1;
                y = p.y;
                break;
            case 2:
                x = p.x;
                y = p.y - 1;
                break;
            case 3:
                x = p.x + 1;
                y = p.y;
                break;
            case 4:
                x = p.x;
                y = p.y + 1;
                break;
            default:
                return 0;
        }
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return count;
        }
        if (sea.containsKey(getIndex(x, y, n))) {
            Point p2 = sea.get(getIndex(x, y, n));
            if (unionSet.union(p, p2)) {
                count--;
            }
        }
        return count;
    }

    class UnionSet {
        private final int n;
        private final Map<Integer, Integer> map;

        UnionSet(int n) {
            this.n = n;
            this.map = new HashMap<>();
        }

        boolean union(Point p1, Point p2) {
            int parent1 = find(p1);
            int parent2 = find(p2);
            if (parent1 == parent2) {
                return false;
            }
            map.put(parent1, parent2);
            return true;
        }

        private int find(Point p) {
            int ans = getIndex(p.x, p.y, n);
            while (ans != map.get(ans)) {
                ans = map.get(ans);
            }
            int parent = getIndex(p.x, p.y, n);
            while (parent != map.get(parent)) {
                int tmp = map.get(parent);
                map.put(parent, ans);
                parent = tmp;
            }
            return parent;
        }

        void add(Point p) {
            map.put(getIndex(p.x, p.y, n), getIndex(p.x, p.y, n));
        }
    }
}
