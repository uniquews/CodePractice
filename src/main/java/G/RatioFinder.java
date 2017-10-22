package G;

import java.util.*;

public class RatioFinder {
    class Edge {
        String currency;
        double val;
        Edge(String currency, double val) {
            this.currency = currency;
            this.val = val;
        }
    }

    // usd,gdp,0.69   pre-process的时候还要存 gdp, usd 1/0.69
    public double ratioFinder(String s, String t, Map<String, List<Edge>> graph) {
        if (s.equals(t)) {
            return 1.0;
        }

        if (!graph.containsKey(s) || !graph.containsKey(t)) {
            return -1.0;
        }

        Queue<Edge> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new Edge(s, 1.0));
        visited.add(s);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Edge cur = q.poll();
                if (cur.currency.equals(t)) {
                    return cur.val;
                }

                for (Edge next : graph.get(cur.currency)) {
                    if (visited.contains(next.currency)) {
                        continue;
                    }
                    Edge edge = new Edge(next.currency, next.val * cur.val);
                    q.add(edge);
                    visited.add(edge.currency);
                }
                size--;
            }
        }
        return -1.0;
    }
}
