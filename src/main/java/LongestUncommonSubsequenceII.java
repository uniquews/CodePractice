import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuaiwang on 5/1/17.
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSubForAnyOtherStr = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j)
                    continue;
                isSubForAnyOtherStr = isSubForAnyOtherStr || isSub(strs[i], strs[j]);
            }
            if (!isSubForAnyOtherStr)
                result = Math.max(result, strs[i].length());
        }
        return result;
    }

    private boolean isSub(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] a = {"aba","cdc","eae"};
        LongestUncommonSubsequenceII test = new LongestUncommonSubsequenceII();
        test.findLUSlength(a);
    }
}
