package main;

import com.sun.org.apache.xerces.internal.impl.dv.xs.UnionDV;
import com.sun.tracing.dtrace.ArgsAttributes;
import main.utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by shuaiwang on 11/12/16.
 */
public class FindtheConnectedComponentintheUndirectedGraph {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        HashSet<UndirectedGraphNode> visited = new HashSet<>();

        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                bfs(node, visited, result);
            }
        }
        return result;
    }

    private void bfs(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, List<List<Integer>> result) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> eachResult = new ArrayList<>();
        visited.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            visited.add(current);
            eachResult.add(current.label);
            for (UndirectedGraphNode n : current.neighbors) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }

            }
        }
        Collections.sort(eachResult);
        result.add(eachResult);
    }

    public static void main(String[] args) {
        FindtheConnectedComponentintheUndirectedGraph test = new FindtheConnectedComponentintheUndirectedGraph();
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(2);
        UndirectedGraphNode c = new UndirectedGraphNode(3);
        UndirectedGraphNode d = new UndirectedGraphNode(4);
        UndirectedGraphNode e = new UndirectedGraphNode(5);

        a.neighbors = Arrays.asList(b,d);
        b.neighbors = Arrays.asList(a,d);
        d.neighbors = Arrays.asList(a,b);

        c.neighbors = Arrays.asList(e);
        e.neighbors = Arrays.asList(c);

        ArrayList<UndirectedGraphNode> input = new ArrayList<>();
        input.add(a);
        input.add(b);
        input.add(c);
        input.add(d);
        input.add(e);
        test.connectedSet(input);

    }
}
