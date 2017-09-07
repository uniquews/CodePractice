import java.time.temporal.ChronoField;
import java.util.*;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) {
            return sb.toString();
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                graph.putIfAbsent(words[i].charAt(j), new HashSet<>());
                degree.putIfAbsent(words[i].charAt(j), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s = words[i];
            String t = words[i + 1];
            int j = 0;
            while (j < s.length() && j < t.length() && s.charAt(j) == t.charAt(j)) {
                j++;
            }
            if (j < s.length() && j < t.length()) {
                if (!graph.get(s.charAt(j)).contains(t.charAt(j))) {
                    graph.get(s.charAt(j)).add(t.charAt(j));
                    degree.put(t.charAt(j), degree.get(t.charAt(j)) + 1);
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (Character c : degree.keySet()) {
            if (degree.get(c) == 0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            Character current = q.poll();
            sb.append(current);
            Set<Character> set = graph.get(current);
            for (Character c : set) {
                degree.put(c, degree.get(c) - 1);
                if (degree.get(c) == 0) {
                    q.add(c);
                }
            }
        }
        if (sb.length() != degree.size()) return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"za","zb","ca","cb"};
        // ["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"]
        // "za","zb","ca","cb"

        AlienDictionary test = new AlienDictionary();
        String result = test.alienOrder(strings);
        System.out.println(result);

    }
}
