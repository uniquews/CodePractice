import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shuaiwang on 7/6/17.
 */
/**
 *
 * 先remove哪个substring对结果有影响
 * "abcabd", ["ab","abcd"]
 *
 * */
public class RemoveSubstrings {
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = s.length();

        Queue<String> q = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        q.add(s);
        hashSet.add(s);

        while (!q.isEmpty()) {
            String str = q.poll();
            for (String subStr : dict) {
                int found = str.indexOf(subStr);
                while (found != -1) {
                    String tmp = str.substring(0, found) + str.substring(found + subStr.length());
                    if (!hashSet.contains(tmp)) {
                        q.add(tmp);
                        hashSet.add(tmp);
                    }
                    result = Math.min(result, tmp.length());
                    found = s.indexOf(subStr, found + 1);
                }
            }
        }
        return result;
    }
}
