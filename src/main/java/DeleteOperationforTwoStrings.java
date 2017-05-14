/**
 * Created by shuaiwang on 5/14/17.
 */
public class DeleteOperationforTwoStrings {
    // 这道题其实就是LCS
    public int minDistance(String word1, String word2) {
        int[][] f = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - f[word1.length()][word2.length()] * 2;
    }
}
