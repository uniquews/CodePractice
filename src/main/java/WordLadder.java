import java.util.*;

/**
 * Created by shuaiwang on 11/16/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }

        int level = 1;
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String cur = q.poll();
                for (int i = 0; i < cur.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (cur.charAt(i) == j) {
                            continue;
                        }
                        String next = cur.substring(0, i) + j + cur.substring(i + 1);
                        if (dict.contains(next)) {
                            dict.remove(next);
                            if (next.equals(endWord)) {
                                return level + 1;
                            } else {
                                q.add(next);
                            }
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";

//        Set<String> s = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
//
//        WordLadder test = new WordLadder();
//        System.out.print(test.ladderLength(start, end, s));
    }
}
