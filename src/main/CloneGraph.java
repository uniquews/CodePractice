package main;

import main.utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 11/13/16.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        ArrayList<UndirectedGraphNode> allNodes = getAllNodesByBFS(node);

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for (UndirectedGraphNode cur : allNodes) {
            UndirectedGraphNode newCur = new UndirectedGraphNode(cur.label);
            map.put(cur, newCur);
        }

        for (UndirectedGraphNode current : allNodes) {
            UndirectedGraphNode newCurrent = map.get(current);
            for (UndirectedGraphNode neighbor : current.neighbors) {
                newCurrent.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getAllNodesByBFS(UndirectedGraphNode start) {
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(start);
        set.add(start);

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode node : current.neighbors) {
                if (!set.contains(node)) {
                    queue.add(node);
                    set.add(node);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
