import utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class SearchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            if (values.get(current) == target) {
                return current;
            }

            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!visited.contains(neighbor))
                    queue.add(neighbor);
            }
        }
        return null;
    }
}
