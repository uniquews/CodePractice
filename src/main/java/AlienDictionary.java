import java.time.temporal.ChronoField;
import java.util.*;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        // build graph
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            maxLen = Math.max(words[i].length(), maxLen);
        }

        HashMap<String, List<String>> setOfString = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }

            String tmp = String.valueOf(words[i].charAt(0));
            char tmpChar = words[i].charAt(0);
            if (setOfString.containsKey(tmp)) {
                setOfString.get(tmp).add(words[i]);
            } else {
                setOfString.put(tmp, new ArrayList<>(Arrays.asList(words[i])));
            }

            if (i == 0) {
                indegree.put(tmpChar, 0);
                graph.put(tmpChar, new ArrayList<>());
            } else {
                if (i > 0 && !tmp.equals(String.valueOf(words[i - 1].charAt(0)))) {
                    if (graph.containsKey(words[i - 1].charAt(0))) {
                        graph.get(words[i - 1].charAt(0)).add(tmpChar);
                    } else {
                        graph.put(words[i - 1].charAt(0), new ArrayList<>(Arrays.asList(tmpChar)));
                    }

                    if (indegree.containsKey(tmpChar)) {
                        indegree.put(tmpChar, indegree.get(tmpChar) + 1);
                    } else {
                        indegree.put(tmpChar, 1);
                    }
                }

                if (!indegree.containsKey(tmpChar)) {
                    indegree.put(tmpChar, 0);
                }
                if (!graph.containsKey(tmpChar)) {
                    graph.put(tmpChar, new ArrayList<>());
                }
            }
        }

        for (int i = 1; i < maxLen; i++) {
            HashMap<String, List<String>> tmpSetOfString = new HashMap<>();
            for (List<String> list : setOfString.values()) {
                for (int j = 0; j < list.size(); j++) {
                    String s = list.get(j);
                    if (s.length() - 1 < i) {
                        continue;
                    }

                    char current = s.charAt(i);
                    String subStr = s.substring(0, i + 1);
                    if (j == 0) {
                        if (!indegree.containsKey(current)) {
                            indegree.put(current, 0);
                        }
                        if (!graph.containsKey(current)) {
                            graph.put(current, new ArrayList<>());
                        }
                    } else {
                        char parent = list.get(j - 1).charAt(i);
                        if (list.get(j - 1).length() >= i + 1 && s.charAt(i) != parent) {
                            if (!graph.containsKey(parent)) {
                                graph.put(parent, new ArrayList<>(Arrays.asList(current)));
                            } else {
                                graph.get(parent).add(current);
                            }
                            if (!indegree.containsKey(current)) {
                                indegree.put(current, 1);
                            } else {
                                indegree.put(current, indegree.get(current) + 1);
                            }
                        }

                        if (!graph.containsKey(current)) {
                            graph.put(current, new ArrayList<>());
                        }
                        if (!indegree.containsKey(current)) {
                            indegree.put(current, 0);
                        }
                    }

                    if (tmpSetOfString.containsKey(subStr)) {
                        tmpSetOfString.get(subStr).add(s);
                    } else {
                        tmpSetOfString.put(subStr, new ArrayList<>(Arrays.asList(s)));
                    }
                }
            }

            setOfString.clear();
            setOfString.putAll(tmpSetOfString);
            tmpSetOfString.clear();
        }

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

    public static void main(String[] args) {
        String[] strings = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        // ["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"]

        AlienDictionary test = new AlienDictionary();
        String result = test.alienOrder(strings);
        System.out.println(result);

    }
}
