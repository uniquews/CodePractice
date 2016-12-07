import utils.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 11/14/16.
 */
public class TopologicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            for (DirectedGraphNode neighbor : cur.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
}
