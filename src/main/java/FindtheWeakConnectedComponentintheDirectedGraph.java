import utils.DirectedGraphNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 11/30/16.
 */
public class FindtheWeakConnectedComponentintheDirectedGraph {
    class UnionFind {
        private HashMap<DirectedGraphNode, DirectedGraphNode> parentMap;

        public UnionFind(ArrayList<DirectedGraphNode> nodes) {
            parentMap = new HashMap<>();
            for (DirectedGraphNode n : nodes) {
                parentMap.put(n, n);
            }
        }

        public void union(DirectedGraphNode a, DirectedGraphNode b) {
            DirectedGraphNode aParent = find(a);
            DirectedGraphNode bParent = find(b);
            parentMap.put(aParent, bParent);
        }

        public DirectedGraphNode find(DirectedGraphNode a) {
            DirectedGraphNode parent = parentMap.get(a);
            while (parent != parentMap.get(parent)) {
                parent = parentMap.get(parent);
            }

            DirectedGraphNode next = parentMap.get(a);
            while (next != parent) {
                DirectedGraphNode tmp = parentMap.get(next);
                parentMap.put(next, parent);
                next = tmp;
            }
            return parent;
        }

        public List<List<Integer>> buildResult() {
            List<List<Integer>> result = new ArrayList<>();
            HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

            for (DirectedGraphNode n : parentMap.keySet()) {
                DirectedGraphNode parent = find(n);
                if (!hashMap.containsKey(parent.label)) {
                    List<Integer> eachResult = new ArrayList<>();
                    hashMap.put(parent.label, eachResult);
                }
                hashMap.get(parent.label).add(n.label);
            }

            for (List list : hashMap.values()) {
                Collections.sort(list);
                result.add(list);
            }
            return result;
        }
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here

        UnionFind uf = new UnionFind(nodes);
        for (DirectedGraphNode n : nodes) {
            for (DirectedGraphNode neighbor : n.neighbors) {
                uf.union(n, neighbor);
            }
        }

        return uf.buildResult();
    }

    public static void main(String[] args) {
        FindtheWeakConnectedComponentintheDirectedGraph test = new FindtheWeakConnectedComponentintheDirectedGraph();
        DirectedGraphNode a = new DirectedGraphNode(1);
        DirectedGraphNode b = new DirectedGraphNode(2);
        DirectedGraphNode c = new DirectedGraphNode(3);
        DirectedGraphNode d = new DirectedGraphNode(4);
        DirectedGraphNode e = new DirectedGraphNode(5);
        DirectedGraphNode f = new DirectedGraphNode(6);

        a.neighbors.add(b);
        a.neighbors.add(d);
        b.neighbors.add(d);
        c.neighbors.add(e);
        f.neighbors.add(e);

        ArrayList<DirectedGraphNode> nodeList = new ArrayList<>();
        nodeList.add(a);
        nodeList.add(b);
        nodeList.add(c);
        nodeList.add(d);
        nodeList.add(e);
        nodeList.add(f);

        test.connectedSet2(nodeList);
    }

}
