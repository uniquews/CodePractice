import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuaiwang on 5/1/17.
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return 1;
            }
        });

        for (int i = 0; i < strs.length; i++) {
            boolean isBelongingToAnyOther = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (strs[i].length() <= strs[j].length()) {
                    // check if s is subsequence of strs[i]
                    if (isSub(strs[i], strs[j]))
                        isBelongingToAnyOther = true;
                } else {
                    break;
                }
            }

            if (!isBelongingToAnyOther) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean isSub(String a, String b) {
        int result = longestCommonSubsequence(a, b);
        return result == a.length();
    }

    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int[][] f = new int[A.length() + 1][B.length() + 1];

        f[0][0] = 0;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1; //  LCS(i - 1, j) <= 1 + LCS(i - 1, j - 1)
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[A.length()][B.length()];
    }

    public static void main(String[] args) {
        String[] a = {"aba","cdc","eae"};
        LongestUncommonSubsequenceII test = new LongestUncommonSubsequenceII();
        test.findLUSlength(a);
    }
}
