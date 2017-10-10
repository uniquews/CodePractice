public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[][] f = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            f[i][i] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[j][i] = 2;
                    } else {
                        f[j][i] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[j][i] = f[j + 1][i - 1] + 2;
                    } else {
                        f[j][i] = Math.max(f[j][i - 1], f[j + 1][i]);
                    }

                }
            }
        }
        return f[0][s.length() - 1];
    }
}
