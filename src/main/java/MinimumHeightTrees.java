import java.util.*;

/**
 * Created by shuaiwang on 5/3/17.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> tree = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (edges.length == 0) {
            result.add(0);
            return result;
        }
        for (int[] edge : edges) {
            if (!tree.containsKey(edge[0])) {
                tree.put(edge[0], new HashSet<>(Arrays.asList(edge[1])));
            } else {
                tree.get(edge[0]).add(edge[1]);
            }
            if (!tree.containsKey(edge[1])) {
                tree.put(edge[1], new HashSet<>(Arrays.asList(edge[0])));
            } else {
                tree.get(edge[1]).add(edge[0]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : tree.keySet()) {
            if (tree.get(key).size() == 1) {
                queue.add(key);
            }
        }

        int visited = n;
        while (visited > 2) {
            visited -= queue.size();
            Queue<Integer> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                Integer neighbor = tree.get(current).iterator().next();
                tree.get(neighbor).remove(current);
                if (tree.get(neighbor).size() == 1) {
                    nextLevel.add(neighbor);
                }
            }
            queue = nextLevel;
        }
        result.addAll(queue);
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] a = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        MinimumHeightTrees test = new MinimumHeightTrees();
        test.findMinHeightTrees(n, a);
    }
}
