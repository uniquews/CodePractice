package G;

import java.util.*;

/**
 *
 * 两个人有relation是'E' or 'F', eg.  0 <-> 1 is 'E', 1 <-> 2 is 'E', 2 <-> 3 is 'F',
 * 给一个input String chain eg. "EEF", 一个int start, 一个int end, print 从start到end的一条path,
 * 使这条path的relation是chain里的string, in this case is "0123" （tuple [0, 1, 'F'] [1, 2, 'F']）
 *
 * */

public class RelationPath {
    // （tuple [0, 1, 'F'] [1, 2, 'F']）

    public Map<Character, Map<Character, List<Character>>> constructGraph(List<List<Character>> relation)  {
        Map<Character, Map<Character, List<Character>>> graph = new HashMap<>();

        for (List<Character> list : relation) {
            Character start = list.get(0);
            Character end = list.get(1);
            Character r = list.get(2);

            if (graph.containsKey(start)) {
                Map<Character, List<Character>> startRelation = graph.get(start);
                List<Character> tmp = startRelation.getOrDefault(r, new ArrayList<>());
                tmp.add(end);
                startRelation.put(r, tmp);

            } else {
                Map<Character, List<Character>> startRelation = new HashMap<>();
                startRelation.put(r, new ArrayList<>(Arrays.asList(end)));
                graph.put(start, startRelation);
            }

            if (graph.containsKey(end)) {
                Map<Character, List<Character>> endRelation = graph.get(end);
                List<Character> tmp = endRelation.getOrDefault(r, new ArrayList<>());
                tmp.add(start);
                endRelation.put(r, tmp);
            } else {
                Map<Character, List<Character>> endRelation = new HashMap<>();
                endRelation.put(r, new ArrayList<>(Arrays.asList(start)));
                graph.put(end, endRelation);
            }

        }
        return graph;
    }


    public String relationPath(char start, char end, String relation, Map<Character, Map<Character, List<Character>>> graph) {
        if (start == end) {
            return String.valueOf(start);
        }

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        dfs(start, end, 0, relation, sb, graph);
        return sb.toString();
    }

    private boolean dfs(char cur, char end, int index, String relation, StringBuilder sb, Map<Character, Map<Character, List<Character>>> graph) {
        if (index == relation.length()) {
            if (cur == end) {
                sb.append(cur);
                return true;
            }
            return false;
        }

        int len = sb.length();
        sb.append(cur);

        Map<Character, List<Character>> self = graph.get(cur);
        List<Character> list = self.get(relation.charAt(index));
        for (Character c : list) {
            if (dfs(c, end, index + 1, relation, sb, graph)) {
                return true;
            }
        }
        sb.setLength(len);
        return false;
    }

}
