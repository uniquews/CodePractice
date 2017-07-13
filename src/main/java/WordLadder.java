import java.util.*;

/**
 * Created by shuaiwang on 11/16/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();

        Set<String> dict = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String s : wordList) {
            dict.add(s);
        }

        int level = 1;
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (current.charAt(j) == c) {
                            continue;
                        }

                        char[] arr = current.toCharArray();
                        arr[j] = c;
                        String next = new String(arr);
                        if (dict.contains(next) && next.equals(endWord))
                            return level + 1;
                        if (dict.contains(next) && !visited.contains(next)) {
                            q.add(next);
                            visited.add(next);
                        }
                    }
                }
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
