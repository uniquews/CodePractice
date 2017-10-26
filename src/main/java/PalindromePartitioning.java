import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 11/10/16.
 */
public class PalindromePartitioning {
//    public List<List<String>> partition(String s) {
//        // write your code here
//        List<List<String>> result = new ArrayList<>();
//        if (s == null || s.length() == 0) {
//            return result;
//        }
//
//        List<String> current = new ArrayList<>();
//        helper(s, current, result, 0);
//        return result;
//    }
//
//    private void helper(String s, List<String> current, List<List<String>> result, int start) {
//        if (start == s.length()) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        for (int i = start + 1; i <= s.length(); i++) {
//            String tmp = s.substring(start, i);
//            if (!isPalindrome(tmp)) {
//                continue;
//            }
//            current.add(tmp);
//            helper(s, current, result, i);
//            current.remove(current.size() - 1);
//        }
//    }
//
//    private boolean isPalindrome(String s) {
//        int start = 0;
//        int end = s.length() - 1;
//        while (start <= end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    public List<List<String>> partition(String s) {
        boolean[][] map = new boolean[s.length()][s.length()];
        Map<Integer, List<List<String>>> cache = new HashMap<>();
        return dfs(s, 0, cache, map);
    }

    private List<List<String>> dfs(String s, int index, Map<Integer, List<List<String>>> cache, boolean[][] map) {
        List<List<String>> result = new ArrayList<>();
        if (index == s.length()) {
            result.add(new ArrayList<>());
            return result;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }


        for (int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);
            if (!isValid(map, s, index, i - 1)) {
                continue;
            }
            List<List<String>> nextResult = dfs(s, i, cache, map);
            if (nextResult == null) {
                continue;
            }
            for (List<String> list : nextResult) {
                List<String> eachResult = new ArrayList(list);
                eachResult.add(cur);
                result.add(eachResult);
            }
        }

        if (result.isEmpty()) {
            return null;
        }
        cache.put(index, result);
        return result;
    }

    private boolean isValid(boolean[][] map, String s, int i, int j) {
        if (i == j) {
            map[i][i] = true;
            return true;
        }

        if (i == j - 1) {
            map[i][j] = true;
            return s.charAt(i) == s.charAt(j);
        }

        return map[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
    }

    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();
        String s = "abbab";
        test.partition(s);
    }
}
