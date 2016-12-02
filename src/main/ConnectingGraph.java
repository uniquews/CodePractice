package main;

import java.util.HashMap;

/**
 * Created by shuaiwang on 11/28/16.
 */
public class ConnectingGraph {
    private HashMap<Integer, Integer> parentMap = new HashMap<>();
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        for (int i = 1; i <= n; i++) {
            parentMap.put(i, i);
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int aParent = findParent(a);
        int bParent = findParent(b);
        union(aParent, bParent);
    }

    private void union(int a, int b) {
        parentMap.put(a, b);
    }

    private int findParent(int node) {
        int parent = parentMap.get(node);
        while (parent != parentMap.get(parent)) {
            parent = parentMap.get(parent);
        }

        int next = node;
        while (parent != parentMap.get(next)) {
            int tmp = parentMap.get(next);
            parentMap.put(next, parent);
            next = tmp;
        }
        return parent;
    }

    public boolean query(int a, int b) {
        // Write your code here
        return findParent(a) == findParent(b);
    }

    public static void main(String[] args) {
        ConnectingGraph cg = new ConnectingGraph(5);
        System.out.print(cg.query(1,2));
        cg.connect(1,2);
        System.out.print(cg.query(1,3));
        cg.connect(2,4);
        System.out.print(cg.query(1,4));
    }
}
