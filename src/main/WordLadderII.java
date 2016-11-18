package main;

import java.util.*;

/**
 * Created by shuaiwang on 11/17/16.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();

        boolean found = false;
        int level = 1;
        if (start.equals(end)) return result;

        Queue<String> q = new LinkedList<>();
        Map<String, Set<String>> path = new HashMap<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int currentQueueSize = q.size();
            while (currentQueueSize > 0) {
                String current = q.poll();
                for (int i = 0; i < current.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] tmp = current.toCharArray();
                        if (tmp[i] == c) continue;
                        tmp[i] = c;
                        String updateStr = new String(tmp);
                        if (updateStr.equals(end)) {
                            found = true;
                            updateMapping(path, current, updateStr);
                        }
                        if (dict.contains(updateStr)) {
                            q.offer(updateStr);
                            updateMapping(path, current, updateStr);
                        }
                    }
                }
                currentQueueSize--;
            }
            level++;
            if (found) {
                break;
            }
        }
        if (!found) {
            return result;
        }
        List<String> eachResult = new ArrayList<>();
        eachResult.add(end);
        HashSet<String> visited = new HashSet<>();
        visited.add(end);
        dfs(path, end, eachResult, result, start, visited, level);
        return result;
    }

    private void updateMapping(Map<String, Set<String>> path, String source, String target) {
        if (path.containsKey(target)) {
            path.get(target).add(source);
        } else {
            Set<String> parent = new HashSet<>(Arrays.asList(source));
            path.put(target, parent);
        }
    }

    private void dfs(Map<String, Set<String>> path, String target, List<String> eachResult, List<List<String>> result, String start, HashSet<String> visited, int level) {
        if (target == start && eachResult.size() == level) {
            Collections.reverse(eachResult);
            result.add(new ArrayList<>(eachResult));
            Collections.reverse(eachResult);
            return;
        }

        Set<String> sources = path.get(target);
        for (String s : sources) {
            if (!visited.contains(s)) {
                eachResult.add(s);
                visited.add(s);
                dfs(path, s, eachResult, result, start, visited, level);
                visited.remove(s);
                eachResult.remove(eachResult.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        WordLadderII test = new WordLadderII();
//        String start = "qa";
//        String end = "sq";
//        Set<String> dict = new HashSet<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));

        String start = "hot";
        String end = "dog";
        Set<String> dict = new HashSet<>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));

        test.findLadders(start, end, dict);
    }
}
