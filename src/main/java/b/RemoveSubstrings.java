package b;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by bohan on 7/6/17.
 */
public class RemoveSubstrings {
    public int minLength(String s, Set<String> dict) {
        int min = s.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (visited.contains(str)) {
                continue;
            }
            min = Math.min(min, str.length());
            visited.add(str);
            for (String substring : dict) {
                int fromIndex = 0;
                while (fromIndex >= 0) {
                    fromIndex = str.indexOf(substring, fromIndex);
                    if (fromIndex < 0) {
                        break;
                    }
                    queue.offer(str.substring(0, fromIndex) + str.substring(fromIndex + substring.length()));
                    fromIndex++;
                }
            }
        }
        return min;
    }
}