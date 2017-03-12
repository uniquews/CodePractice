import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by shuaiwang on 3/12/17.
 */
public class EvaluateDivision {
    // way 1: dfs. This can also be done by union find

    class Node {
        public String n;
        public double v;
        public Node(String name, double value) {
            n = name;
            v = value;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // build map
        HashMap<String, HashSet<Node>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String begin = equations[i][0];
            String end = equations[i][1];

            Node startNode = new Node(equations[i][0], 1.0 / values[i]);
            Node endNode = new Node(equations[i][1], values[i]);

            if (!map.containsKey(begin)) {
                map.put(begin, new HashSet<>(Arrays.asList(endNode)));
            } else {
                map.get(begin).add(endNode);
            }

            if (!map.containsKey(equations[i][1])) {
                map.put(end, new HashSet<>(Arrays.asList(startNode)));
            } else {
                map.get(end).add(startNode);
            }
        }

        // dfs
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String begin = queries[i][0];
            String end = queries[i][1];
            HashSet<String> visited = new HashSet<>();
            result[i] = dfs(begin, end, 1.0, map, visited);
        }
        return result;
    }

    private double dfs(String current, String end, double base, HashMap<String, HashSet<Node>> map, HashSet<String> visited) {
        if (!map.containsKey(current)) {
            return -1.0;
        }

        if (visited.contains(current)) {
            return -1.0;
        }

        visited.add(current);

        if (current.equals(end)) {
            return base;
        }

        HashSet<Node> neighbors = map.get(current);
        for (Node n : neighbors) {
            double result = dfs(n.n, end, base * n.v, map, visited);
            if (result != -1) {
                return result;
            }
        }
        return  -1.0;
    }


    public static void main(String[] args) {
        String[][] equation = {{"a","b"}, {"b","c"}};
        double[] values = {2.0,3.0};
        String[][] queries = { {"a","c"},{"b","c"},{"a","e"},{"a","a"}, {"x", "x"}};

        EvaluateDivision test = new EvaluateDivision();
        test.calcEquation(equation, values, queries);
    }
}
