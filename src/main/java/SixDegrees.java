import utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 11/10/16.
 */
public class SixDegrees {
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        if (s == t) {
            return 0;
        }

        Map<UndirectedGraphNode, Integer> visited = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        visited.put(s, 0);
        queue.offer(s);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            int step = visited.get(current);
            for (int i = 0; i < current.neighbors.size(); i++) {
                UndirectedGraphNode next = current.neighbors.get(i);
                if (visited.containsKey(next)) {
                    continue;
                }
                visited.put(next, step + 1);
                queue.offer(next);
                if (next == t) {
                    return step + 1;
                }
            }
        }
        return -1;
    }
}
