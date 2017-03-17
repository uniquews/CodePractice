import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by shuaiwang on 3/16/17.
 */
public class MinimumUniqueWordAbbreviation {
    public String minAbbreviation(String target, String[] dictionary) {
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            dfs(dictionary[i].toCharArray(), 0, dict);
        }

        HashSet<String> targetSet = new HashSet<>();
        dfs(target.toCharArray(), 0, targetSet);

        String result = target;
        int minLen = target.length();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : targetSet) {
            String compressedString = compress(s.toCharArray(), hashMap);
            if (!dict.contains(s) && minLen > hashMap.get(compressedString)) {
                minLen = hashMap.get(compressedString);
                result = compressedString;
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

    private String compress(char[] s, HashMap<String, Integer> hashMap) {
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
        hashMap.put(sb.toString(), abbreviationLen);
        return sb.toString();
    }

    public static void main(String[] args) {
        String target = "aaaaaxaaaaa";
        String[] dic = {"bbbbbxbbbbb"};
        MinimumUniqueWordAbbreviation test = new MinimumUniqueWordAbbreviation();
        System.out.println(test.minAbbreviation(target, dic));
    }
}
