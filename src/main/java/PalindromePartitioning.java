import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 11/10/16.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> current = new ArrayList<>();
        helper(s, current, result, 0);
        return result;
    }

    private void helper(String s, List<String> current, List<List<String>> result, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String tmp = s.substring(start, i);
            if (!isPalindrome(tmp)) {
                continue;
            }
            current.add(tmp);
            helper(s, current, result, i);
            current.remove(current.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();
        String s = "a";
        test.partition(s);
    }
}
