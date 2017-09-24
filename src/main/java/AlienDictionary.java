import java.time.temporal.ChronoField;
import java.util.*;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class AlienDictionary {
//    public String alienOrder(String[] words) {
//        StringBuilder sb = new StringBuilder();
//        if (words == null || words.length == 0) {
//            return sb.toString();
//        }
//
//        Map<Character, Set<Character>> graph = new HashMap<>();
//        Map<Character, Integer> degree = new HashMap<>();
//
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words[i].length(); j++) {
//                graph.putIfAbsent(words[i].charAt(j), new HashSet<>());
//                degree.putIfAbsent(words[i].charAt(j), 0);
//            }
//        }
//
//        for (int i = 0; i < words.length - 1; i++) {
//            String s = words[i];
//            String t = words[i + 1];
//            int j = 0;
//            while (j < s.length() && j < t.length() && s.charAt(j) == t.charAt(j)) {
//                j++;
//            }
//            if (j < s.length() && j < t.length()) {
//                if (!graph.get(s.charAt(j)).contains(t.charAt(j))) {
//                    graph.get(s.charAt(j)).add(t.charAt(j));
//                    degree.put(t.charAt(j), degree.get(t.charAt(j)) + 1);
//                }
//            }
//        }
//
//        Queue<Character> q = new LinkedList<>();
//        for (Character c : degree.keySet()) {
//            if (degree.get(c) == 0) {
//                q.add(c);
//            }
//        }
//
//        while (!q.isEmpty()) {
//            Character current = q.poll();
//            sb.append(current);
//            Set<Character> set = graph.get(current);
//            for (Character c : set) {
//                degree.put(c, degree.get(c) - 1);
//                if (degree.get(c) == 0) {
//                    q.add(c);
//                }
//            }
//        }
//        if (sb.length() != degree.size()) return "";
//        return sb.toString();
//    }


    /**
     *
     * 只有一个单词的时候要返回一个单词
     * a -> b的pair出现过就不要再更新graph 和 degree
     * 遇到第一个不一样的char 就break
     * */

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            helper(graph, degree, words[i]);
        }

        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            String a = words[i];
            String b = words[j];

            int k = 0;
            while (k < a.length() && k < b.length()) {
                char c1 = a.charAt(k);
                char c2 = b.charAt(k);
                if (c1 == c2) {
                    k++;
                    continue;
                }
                if (!graph.get(c1).contains(c2)) {
                    graph.get(c1).add(c2);
                    degree.put(c2, degree.get(c2) + 1);
                }
                break;
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (Character c : degree.keySet()) {
            if (degree.get(c) == 0) {
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            sb.append(cur);
            Set<Character> set = graph.get(cur);
            for (Character n : set) {
                degree.put(n, degree.get(n) - 1);
                if (degree.get(n) == 0) {
                    q.add(n);
                }
            }
        }
        return sb.length() == degree.size() ? sb.toString() : "";
    }


    private void helper(Map<Character, Set<Character>> graph, Map<Character, Integer> degree, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            graph.putIfAbsent(c1, new HashSet<>());
            degree.putIfAbsent(c1, 0);
        }
    }

    public static void main(String[] args) {

        String[] strings = {"za","zb","ca","cb"};
//        String[] strings = {"wrt","wrf","er","ett","rftt"};
        // ["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"]
        // "za","zb","ca","cb"

        AlienDictionary test = new AlienDictionary();
        String result = test.alienOrder(strings);
        System.out.println(result);

    }
}
