package main;

import java.util.HashMap;

/**
 * Created by shuaiwang on 11/29/16.
 */
public class ConnectingGraphII {
    private HashMap<Integer, Integer> parentMap;
    private HashMap<Integer, Integer> sizeMap;
    public ConnectingGraphII(int n) {
        // initialize your data structure here.
        parentMap = new HashMap<>();
        sizeMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            parentMap.put(i, i);
            sizeMap.put(i, 1);
        }
    }

    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent != bParent) {
            parentMap.put(aParent, bParent);
            int sizeOfA = sizeMap.get(aParent);
            int sizeOfB = sizeMap.get(bParent);
            sizeMap.put(bParent, sizeOfA + sizeOfB);
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

    public int query(int a) {
        // Write your code here
        return sizeMap.get(find(a));
    }

    public static void main(String[] args){
        ConnectingGraphII cg = new ConnectingGraphII(5);
        System.out.print(cg.query(1));
        cg.connect(1,2);
        System.out.print(cg.query(1));
        cg.connect(2,4);
        System.out.print(cg.query(1));
        cg.connect(1,4);
        System.out.print(cg.query(1));
    }
}
