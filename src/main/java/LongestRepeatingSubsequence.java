public class LongestRepeatingSubsequence {
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        if (str == null || str.length() == 0) {
            return 0;
        }

        int[][] f = new int[str.length()][str.length()];

        f[0][0] = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(0) == str.charAt(i)) {
                f[0][i] = 1;
                f[i][0] = 1;
            }
        }

        for (int i = 1; i < str.length(); i++) {
            for (int j = 1; j < str.length(); j++) {
                if (i == j) {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                }
            }
        }
        return f[str.length() - 1][str.length() - 1];
    }
}
