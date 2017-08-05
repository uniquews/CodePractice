import java.util.*;

/**
 * Created by shuaiwang on 5/3/17.
 */
public class MinimumHeightTrees {
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        HashMap<Integer, Set<Integer>> tree = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//        if (edges.length == 0) {
//            result.add(0);
//            return result;
//        }
//        for (int[] edge : edges) {
//            if (!tree.containsKey(edge[0])) {
//                tree.put(edge[0], new HashSet<>(Arrays.asList(edge[1])));
//            } else {
//                tree.get(edge[0]).add(edge[1]);
//            }
//            if (!tree.containsKey(edge[1])) {
//                tree.put(edge[1], new HashSet<>(Arrays.asList(edge[0])));
//            } else {
//                tree.get(edge[1]).add(edge[0]);
//            }
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (Integer key : tree.keySet()) {
//            if (tree.get(key).size() == 1) {
//                queue.add(key);
//            }
//        }
//
//        int visited = n;
//        while (visited > 2) {
//            visited -= queue.size();
//            Queue<Integer> nextLevel = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                Integer current = queue.poll();
//                Integer neighbor = tree.get(current).iterator().next();
//                tree.get(neighbor).remove(current);
//                if (tree.get(neighbor).size() == 1) {
//                    nextLevel.add(neighbor);
//                }
//            }
//            queue = nextLevel;
//        }
//        result.addAll(queue);
//        return result;
//    }


    // 这道题 其实是拓扑排序，n > 2 是关键。。。
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(Arrays.asList(0));
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            Set<Integer> l1 = graph.getOrDefault(from, new HashSet<>());
            l1.add(to);
            graph.put(from, l1);

            Set<Integer> l2 = graph.getOrDefault(to, new HashSet<>());
            l2.add(from);
            graph.put(to, l2);
        }

        List<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                q.add(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            while (size != 0) {
                int current = q.poll();
                for (int to : graph.get(current)) {
                    graph.get(to).remove(current);
                    if (graph.get(to).size() == 1) {
                        q.add(to);
                    }
                }
                n--;
                size--;
            }
        }

        result.addAll(q);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] a = {{1,0}, {1, 2}, {1, 3}};
        MinimumHeightTrees test = new MinimumHeightTrees();
        System.out.print(test.findMinHeightTrees(n, a));
    }
}
