import java.util.*;

/**
 * Created by shuaiwang on 11/16/16.
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        int level = 1;
        if (start.equals(end)) return level;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int currentQueueSize = q.size();
            while (currentQueueSize > 0) {
                String current = q.poll();
                for (int i = 0; i < current.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] tmp = current.toCharArray();
                        tmp[i] = c;
                        String updateStr = new String(tmp);
                        if (updateStr.equals(end)) {
                            level++;
                            return level;
                        }
                        if (dict.contains(updateStr) && !visited.contains(updateStr)) {
                            visited.add(updateStr);
                            q.offer(updateStr);
                        }
                    }
                }
                currentQueueSize--;
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";

        Set<String> s = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));

        WordLadder test = new WordLadder();
        System.out.print(test.ladderLength(start, end, s));
    }
}
