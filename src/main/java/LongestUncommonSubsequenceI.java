/**
 * Created by shuaiwang on 5/1/17.
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                return 0;
            } else {
                return a.length();
            }
        } else {
            return a.length() > b.length() ? a.length() : b.length();
        }
    }
}
