import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 8/3/17.
 */
public class NumberOfConnectedComponentsinAnUndirectedGraph {
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

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }

        for (int i = 0; i < n; i++) {
            if (uf.parent.get(i) == i)
                count++;
        }
        return count;
    }
}
