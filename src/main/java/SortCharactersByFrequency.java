import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by shuaiwang on 1/16/17.
 */
public class SortCharactersByFrequency {
    class Node {
        public char key;
        public int occur;

        public Node(char k, int o) {
            key = k;
            occur = o;
        }

    }
    public String frequencySort(String s) {
        Queue<Node> queue = new PriorityQueue<>((a,b) -> b.occur - a.occur);
        HashMap<Character, Node> hashMap = new HashMap();
        char[] input = s.toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (hashMap.containsKey(input[i])) {
                Node n = hashMap.get(input[i]);
                n.occur += 1;
                hashMap.put(input[i], n);
            } else {
                Node n = new Node(input[i], 1);
                hashMap.put(input[i], n);
            }
        }

        for (Node n : hashMap.values()) {
            queue.add(n);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            String cur = String.valueOf(n.key);
            for (int i = 0; i < n.occur; i++) {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        System.out.print(sb.toString());
    }
}
