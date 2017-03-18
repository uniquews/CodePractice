import java.util.*;

/**
 * Created by shuaiwang on 3/16/17.
 */
public class MinimumUniqueWordAbbreviation {
    class ReturnType {
        public String str;
        public Integer abbr;
        public ReturnType(String t, int i) {
            str = t;
            abbr = i;
        }
    }
    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) {
            return String.valueOf(target.length());
        }
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            dfs(dictionary[i].toCharArray(), 0, dict);
        }

        HashSet<String> targetSet = new HashSet<>();
        dfs(target.toCharArray(), 0, targetSet);

        String result = target;
        int minLen = target.length();

        for (String s : targetSet) {
            ReturnType entry = compress(s.toCharArray());
            if (!dict.contains(s) && minLen > entry.abbr) {
                minLen = entry.abbr;
                result = entry.str;
            }
        }
        return result;
    }

    private void dfs(char[] s, int index, HashSet<String> hashSet) {
        hashSet.add(String.valueOf(s));
        for (int i = index; i < s.length; i++) {
            char tmp = s[i];
            s[i] = '1';
            dfs(s, i + 1, hashSet);
            s[i] = tmp;
        }
    }

    private ReturnType compress(char[] s) {
        StringBuilder sb = new StringBuilder();
        int abbreviationLen = 0;
        for (int i = 0; i < s.length; i++) {
            int j = i;
            int num = 0;
            while (j < s.length && s[j] == '1') {
                j++;
                num++;
            }
            if (i == j) {
                sb.append(s[i]);
            } else {
                sb.append(num);
                i = j - 1;
            }
            abbreviationLen++;
        }
        return new ReturnType(sb.toString(), abbreviationLen);
    }

    public static void main(String[] args) {
        String target = "aaaaaxaaaaa";
        String[] dic = {"bbbbbxbbbbb"};
        MinimumUniqueWordAbbreviation test = new MinimumUniqueWordAbbreviation();
        System.out.println(test.minAbbreviation(target, dic));
    }
}
