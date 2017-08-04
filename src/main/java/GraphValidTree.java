import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 12/2/16.
 */
public class GraphValidTree {
//    class UnionFind {
//        private HashMap<Integer, Integer> parentMap;
//
//        public UnionFind(int n) {
//            parentMap = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                parentMap.put(i, i);
//            }
//        }
//
//        public int find(int input) {
//            int parent = parentMap.get(input);
//            while (parent != parentMap.get(parent)) {
//                parent = parentMap.get(parent);
//            }
//
//            int next = parentMap.get(input);
//            while (next != parent) {
//                int tmp = parentMap.get(next);
//                parentMap.put(next, parent);
//                next = tmp;
//            }
//            return parent;
//        }
//
//        public boolean union(int a, int b) {
//            int aParent = find(a);
//            int bParent = find(b);
//            if (aParent == bParent) {
//                return false;
//            }
//
//            parentMap.put(bParent, aParent);
//            return true;
//        }
//    }
//
//    public boolean validTree(int n, int[][] edges) {
//        // Write your code here
//        UnionFind uf = new UnionFind(n);
//
//        for (int i = 0; i < edges.length; i++) {
//            if (!uf.union(edges[i][0], edges[i][1]))
//                return false;
//        }
//        return n == edges.length + 1;
//    }

    class UnionFind {
        public Map<Integer, Integer> parent;

        public UnionFind(int n) {
            parent = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parent.put(i, i);
            }
        }

        public int find(int c) {
            if (parent.get(c) == c) {
                return c;
            }

            int p = parent.get(c);
            int root = find(p);
            parent.put(c, root);
            return root;
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return false;
            }
            parent.put(pa, pb);
            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1]))
                return false;
        }

        int root = 0;
        for (int i = 0; i < n; i++) {
            if (uf.parent.get(i) == i) {
                root++;
            }
        }
        return root == 1;
    }
}
