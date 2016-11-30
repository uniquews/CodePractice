package main;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by shuaiwang on 11/29/16.
 */
public class ConnectingGraphIII {
    private HashMap<Integer, Integer> parentMap;
    private HashSet<Integer> parentList;

    public ConnectingGraphIII(int n) {
        // initialize your data structure here.
        parentList = new HashSet<>();
        parentMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            parentList.add(i);
            parentMap.put(i, i);
        }
    }

    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent != bParent) {
            parentMap.put(aParent, bParent);
            parentList.remove(aParent);
        }
    }

    private int find(int a) {
        int parent = parentMap.get(a);
        while (parent != parentMap.get(parent)) {
            parent = parentMap.get(parent);
        }

        int next = parentMap.get(a);
        while (next != parent) {
            int tmp = parentMap.get(next);
            parentMap.put(next, parent);
            next = tmp;
        }
        return parent;
    }

    public void connect(int a, int b) {
        // Write your code here
        union(a, b);
    }

    public int query() {
        // Write your code here
        return parentList.size();
    }

    public static void main(String[] args) {
        ConnectingGraphIII cg = new ConnectingGraphIII(5);
        System.out.print(cg.query());
        cg.connect(1,2);
        System.out.print(cg.query());
        cg.connect(2,4);
        System.out.print(cg.query());
        cg.connect(1,4);
        System.out.print(cg.query());
    }
}
