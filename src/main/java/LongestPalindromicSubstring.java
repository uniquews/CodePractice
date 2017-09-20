/**
 * Created by shuaiwang on 12/17/16.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0, end = 0, maxLen = 1;
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    f[i][j] = true;
                } else if (i == j + 1) {
                    f[j][i] = s.charAt(i) == s.charAt(j);
                } else {
                    f[j][i] = f[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
                }
                if (f[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                    end = i;
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
