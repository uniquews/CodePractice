import utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 11/13/16.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        map.put(node, start);

        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode child : cur.neighbors) {
                if (!map.containsKey(child)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(child.label);
                    map.put(child, copy);
                    q.add(child);
                }
            }
        }

        for (UndirectedGraphNode cur : map.keySet()) {
            List<UndirectedGraphNode> list = cur.neighbors;
            for (UndirectedGraphNode n : list) {
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        CloneGraph test = new CloneGraph();
        UndirectedGraphNode a = new UndirectedGraphNode(0);
        a.neighbors.add(a);
        a.neighbors.add(a);
        test.cloneGraph(a);
    }
}
