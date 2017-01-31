/**
 * Created by shuaiwang on 1/29/17.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == s.length())
            return true;
        return false;
    }
}
