import java.util.*;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        // Key is the character node, value is a list of its children.
        HashMap<Character, List<Character>> graph = new HashMap<>();
        // Key is the character node, value is its in degree.
        HashMap<Character, Integer> indegree = new HashMap<>();

        buildGraph(words, graph, indegree);
        // 拓扑排序
        StringBuilder sb = new StringBuilder();

        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            Character parent = queue.poll();
            sb.append(parent);
            List<Character> children = graph.get(parent);
            for (Character child : children) {
                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (sb.toString().length() != graph.size())
            return "";
        return sb.toString();
    }

    private void buildGraph(String[] strs, Map<Character, List<Character>> graph, Map<Character, Integer> inDegreeMap) {
        for (int i = 0; i < strs.length - 1; i++) {
            addEachCharacterInStringToGraph(strs[i], graph, inDegreeMap);
            char[] edge = findEdgeBetweenString(strs[i], strs[i + 1]);
            if (edge != null) {
                inDegreeMap.put(edge[1], inDegreeMap.getOrDefault(edge[1], 0) + 1);
                graph.get(edge[0]).add(edge[1]);
            }
        }
        addEachCharacterInStringToGraph(strs[strs.length - 1], graph, inDegreeMap);
    }

    private void addEachCharacterInStringToGraph(
            String str, Map<Character, List<Character>> graph, Map<Character, Integer> inDegreeMap) {
        for (char c : str.toCharArray()) {
            graph.putIfAbsent(c, new ArrayList<>());
            inDegreeMap.putIfAbsent(c, 0);
        }
    }

    /**
     * Finds an edge between str1 and str2, str1 ranks higher than str2. Returns null if no edge can be found.
     */
    private char[] findEdgeBetweenString(String str1, String str2) {
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return new char[]{str1.charAt(i), str2.charAt(i)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] strings = {"ab", "ba", "cd"};
        // ["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"]

        AlienDictionary test = new AlienDictionary();
        String result = test.alienOrder(strings);
        System.out.println(result);

    }
}
