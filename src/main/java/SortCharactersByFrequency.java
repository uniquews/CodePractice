import java.util.*;

/**
 * Created by shuaiwang on 1/16/17.
 */
public class SortCharactersByFrequency {
//    class Node {
//        public char key;
//        public int occur;
//
//        public Node(char k, int o) {
//            key = k;
//            occur = o;
//        }
//
//    }
//    public String frequencySort(String s) {
//        Queue<Node> queue = new PriorityQueue<>((a,b) -> b.occur - a.occur);
//        HashMap<Character, Node> hashMap = new HashMap();
//        char[] input = s.toCharArray();
//
//        for (int i = 0; i < input.length; i++) {
//            if (hashMap.containsKey(input[i])) {
//                Node n = hashMap.get(input[i]);
//                n.occur += 1;
//                hashMap.put(input[i], n);
//            } else {
//                Node n = new Node(input[i], 1);
//                hashMap.put(input[i], n);
//            }
//        }
//
//        for (Node n : hashMap.values()) {
//            queue.add(n);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            Node n = queue.poll();
//            String cur = String.valueOf(n.key);
//            for (int i = 0; i < n.occur; i++) {
//                sb.append(cur);
//            }
//        }
//        return sb.toString();
//    }

//    public String frequencySort(String s) {
//        Map<Character, Integer> hashMap = new HashMap<>();
//        List<Character>[] occur = new List[s.length() + 1];
//
//        for (int i = 0; i < s.length(); i++) {
//            int value = hashMap.getOrDefault(s.charAt(i), 0);
//            hashMap.put(s.charAt(i), value + 1);
//        }
//
//        for (int i = 0; i < occur.length; i++) {
//            List l = new ArrayList();
//            occur[i] = l;
//        }
//
//        for (Character key : hashMap.keySet()) {
//            occur[hashMap.get(key)].add(key);
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = occur.length - 1; i >= 0; i--) {
//            for (Character c : occur[i]) {
//                int tmp = i;
//                while (tmp != 0) {
//                    sb.append(c);
//                    tmp--;
//                }
//
//            }
//        }
//        return sb.toString();
//    }

    public String frequencySort(String s) {
        if (s == null)
            return "";

        Map<Character, Integer> hashMap = new HashMap<>();
        List<Character>[] occur = new List[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            int t = hashMap.getOrDefault(s.charAt(i), 0);
            hashMap.put(s.charAt(i), t + 1);
        }

        for (char c : hashMap.keySet()) {
            if (occur[hashMap.get(c)] == null) {
                occur[hashMap.get(c)] = new ArrayList<>();
            }
            occur[hashMap.get(c)].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 1; i--) {
            if (occur[i] != null) {
                List<Character> l = occur[i];
                for (Character c : l) {
                    int times = i;
                    while (times != 0) {
                        sb.append(c);
                        times--;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency test = new SortCharactersByFrequency();
        test.frequencySort("tree");
    }
}
