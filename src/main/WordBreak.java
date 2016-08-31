package main;

import java.util.Set;

/**
 * Created by shuaiwang on 8/30/16.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null)
        {
            return false;
        }

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        int maxLength = getMaxLength(dict);

        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (i - j > maxLength)
                {
                    break;
                }
                String tmp = s.substring(j, i);
                f[i] = f[i] || f[j] && dict.contains(tmp);
            }
        }

        return f[s.length()];
    }

    private int getMaxLength (Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
