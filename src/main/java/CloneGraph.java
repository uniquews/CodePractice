import utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 11/13/16.
 */
public class CloneGraph {

    // clone node then edges
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null) {
//            return null;
//        }
//
//        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
//        Queue<UndirectedGraphNode> q = new LinkedList<>();
//
//        q.offer(node);
//        while (!q.isEmpty()) {
//            UndirectedGraphNode cur = q.poll();
//            UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
//            map.put(cur, copy);
//
//            for (UndirectedGraphNode n : cur.neighbors) {
//                if (map.containsKey(n)) {
//                    continue;
//                }
//                q.offer(n);
//            }
//        }
//
//        for (UndirectedGraphNode cur : map.keySet()) {
//            List<UndirectedGraphNode> list = cur.neighbors;
//            for (UndirectedGraphNode n : list) {
//                map.get(cur).neighbors.add(map.get(n));
//            }
//        }
//        return map.get(node);
//    }

    // dfs
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
//        dfs(node, map);
//        return map.get(node);
//    }
//
//    private void dfs(UndirectedGraphNode n, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
//        if (n == null) {
//            return;
//        }
//
//        if (map.containsKey(n)) {
//            return;
//        }
//        UndirectedGraphNode newElement = new UndirectedGraphNode(n.label);
//        map.put(n, newElement);
//        for (UndirectedGraphNode next : n.neighbors) {
//            dfs(next, map);
//            map.get(n).neighbors.add(map.get(next));
//        }
//        return;
//    }


    // bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode start) {
        if (start == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();

        map.put(start, new UndirectedGraphNode(start.label));
        q.add(start);


        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode n : cur.neighbors) {
                if (map.containsKey(n)) {
                    map.get(cur).neighbors.add(map.get(n));
                } else {
                    UndirectedGraphNode copyOfNeighbor = new UndirectedGraphNode(n.label);
                    map.get(cur).neighbors.add(copyOfNeighbor);
                    map.put(n, copyOfNeighbor);
                    q.add(n);
                }
            }
        }
        return map.get(start);
    }

    public static void main(String[] args) {
        CloneGraph test = new CloneGraph();
        UndirectedGraphNode a = new UndirectedGraphNode(0);
        a.neighbors.add(a);
        a.neighbors.add(a);
        test.cloneGraph(a);
    }
}
