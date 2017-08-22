import java.util.*;

/**
 * Created by shuaiwang on 2/8/17.
 */
public class WordBreakII {
//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        // Write your code here
//        HashMap<String, List<String>> hashMap = new HashMap<>();
//        return dfs(s, wordDict, hashMap);
//    }
//
//    private List<String> dfs(String s, Set<String> wordDict, HashMap<String, List<String>> hashMap) {
//        List<String> result = new ArrayList<>();
//        if (hashMap.containsKey(s))
//            return hashMap.get(s);
//
//        for (int i = 1; i <= s.length(); i++) {
//            StringBuilder sb = new StringBuilder();
//            String prefix = s.substring(0, i);
//            if (wordDict.contains(prefix)) {
//                sb.append(prefix).append(" ");
//
//                List<String> remainStrings = dfs(s.substring(i), wordDict, hashMap);
//                if (!remainStrings.isEmpty()) {
//                    for (int j = 0; j < remainStrings.size(); j++) {
//                        StringBuilder tmp = new StringBuilder(sb);
//                        String remain = remainStrings.get(j);
//                        result.add(tmp.append(remain).toString());
//                    }
//                } else {
//                    if (i == s.length()) {
//                        sb.setLength(sb.length() - 1);
//                        result.add(sb.toString());
//                    }
//                }
//            }
//        }
//        hashMap.put(s, result);
//        return result;
//    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }

        HashMap<String, List<String>> hashMap = new HashMap<>();
        return helper(s, dict, hashMap);
    }

    private List<String> helper(String s, Set<String> dict, HashMap<String, List<String>> map) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            if (dict.contains(current)) {
                String next = s.substring(i);
                List<String> allCuts = helper(next, dict, map);

                for (String str : allCuts) {
                    if (!str.equals(""))
                        result.add(current + " " + str);
                    else
                        result.add(current);
                }
            }
        }

        map.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII test = new WordBreakII();
//        String input = "lintcode";
//        List<String> s = new ArrayList<>(Arrays.asList("de", "ding", "co", "code", "lint"));

//        String input = "aaab";
//        List<String> s = new ArrayList<>(Arrays.asList("b", "aa"));

        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> s = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        List<String> result = test.wordBreak(input, s);
        System.out.print(result);
    }
}
