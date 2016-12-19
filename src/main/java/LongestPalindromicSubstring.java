/**
 * Created by shuaiwang on 12/17/16.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        }

        boolean[][] f = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j)
                    f[i][j] = true;
            }
        }

        int maxLen = 1, start = 0, end = 0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j == i - 1 || f[j + 1][i - 1])) {
                    f[j][i] = true;
                    if (maxLen < i - j + 1) {
                        maxLen = Math.max(maxLen, i - j + 1);
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        String s = "bb";
        System.out.print(test.longestPalindrome(s));
    }
}
