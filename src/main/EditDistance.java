package main;

/**
 * Created by shuaiwang on 8/29/16.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1.length() == 0 && word2.length() == 0)
        {
            return 0;
        }

        if (word1.length() == 0)
        {
            return word2.length();
        }

        if (word2.length() == 0)
        {
            return word1.length();
        }

        int[][] f = new int[word1.length() + 1][word2.length() + 1];
        f[0][0] = 0;

        for (int i = 1; i <= word2.length(); i++)
        {
            f[0][i] = i;
        }

        for (int j = 1; j <= word1.length(); j++)
        {
            f[j][0] = j;
        }

        for (int i = 1; i <= word1.length(); i++)
        {
            for (int j = 1; j <= word2.length(); j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                {
                    f[i][j] = f[i - 1][j - 1];
                }
                else
                {
                    int tmp = Math.min(f[i - 1][j], f[i][j - 1]); // f[i - 1][j]: delete from word1; f[i][j - 1]: insert at the end of word1
                    f[i][j] = Math.min(f[i - 1][j - 1] + 1, tmp + 1);
                }
            }
        }

        return f[word1.length()][word2.length()];

    }
}
