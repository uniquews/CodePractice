import java.util.*;

/**
 * Created by shuaiwang on 2/8/17.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        HashMap<String, List<String>> hashMap = new HashMap<>();
        return dfs(s, wordDict, hashMap);
    }

    private List<String> dfs(String s, Set<String> wordDict, HashMap<String, List<String>> hashMap) {
        List<String> result = new ArrayList<>();
        if (hashMap.containsKey(s))
            return hashMap.get(s);

        for (int i = 1; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                sb.append(prefix).append(" ");

                List<String> remainStrings = dfs(s.substring(i), wordDict, hashMap);
                if (!remainStrings.isEmpty()) {
                    for (int j = 0; j < remainStrings.size(); j++) {
                        StringBuilder tmp = new StringBuilder(sb);
                        String remain = remainStrings.get(j);
                        result.add(tmp.append(remain).toString());
                    }
                } else {
                    if (i == s.length()) {
                        sb.setLength(sb.length() - 1);
                        result.add(sb.toString());
                    }
                }
            }
        }
        hashMap.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII test = new WordBreakII();
//        String input = "lintcode";
//        Set<String> s = new HashSet<>(Arrays.asList("de", "ding", "co", "code", "lint"));

//        String input = "aaab";
//        Set<String> s = new HashSet<>(Arrays.asList("b", "aa"));

        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Set<String> s = new HashSet<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        System.out.print(test.wordBreak(input, s));
    }
}
