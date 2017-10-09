package fb;

import java.util.*;

public class CloneGraphFB {

    static class Node {
        int data;
        List<Node> neighbors;

        public Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }

        public Node(int data, List<Node> n) {
            this.data = data;
            this.neighbors = new ArrayList<>(n);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    static class Graph {
        List<Node> nodeList;

        public Graph() {
            this.nodeList = new ArrayList<>();
        }

        public Graph(List<Node> n) {
            this.nodeList = n;
        }

        public Graph copy() {
            Node start = this.nodeList.get(0);
            Map<Node, Node> map = new HashMap<>();
            Queue<Node> q = new LinkedList<>();
            Set<Node> visited = new HashSet<>();

            map.put(start, new Node(start.data));
            q.add(start);
            visited.add(start);

            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (Node n : cur.neighbors) {
                    if (map.containsKey(n)) {
                        map.get(cur).neighbors.add(map.get(n));
                    } else {
                        Node copyOfNeighbor = new Node(n.data);
                        map.get(cur).neighbors.add(copyOfNeighbor);
                        map.put(n, copyOfNeighbor);
                    }

                    if (!visited.contains(n)) {
                        q.add(n);
                        visited.add(n);
                    }
                }
            }

            List<Node> newListNode = new ArrayList<>();
            for (Node n : map.values()) {
                newListNode.add(n);
            }

            return new Graph(newListNode);
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.neighbors.add(b);
        a.neighbors.add(c);
        b.neighbors.add(a);
        b.neighbors.add(c);
        c.neighbors.add(a);
        c.neighbors.add(b);

        Graph g = new Graph(Arrays.asList(a, b, c));

        Graph copyOfG = g.copy();
        return;
    }
}
