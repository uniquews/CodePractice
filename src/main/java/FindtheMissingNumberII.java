import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 11/20/16.
 */
public class FindtheMissingNumberII {
    public int findMissing2(int n, String str) {
        // Write your code here
        Set<Integer> s = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        helper(n, str, 0, s, result);
        int i = 1;
        while (i <= n) {
            if (!result.contains(i)) {
                break;
            }
            i++;
        }
        return i;
    }

    private void helper(int n, String str, int start, Set<Integer> s, Set<Integer> result) {
        if (start == str.length() && s.size() == n - 1) { // Dont forget s.size() == n - 1!
            result.addAll(s);
            return;
        }

        for (int j = 1; j < 3; j++) {
            if (start + j <= str.length()) {
                String current = str.substring(start, start + j);
                if (isValid(n, current, s)) {
                    s.add(Integer.parseInt(current));
                    helper(n, str, start + j, s, result);
                    s.remove(Integer.parseInt(current));
                }
            }
        }
    }

    private boolean isValid(int n, String str, Set<Integer> s) {
        int current = Integer.parseInt(str);
        if (str.charAt(0) == '0' || s.contains(current) || current > n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindtheMissingNumberII test = new FindtheMissingNumberII();

        System.out.print(test.findMissing2(30, "1110986543271213130292826252423222120191817161514"));
    }
}
